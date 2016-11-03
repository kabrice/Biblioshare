package com.projet.biblioshare.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projet.biblioshare.dao.IUtilisateurDao;
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
	

}
