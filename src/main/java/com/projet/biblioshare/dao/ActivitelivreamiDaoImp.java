package com.projet.biblioshare.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.projet.biblioshare.entity.ActiviteLivreAmi;
import com.projet.biblioshare.entity.Livre;
import com.projet.biblioshare.entity.Utilisateur;

public class ActivitelivreamiDaoImp implements IActivitelivreamiDao{
	
	@PersistenceContext
	private EntityManager em;
		/*
		 * User1 = emprunteur
		 * user2 = preteur
		 * EtatEmprunt = 1 (livre emprunté à user1 et preter par user2
		 * EtatEmprunt = 2 (livre emprunté à user1 et preter par user2
		 */
	@Override
	public  List<ActiviteLivreAmi> afficherLivreEmprunte(Utilisateur utilisateur){
		int idUser=utilisateur.getId();
		List<ActiviteLivreAmi> lesLivreEmpruntes = new ArrayList<ActiviteLivreAmi>();
		System.out.println("cette erreur viens de la requete");
		try {
			Query query = em.createNativeQuery("SELECT livre.IdLivre FROM activitelivreami, utilisateur, livre "
					+ " WHERE utilisateur.IdUser=activitelivreami.IdUser1 "
					+ " AND activitelivreami.IdLivre = livre.IdLivre "
					+ " AND activitelivreami.IdUser1 <> activitelivreami.IdUser2 "
					+ " AND activitelivreami.EtatEmprunt is NOT NULL "
					+ " AND IdUser=:user");
			query.setParameter("user",idUser );
			//query.executeUpdate();
			
			System.out.println("query = "+ query);
		//	System.out.println("OKKKKK = "+query.getResultList().getClass().getName());
			List<Integer> lesidlivres =  query.getResultList();
			
			System.out.println("lesidlivres = "+ lesidlivres);
			
			for(Integer identifiant : lesidlivres){
			//lesLivreEmpruntes.add(em.find(ActiviteLivreAmi.class, identifiant));

			lesLivreEmpruntes.add(new ActiviteLivreAmi(new Livre (identifiant)));
			}
			System.out.println("lesLivreEmpruntesnxfvnfdvdfhvfbfvfkvjdfjvjkbdvjbdfvbjkd");
			return lesLivreEmpruntes;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/* 
	 *Affiche la liste des livres Remi
	 */
	@Override
	public  List<ActiviteLivreAmi> afficherLivreRemi(Utilisateur utilisateur){
		int idUser=utilisateur.getId();
		List<ActiviteLivreAmi> lesLivreRemi = new ArrayList<ActiviteLivreAmi>();
		
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* 
	 * Affiche la liste des livres preter
	 */
	@Override
	public  List<ActiviteLivreAmi> afficherLivrePrete(Utilisateur utilisateur){
		int idUser=utilisateur.getId();
		List<ActiviteLivreAmi> lesLivrePretes = new ArrayList<ActiviteLivreAmi>();
		
		System.out.println("cette erreur viens de la requete");
		try {
			Query query = em.createNativeQuery("SELECT livre.IdLivre FROM activitelivreami, utilisateur, livre "
					+ " WHERE utilisateur.IdUser=activitelivreami.IdUser2 "
					+ " AND activitelivreami.IdLivre = livre.IdLivre "
					+ " AND activitelivreami.IdUser1 <> activitelivreami.IdUser2 "
					+ " AND activitelivreami.EtatEmprunt is NOT NULL "
					+ " AND IdUser2=:user");
			query.setParameter("user",idUser );
			//query.executeUpdate();
			
			System.out.println("query = "+ query);
		//	System.out.println("OKKKKK = "+query.getResultList().getClass().getName());
			List<Integer> lesidlivres =  query.getResultList();
			
			System.out.println("lesidlivres = "+ lesidlivres);
			
			for(Integer identifiant : lesidlivres){
			//lesLivreEmpruntes.add(em.find(ActiviteLivreAmi.class, identifiant));

				lesLivrePretes.add(new ActiviteLivreAmi(new Livre (identifiant)));
			}
			System.out.println("lesLivreEmpruntesnxfvnfdvdfhvfbfvfkvjdfjvjkbdvjbdfvbjkd");
			return lesLivrePretes;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	

	/* 
	 * Affiche la liste des livre en attente
	 */
	@Override
	public  List<ActiviteLivreAmi> afficherLivreAttente(Utilisateur utilisateur){
		int idUser=utilisateur.getId();
		List<ActiviteLivreAmi> lesLivreAttente = new ArrayList<ActiviteLivreAmi>();
		
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// methode pour faire une demande d'emprunt de livre
	@Override
	public void demandeEmpruntLivre(Utilisateur utilisateur){
		int idUser=utilisateur.getId();
		Utilisateur utilEmprunt = em.find(Utilisateur.class, idUser);
		
		try {

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// methode pour faire pour accepter ou refuser une demande d'emprunt de livre
	@Override
	public void resutatEmpruntLivre(Utilisateur utilisateur){
			
	}
}
