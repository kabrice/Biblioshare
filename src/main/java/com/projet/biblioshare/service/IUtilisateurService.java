package com.projet.biblioshare.service;

import java.util.List;

import com.projet.biblioshare.entity.Livre;
import com.projet.biblioshare.entity.Utilisateur;

public interface IUtilisateurService {
	public List<Utilisateur> listUser();

	public void addUser(Utilisateur u);

	public int checkUserName(Utilisateur u);

	public void removeUser(int id);

	public void saveUser(Utilisateur u);

	public Utilisateur loginUser(Utilisateur u);

	public void telechargerLivre(Utilisateur utilisateur, int idLivre);

	public int dejaTelechargerLivre(Utilisateur utilisateur, int idLivre);

	public List<Livre> afficherLivreUser(Utilisateur utilisateur);

	public int CountNbLivresUsers(Utilisateur utilisateur);

	// marcelin NKOMO
	public int getNbLivre(Utilisateur utilisateur);

	public int getNbAmis(Utilisateur utilisateur);

	public void modifMotDePasse(Utilisateur utilisateur, String pwd);

	public void modifEmail(Utilisateur utilisateur, String email);

	public void supprimerCompte(Utilisateur utilisateur);
	
	//Lilian PARISATO
	
	public Utilisateur chercheUser(String pseudo);
}
