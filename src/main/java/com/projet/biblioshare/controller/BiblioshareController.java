package com.projet.biblioshare.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.biblioshare.entity.Categorie;

import com.projet.biblioshare.entity.Utilisateur;
import com.projet.biblioshare.form.UtilisateurForm;
import com.projet.biblioshare.service.ICategorieService;
import com.projet.biblioshare.service.IUtilisateurService;
import com.projet.biblioshare.validation.CategorieValidation;
import com.projet.biblioshare.validation.UtilisateurValidation;






@Controller
public class BiblioshareController {
	// champs
	// autowire pour prendre en compte l'injection des d�pendences
	@Autowired
	private IUtilisateurService utilisateurService;

	@Autowired
	private ICategorieService categorieService;
	
	

	// LA GESTION DES UTILISATEURS
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String listerUser(Model model) {
		List<Utilisateur> lstuser = this.utilisateurService.listUser();
		model.addAttribute("listeUser", lstuser);
		return "lst-users";
	}

	// RENVOIS LE FORMULAIRE DE CREATION DE COMPTE

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showForm(Model model) {
		
		//on recupere les roles pour les afficher dans le formulaire

		model.addAttribute("userData", new Utilisateur());
		return "register";

	}

	// CREATION DU COMPTE ET ENREGISTREMENT DES DONNEES
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String saveRegister(Model model, @ModelAttribute("userData") @Valid Utilisateur utilisateur,
			BindingResult br, HttpSession session) {
		
		UtilisateurValidation uv = new UtilisateurValidation();
		uv.validate(uv, br);
		if (br.hasErrors()) {
			return "login";
		} else {
			// cette methode enregistre un nouvel utilisateur l'utilisateur
			utilisateurService.addUser(utilisateur);
			session.setAttribute("utilisateur", utilisateur);
			return "success";
		}

	}

	// RENVOIS LE FORMULAIRE D'authetification
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

	// redirige ves la page d'acceuil en cas de succes d'autentification
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLogin(Model model, @ModelAttribute("userData") Utilisateur utilisateur, HttpSession session) {
		// System.out.println("inside login using POST method\n");

		// System.out.println(utilisateur.getUsername() + " " +
		// utilisateur.getPassword());

		try {
			utilisateur = utilisateurService.loginUser(utilisateur);
			if (utilisateur != null) {
				session.setAttribute("utilisateur", utilisateur);
				return "acceuil";
			}
		} catch (Exception e) {

			return "login";
		}
		model.addAttribute("failed", "echec de connection");
		return "login";

	}

	// d�connexion
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String doLogout(Model model, HttpSession session) {

		session.removeAttribute("utilisateur");
		return "redirect:login";

	}

	// en cas de success de connection
	@RequestMapping(value = "/acceuil", method = RequestMethod.GET)
	public String showSuccess(Model model) {
		model.addAttribute("acceuil", new Utilisateur());

		return "acceuil";

	}
	
	// affichier userProfile
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String showUserProfile() {
		
		return "userProfile";

	}
	
	@RequestMapping(value = "supprimer", method = RequestMethod.POST)
	public String supprimerUser(UtilisateurForm uf, Model model) {
		utilisateurService.removeUser(uf.getCode());
		listerUser(model);
		return "lst-users";
	}

	// GESTION DES Categories

	/* formulaire de creation d'une categorie */

	@RequestMapping(value = "creercategorie", method = RequestMethod.GET)
	public String creeLivreForm(Model model) {

		model.addAttribute("categorieData", new Categorie());
		return "creercategorie";

	}

	/* formulaire d'enregistrement d'une categorie */
	@RequestMapping(value = "creercategorie", method = RequestMethod.POST)
	public String saveCategorie(Model model, @ModelAttribute("categorieData") @Valid Categorie categorie,
			BindingResult br) {
		CategorieValidation cv=new CategorieValidation();
		cv.validate(cv, br);
		if (br.hasErrors()) {
			return "creercategorie";
		} else {
			// cette methode enregistre une nouvelle categorie
			categorieService.creerCategorie(categorie);
			
			return "success";
		}

	}

}
