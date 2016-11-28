package com.projet.biblioshare.service;

import java.util.List;

import com.projet.biblioshare.dao.IActivitelivreamiDao;
import com.projet.biblioshare.entity.ActiviteLivreAmi;
import com.projet.biblioshare.entity.Utilisateur;

public interface IActivitelivreamiService {
	
	void setActivitelivreamiDao(IActivitelivreamiDao activitelivreamiDao);
	
	public List<ActiviteLivreAmi> afficherLivreEmprunte(Utilisateur utilisateur);

	List<ActiviteLivreAmi> afficherLivreRemi(Utilisateur utilisateur);

	List<ActiviteLivreAmi> afficherLivrePrete(Utilisateur utilisateur);

	List<ActiviteLivreAmi> afficherLivreAttente(Utilisateur utilisateur);

	void demandeEmpruntLivre(Utilisateur utilisateur);

	void resutatEmpruntLivre(Utilisateur utilisateur);

}