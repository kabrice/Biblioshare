package com.projet.biblioshare.service;

import java.util.List;

import com.projet.biblioshare.entity.Utilisateur;

public interface IUtilisateurService {
	public List<Utilisateur> listUser();
	public void addUser(Utilisateur u);
	public void removeUser(int id);
	public void saveUser(Utilisateur u);
	public Utilisateur loginUser(Utilisateur u);

}
