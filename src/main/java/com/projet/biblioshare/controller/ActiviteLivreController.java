package com.projet.biblioshare.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.biblioshare.entity.ActiviteLivreAmi;
import com.projet.biblioshare.entity.Utilisateur;
import com.projet.biblioshare.service.IActivitelivreamiService;


@Controller
public class ActiviteLivreController {
	
	// Champs
	@Autowired
	public IActivitelivreamiService activitelivreamiService;
	
	
	// liste les livres emprunter par l'utilisateur connecter
	@RequestMapping(value = "emprunte", method = RequestMethod.GET)
	public String listerLivresEmpruntes(Model model, Utilisateur utilisateur, HttpSession session) {
	
		System.out.println("Ah non non l'erreur du controller");
		System.out.println(activitelivreamiService);
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		if( activitelivreamiService != null && utilisateur != null ){
			
			System.out.println("Le resultat activitelivreamiService  = "+activitelivreamiService);
		}
	    List<ActiviteLivreAmi> listeLivreEmprunte = this.activitelivreamiService.afficherLivreEmprunte(utilisateur);
		//model.addAllAttributes(listeLivreEmprunte);
		model.addAttribute("listeLivreEmpruntes", listeLivreEmprunte);
		
		for(ActiviteLivreAmi livre:  listeLivreEmprunte){
			if(livre == null)System.out.println("Rien ici");
			System.out.println("livre = "+ livre.getLivre().getId());
	}
		
		System.out.println("ok ok ok = "+ model.addAttribute("listeLivreEmpruntes", listeLivreEmprunte));
		
		return "list_livres_emprunte";
	}

	// liste les livres en attente de l'utilisateur connecter
	@RequestMapping(value = "attente", method = RequestMethod.GET)
	public String listerLivresAttentes(Model model) {
		
		return "list_livre_attente";
	}
	
	// liste les livres remis de l'utilisateur connecter
	@RequestMapping(value = "remi", method = RequestMethod.GET)
	public String listerLivresRemis(Model model) {
		
		return "list_livre_remi";
	}
	
	// liste les livres preter de l'utilisateur connecter
	@RequestMapping(value = "prete", method = RequestMethod.GET)
	public String listerLivresPretes(Model model, Utilisateur utilisateur, HttpSession session) {
		System.out.println("Ah non non l'erreur du controller");
		System.out.println(activitelivreamiService);
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		if( activitelivreamiService != null && utilisateur != null ){
			
			System.out.println("Le resultat activitelivreamiService  = "+activitelivreamiService);
		}
	    List<ActiviteLivreAmi> listeLivrePretes = this.activitelivreamiService.afficherLivrePrete(utilisateur);
		//model.addAllAttributes(listeLivreEmprunte);
		model.addAttribute("listeLivrePretes", listeLivrePretes);
		
		for(ActiviteLivreAmi livre:  listeLivrePretes){
			if(livre == null)System.out.println("Rien ici");
			System.out.println("livre = "+ livre.getLivre().getId());
	}
		
		System.out.println("ok ok ok = "+ model.addAttribute("listeLivrePretes", listeLivrePretes));
		
		return "list_livres_prete";
	}
}
