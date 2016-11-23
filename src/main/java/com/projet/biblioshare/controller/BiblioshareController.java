 package com.projet.biblioshare.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.biblioshare.entity.Categorie;
import com.projet.biblioshare.entity.Livre;
import com.projet.biblioshare.entity.Utilisateur;
import com.projet.biblioshare.service.ICategorieService;
import com.projet.biblioshare.service.ILivreService;
import com.projet.biblioshare.service.IUtilisateurService;
import com.projet.biblioshare.validation.UtilisateurValidation;

@Controller
public class BiblioshareController {
	// champs
	// autowire pour prendre en compte l'injection des d�pendences
	@Autowired
	private IUtilisateurService utilisateurService;

	@Autowired
	private ILivreService livreService;
	
	@Autowired
	private ICategorieService categorieService ;

	/**
	 * retourne la liste des utilisateurs
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String listerUser(Model model) {
		List<Utilisateur> lstuser = this.utilisateurService.listUser();
		model.addAttribute("listeUser", lstuser);
		return "lst-users";
	}

	@RequestMapping(value = "livres", method = RequestMethod.GET)
	public String listerLivre(Model model) {
		List<Livre> listeLivre = this.livreService.listerLivre();
		model.addAttribute("listeLivres", listeLivre);
		return "lst-livres";
	}

	@RequestMapping(value = "/telecharger/{id}", method = RequestMethod.GET)
	public String telechargerLivre(Model model, Utilisateur utilisateur, HttpSession session, @PathVariable("id") int id) {
		
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		int dejaTel = utilisateurService.dejaTelechargerLivre(utilisateur, id);
		int testDebit=utilisateurService.verifierCredit(utilisateur, id);
		
		if(testDebit==0){
			session.setAttribute("credit_insuffisant", "vous n'avez plus assez d'argent pour achter un livre");
			  return bookshare(model);
		}
		else{
			if (dejaTel == 0) {

				session.setAttribute("deja_telecharger", "vous avez deja télécharger ce livre");
				return "redirect:../bookshare";
			} else {
				//System.out.println("livre telecharger");
				utilisateurService.telechargerLivre(utilisateur, id);
				//return showSuccess(model, session);
				return "redirect:../acceuil";
				
			}
		}
		

	}
	
	
	@RequestMapping(value = "/categorie/{id}", method = RequestMethod.GET)
	public String trierLivreParCategorie(Model model, Utilisateur utilisateur, HttpSession session, @PathVariable("id") int id) {
		
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		List<Livre> LBC=utilisateurService.showLivreByCategory(utilisateur, id);
		model.addAttribute("LBC",LBC);
		session.setAttribute("LBC", LBC);
		for(Livre l: LBC){
			System.out.println("identifiant "+l.getId()+ " libelle "+l.getLibelle());
		}
		return "redirect:../acceuil";
	}

	/**
	 * enregistre un utilisateur dans la base de donnéées
	 * 
	 * @param model
	 * @param utilisateur
	 * @param br
	 * @param session
	 * @return
	 */

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String doRegister(Model model, @ModelAttribute("userData") @Valid Utilisateur utilisateur, BindingResult br,
			HttpSession session) {

		UtilisateurValidation uv = new UtilisateurValidation();
		uv.validate(uv, br);
		if (br.hasErrors()) {
			return "login";
		} else {
			// cette methode enregistre un nouvel utilisateur l'utilisateur avec
			// username inique
			int is = utilisateurService.checkUserName(utilisateur);
			if (is == 1) {
				utilisateurService.addUser(utilisateur);
				session.setAttribute("utilisateur", utilisateur);
				return "redirect:acceuil";
			} else {
				model.addAttribute("var_username", "nom d'utilisateur existant");
				return "login";
			}

		}

	}

	/**
	 * retourne le formulaire de creation de compte et d'authentification
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String showLogin(Model model, HttpSession session) {
		System.out.println("inside login using GET method\n");
		
		if (session.getAttribute("utilisateur") == null) {
			model.addAttribute("userData", new Utilisateur());
			return "login";
		} else {
			return "redirect:acceuil";
		}

	}

	/**
	 * fonction qui permet de s'authentifier
	 * 
	 * @param model
	 * @param utilisateur
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLogin(Model model, @ModelAttribute("userData") Utilisateur utilisateur, HttpSession session) {

		try {
			utilisateur = utilisateurService.loginUser(utilisateur);
			if (utilisateur != null) {
				session.setAttribute("utilisateur", utilisateur);
				System.out.println("je me logge");
				return "redirect:acceuil";
				// return "success";
			}
		} catch (Exception e) {

			return "login";
		}
		model.addAttribute("failed", "echec de connection");
		return "login";

	}

	/**
	 * déconnecte l'utilisateur
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String doLogout(Model model, HttpSession session) {

		session.removeAttribute("utilisateur");
		return "redirect:login";

	}

	/**
	 * page dacceuil
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/acceuil", method = RequestMethod.GET)
	public String showSuccess(Model model, HttpSession session) {

		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		// liste des livres d'un utilisateur
		List<Livre> lstLivreUser = utilisateurService.afficherLivreUser(utilisateur);
		// affiche le nombre des users
		int nbLivreUser = utilisateurService.CountNbLivresUsers(utilisateur);
		//int idCategorie=(Integer) session.getAttribute("idCategorie");
		//liste des livres 
		
		List<Utilisateur> listeAmis=utilisateurService.listerAmis(utilisateur);
		List<Categorie> listeCategorie=categorieService.listerCategorie();
		List<Utilisateur> lstUsers=utilisateurService.listUser();
		
//		for(Utilisateur u:listeAmis){
//			System.out.println("nom user "+u.getUsername());
//		}
//		
		model.addAttribute("listeAmis", listeAmis);
		model.addAttribute("listeUtilisateur",lstUsers);
		model.addAttribute("listeCategorie", listeCategorie);
		model.addAttribute("livresUsers", lstLivreUser);
		model.addAttribute("acceuil", new Utilisateur());
		model.addAttribute("nbLivreUser", nbLivreUser);
		return "acceuil";

	}
	
	

	@RequestMapping(value = "/bookshare", method = RequestMethod.GET)
	public String bookshare( Model model) {
		// liste de tous les livres de la bibliothèque
		List<Livre> nouveauteLivre=livreService.listerNouveauLivre();
		List<Livre> listeLivre = this.livreService.listerLivre();
		
		model.addAttribute("listeLivres", listeLivre);
		model.addAttribute("newLivres", nouveauteLivre);
		return "bookstore";
	}
	
	@RequestMapping(value = "/demande_amis/{idAmis}", method = RequestMethod.GET)
	public String demandeAmis( Model model, Utilisateur utilisateur, HttpSession session,@PathVariable("idAmis") int idAmis) {
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		int dejaDemander=utilisateurService.demandeDejaEnvoyer(utilisateur, idAmis);
		System.err.println("//////////////////////////////////////////////");
		System.err.println("valeur retourné "+dejaDemander);
		if(dejaDemander==0){
			model.addAttribute("deja_envoyer", "vous avez deja envoyer une demande a cet utilisateur");
			return showSuccess(model, session);
		}
		else
		{
			utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			Utilisateur recepteur =utilisateurService.rechercherUser(idAmis);
			int id= recepteur.getId();
			Utilisateur demandeur = utilisateurService.demanderAmis(utilisateur, id);
			
			return "redirect:../acceuil";
		}
		
	}
	
	@RequestMapping(value = "/mes_notification", method = RequestMethod.GET)
	public String afficherNotification( Model model, Utilisateur utilisateur, HttpSession session) {
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		List<Utilisateur> demandeurs = utilisateurService.afficherNotification(utilisateur);
		model.addAttribute("liste_demandes", demandeurs);
		
		return "notifications";
	}
	
	@RequestMapping(value = "/ajouter_amis/{idAmis}", method = RequestMethod.GET)
	public String accepterAmis( Model model, Utilisateur utilisateur, HttpSession session,@PathVariable("idAmis") int idAmis) {
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		utilisateurService.accepterAmis(utilisateur, idAmis);
		model.addAttribute("nouvel_amis", utilisateurService.rechercherUser(idAmis));
		
		return "redirect:../acceuil";
	}
	
	
	
	

}
