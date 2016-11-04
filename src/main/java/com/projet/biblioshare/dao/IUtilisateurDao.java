package com.projet.biblioshare.dao;

import java.util.List;

import com.projet.biblioshare.entity.Utilisateur;

public interface IUtilisateurDao {
	public List<Utilisateur> listUser();
	public void addUser(Utilisateur u);
	public void saveUser(Utilisateur u);
	public Utilisateur loginUser(Utilisateur u);
	public Utilisateur searchUserByPseudo (String pseudo);
	public void removeUser(int id);

}
 