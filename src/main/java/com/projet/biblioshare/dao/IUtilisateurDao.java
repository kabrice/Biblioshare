package com.projet.biblioshare.dao;

import java.util.List;

import com.projet.biblioshare.entity.Livre;
import com.projet.biblioshare.entity.Utilisateur;

public interface IUtilisateurDao {
	public List<Utilisateur> listUser();
	public void addUser(Utilisateur u);
	public int checkUserName(Utilisateur u);
	
	public void saveUser(Utilisateur u);
	public Utilisateur loginUser(Utilisateur u);
	public void removeUser(int id);
	public void telechargerLivre(Utilisateur utilisateur,int idLivre);
	public int dejaTelechargerLivre(Utilisateur utilisateur,int idLivre);
	public List<Livre> afficherLivreUser(Utilisateur utilisateur);
	public int CountNbLivresUsers(Utilisateur utilisateur);

}
 