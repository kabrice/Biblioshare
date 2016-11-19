package com.projet.biblioshare.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.biblioshare.entity.Utilisateur;
import com.projet.biblioshare.service.IUtilisateurService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private IUtilisateurService utilisateurService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	
	
	// marcelin nkomo : verifie que l'utilistaeur est connecté pour afficher son profile
	
	
	
		@RequestMapping(value = "userProfile", method = RequestMethod.GET)
		public String ouvrirUserProfile(Locale locale, Model model,HttpSession session,Utilisateur user) {
			int id ;
			user=(Utilisateur)session.getAttribute("utilisateur");
			
			if (user == null) {
					
				return "redirect:login";
			} else {
				
				id=(int)user.getId();
				model.addAttribute("nb_livre", utilisateurService.getNbLivre(user));
				model.addAttribute("nb_amis", utilisateurService.getNbAmis(user));
				model.addAttribute("nom_user", user.getNom());
				model.addAttribute("prenom_user", user.getPrenom());
				model.addAttribute("username_user", user.getUsername());
				return "userProfile";
			}
		}
		
		@RequestMapping(value = "accueil", method = RequestMethod.GET)
		public String retourPageAccueil(Locale locale, Model model,HttpSession session) {
			if (session.getAttribute("utilisateur") == null) {
				return "redirect:login";
			} else {

				return "accueil";
			}

		}
		
		
		
		
		@RequestMapping(value = "change_email", method = RequestMethod.GET)
		public String ouvrirModifEmail(Locale locale, Model model,HttpSession session,Utilisateur user) {
			int id ;
			user=(Utilisateur)session.getAttribute("utilisateur");
			
			if (user == null) {
					
				return "redirect:login";
			} else {
				
				return "modifEmail";
			}
		}
		
		
		@RequestMapping(value = "change_password", method = RequestMethod.GET)
		public String ouvrirModifPassword(Locale locale, Model model,HttpSession session,Utilisateur user) {
			int id ;
			user=(Utilisateur)session.getAttribute("utilisateur");
			
			if (user == null) {
					
				return "redirect:login";
			} else {
				
				return "modifPassword";
			}
		}
		
		
		
		
		@RequestMapping(value = "change_email", method = RequestMethod.POST)
		public String doModifEmail(Locale locale, Model model,HttpSession session,Utilisateur user,HttpServletRequest request) {
			user=(Utilisateur)session.getAttribute("utilisateur");
			String email=request.getParameter("email");
			String newEmail=request.getParameter("newEmail");
			String newEmailVerifs=request.getParameter("NewEmailVerif");
			
			if(email.equals(user.getEmail())){
				
				 if(newEmail.equals(newEmailVerifs)){
					 
					 utilisateurService.modifEmail(user, newEmail);
					 return"redirect:userProfile";
				 }else{
					 model.addAttribute("msg_bad_email_verif"," Les emails ne correspondent pas!");
				 }
				 
				 
				 return"redirect:change_email";
				 
			}else{
				model.addAttribute("msg_bad_email"," Email incorrect !");
			}
			
			return"redirect:change_email";
		}
		
		
		@RequestMapping(value = "change_password", method = RequestMethod.POST)
		public String doModifPassword(Locale locale, Model model,HttpSession session,Utilisateur user,HttpServletRequest request) {
			user=(Utilisateur)session.getAttribute("utilisateur");
			String pass=request.getParameter("pass");
			String newPass=request.getParameter("NewPass");
			String newPassVerif=request.getParameter("NewPassVerif");
			 BiblioshareController biblioshareController = new BiblioshareController();
			
			if(pass.equals(user.getPassword())){
				
				 if(newPass.equals(newPassVerif)){
					 
					 utilisateurService.modifMotDePasse(user, newPass);
					 biblioshareController.doLogout(model, session);	 
					 return"redirect:login";
				 }else{
					 model.addAttribute("msg_bad_pwd_verif"," Les mots de passe ne correspondent pas!");
				 }
				 
				 
				 return"redirect:change_password";
				 
			}else{
				model.addAttribute("msg_bad_pwd"," Mot de passe incorrect !");
			}
			
			return"redirect:change_password";
		}
	

}
