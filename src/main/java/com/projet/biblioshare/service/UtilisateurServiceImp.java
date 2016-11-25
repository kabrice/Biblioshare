package com.projet.biblioshare.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projet.biblioshare.dao.IUtilisateurDao;
import com.projet.biblioshare.entity.Livre;
import com.projet.biblioshare.entity.Utilisateur;


@Transactional
public class UtilisateurServiceImp implements IUtilisateurService{
	
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


	@Override
	public int verifierCredit(Utilisateur utilisateur, int idLivre) {
		// TODO Auto-generated method stub
		return utilisateurDao.verifierCredit(utilisateur, idLivre);
	}


	@Override
	public List<Livre> showLivreByAuthor(Utilisateur utilisateur, int idAuteur) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Livre> showLivreByCategory(Utilisateur utilisateur, int idCategorie) {
		// TODO Auto-generated method stub
		return utilisateurDao.showLivreByCategory(utilisateur, idCategorie);
	}


	@Override
	public List<Livre> showLivreByEditor(Utilisateur utilisateur, int idEditeur) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Livre> showLivreByCollection(Utilisateur utilisateur, int idCollection) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Utilisateur demanderAmis(Utilisateur utilisateur,int idUser){
		return utilisateurDao.demanderAmis(utilisateur, idUser);
		
	}


	@Override
	public void accepterAmis(Utilisateur utilisateur, int IdUser) {
		utilisateurDao.accepterAmis(utilisateur, IdUser);
		
	}


	@Override
	public Utilisateur rechercherUser(int idUser) {
		// TODO Auto-generated method stub
		return utilisateurDao.rechercherUser(idUser);
	}


	@Override
	public List<Utilisateur> afficherNotification(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurDao.afficherNotification(utilisateur);
	}

	@Override
	public int demandeDejaEnvoyer(Utilisateur utilisateur, int iduser2) {
		// TODO Auto-generated method stub
		return utilisateurDao.demandeDejaEnvoyer(utilisateur, iduser2);
	}


	@Override
	public List<Utilisateur> listerAmis(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurDao.listerAmis(utilisateur);
				
	}


	@Override
	public List<Utilisateur> listerNonAmis(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurDao.listerUserPasAmis(utilisateur);
	}


	@Override
	public void refuseAmis(Utilisateur utilisateur, int IdUser) {
		utilisateurDao.refuseAmis(utilisateur, IdUser);
		
	}
	

}
