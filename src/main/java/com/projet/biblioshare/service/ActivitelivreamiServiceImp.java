package com.projet.biblioshare.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projet.biblioshare.dao.IActivitelivreamiDao;
import com.projet.biblioshare.entity.ActiviteLivreAmi;
import com.projet.biblioshare.entity.Utilisateur;

@Transactional
public class ActivitelivreamiServiceImp implements IActivitelivreamiService{
	
	private IActivitelivreamiDao activitelivreamiDao;

	public void setActivitelivreamiDao(IActivitelivreamiDao activitelivreamiDao) {
		this.activitelivreamiDao = activitelivreamiDao;
	}
	
	@Override
	public List<ActiviteLivreAmi> afficherLivreEmprunte(Utilisateur utilisateur) {
		return activitelivreamiDao.afficherLivreEmprunte(utilisateur);
	}

	@Override
	public List<ActiviteLivreAmi> afficherLivreRemi(Utilisateur utilisateur) {
		return activitelivreamiDao.afficherLivreRemi(utilisateur);
	}

	@Override
	public List<ActiviteLivreAmi> afficherLivrePrete(Utilisateur utilisateur) {
		return activitelivreamiDao.afficherLivrePrete(utilisateur);
	}

	@Override
	public List<ActiviteLivreAmi> afficherLivreAttente(Utilisateur utilisateur) {
		return activitelivreamiDao.afficherLivreAttente(utilisateur);
	}
	
	@Override
	public void demandeEmpruntLivre(Utilisateur utilisateur) {
		activitelivreamiDao.demandeEmpruntLivre(utilisateur);
	}

	@Override
	public void resutatEmpruntLivre(Utilisateur utilisateur) {
		activitelivreamiDao.resutatEmpruntLivre(utilisateur);
	}
}
