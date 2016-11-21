package com.projet.biblioshare.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projet.biblioshare.dao.IUtilisateurDao;
import com.projet.biblioshare.entity.Livre;
import com.projet.biblioshare.entity.Utilisateur;

@Transactional
public abstract class UtilisateurServiceImp implements IUtilisateurService {

	private IUtilisateurDao utilisateurDao;

	public void setUtilisateurDao(IUtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public void addUser(Utilisateur u) {
		// TODO Auto-generated method stub
		utilisateurDao.addUser(u);
	}

	@Override
	public List<Utilisateur> listUser() {
		// TODO Auto-generated method stub
		return utilisateurDao.listUser();
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		utilisateurDao.removeUser(id);
	}

	@Override
	public void saveUser(Utilisateur u) {
		// TODO Auto-generated method stub
		utilisateurDao.saveUser(u);
	}

	@Override
	public Utilisateur loginUser(Utilisateur u) {
		// TODO Auto-generated method stub
		return utilisateurDao.loginUser(u);
	}

	@Override
	public int checkUserName(Utilisateur u) {
		// TODO Auto-generated method stub
		return utilisateurDao.checkUserName(u);
	}

	@Override
	public void telechargerLivre(Utilisateur utilisateur, int idLivre) {
		// TODO Auto-generated method stub
		utilisateurDao.telechargerLivre(utilisateur, idLivre);
	}

	@Override
	public int dejaTelechargerLivre(Utilisateur utilisateur, int idLivre) {
		// TODO Auto-generated method stub
		return utilisateurDao.dejaTelechargerLivre(utilisateur, idLivre);
	}

	@Override
	public List<Livre> afficherLivreUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurDao.afficherLivreUser(utilisateur);
	}

	@Override
	public int CountNbLivresUsers(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurDao.CountNbLivresUsers(utilisateur);
	}

	// NKOMO Marcelin

	@Override
	public int getNbAmis(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurDao.getNbAmis(utilisateur);
	}

	@Override
	public int getNbLivre(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurDao.getNbLivre(utilisateur);
	}

	@Override
	public void modifMotDePasse(Utilisateur utilisateur, String pwd) {
		// TODO Auto-generated method stub
		utilisateurDao.modifMotDePasse(utilisateur, pwd);
	}

	@Override
	public void supprimerCompte(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		utilisateurDao.supprimerCompte(utilisateur);
	}

	@Override
	public void modifEmail(Utilisateur utilisateur, String email) {
		// TODO Auto-generated method stub
		utilisateurDao.modifEmail(utilisateur, email);
	}

	@Override
	public Utilisateur chercheUser(String pseudo) {
		return utilisateurDao.chercheUser(pseudo);
	}

	@Override
	public List<Utilisateur> listDemandeAmis(Utilisateur userCourant) {
		
		return utilisateurDao.listDemandeAmis(userCourant);
	};
	@Override
	public List<Utilisateur> listAmis(Utilisateur user) {
		
		return utilisateurDao.listAmis(user);
	};

}
