package com.projet.biblioshare.service;

import java.util.List;

import com.projet.biblioshare.entity.Livre;
import com.projet.biblioshare.entity.Utilisateur;

public interface IUtilisateurService {
	public List<Utilisateur> listUser();
	public void addUser(Utilisateur u);
	public int checkUserName(Utilisateur u);
	public Utilisateur rechercherUser(int idUser);
	public void removeUser(int id);
	public void saveUser(Utilisateur u);
	public Utilisateur loginUser(Utilisateur u);
	public void telechargerLivre(Utilisateur utilisateur,int idLivre);
	public int dejaTelechargerLivre(Utilisateur utilisateur,int idLivre);
	public List<Livre> afficherLivreUser(Utilisateur utilisateur);
	public int CountNbLivresUsers(Utilisateur utilisateur);
	public int verifierCredit(Utilisateur utilisateur,int idLivre);
	public List<Livre> showLivreByAuthor(Utilisateur utilisateur,int idAuteur);
	public List<Livre> showLivreByCategory(Utilisateur utilisateur,int idCategorie);
	public List<Livre> showLivreByEditor(Utilisateur utilisateur,int idEditeur);
	public List<Livre> showLivreByCollection(Utilisateur utilisateur,int idCollection);
	public Utilisateur demanderAmis(Utilisateur utilisateur,int idUser);
	public void accepterAmis(Utilisateur utilisateur,int IdUser);
	public List<Utilisateur> afficherNotification(Utilisateur utilisateur);
	public int dejaAmis(Utilisateur utilisateur,int iduser2);
	public int demandeDejaEnvoyer(Utilisateur utilisateur,int iduser2);

}
