package com.projet.biblioshare.dao;

import java.util.List;

import com.projet.biblioshare.entity.ActiviteLivreAmi;
import com.projet.biblioshare.entity.Utilisateur;

public interface IActivitelivreamiDao {

	/*
		 * User1 = emprunteur
		 * user2 = preteur
		 * EtatEmprunt = 1 (livre emprunté à user1 et preter par user2
		 * EtatEmprunt = 2 (livre emprunté à user1 et preter par user2
		 */
	List<ActiviteLivreAmi> afficherLivreEmprunte(Utilisateur utilisateur);

	List<ActiviteLivreAmi> afficherLivreRemi(Utilisateur utilisateur);

	List<ActiviteLivreAmi> afficherLivrePrete(Utilisateur utilisateur);

	List<ActiviteLivreAmi> afficherLivreAttente(Utilisateur utilisateur);

	// methode pour faire une demande d'emprunt de livre
	void demandeEmpruntLivre(Utilisateur utilisateur);

	// methode pour faire pour accepter ou refuser une demande d'emprunt de livre
	void resutatEmpruntLivre(Utilisateur utilisateur);

}