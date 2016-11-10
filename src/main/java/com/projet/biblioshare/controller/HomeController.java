package com.projet.biblioshare.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.biblioshare.dao.UtilisateurDaoImp;
import com.projet.biblioshare.entity.Utilisateur;
import com.projet.biblioshare.service.IUtilisateurService;
import com.projet.biblioshare.service.UtilisateurServiceImp;

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
	
	@RequestMapping(value = "/bookshare", method = RequestMethod.GET)
	public String bookshare(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "bookstore";
	}
	
	
	
	// marcelin nkomo : verifie que l'utilistaeur est connecté pour afficher son profile
	
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String retourPageAccueil(Locale locale, Model model,HttpSession session) {
		if (session.getAttribute("utilisateur") == null) {
			return "redirect:login";
		} else {

			return "accueil";
		}

	}

}
