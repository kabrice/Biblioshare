package com.projet.biblioshare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.projet.biblioshare.entity.Utilisateur;


public class UtilisateurDaoImp implements IUtilisateurDao {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> listUser() {
		Query req = em.createQuery("select distinct  u from Utilisateur u");
		return req.getResultList();
	}

	@Override
	public void addUser(Utilisateur u) {
		// TODO Auto-generated method stub
		em.persist(u);
		em.flush();
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Utilisateur.class, id));
	}

	@Override
	public void saveUser(Utilisateur u) {
		if (u == null) {
			try {
				em.persist(u);
				em.flush();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Utilisateur loginUser(Utilisateur u) {
		// TODO Auto-generated method stub
		//System.out.println(u.getUsername()+" "+u.getPassword());

		try {
			//String select = "SELECT u FROM com.projet.biblioshare.entity.Utilisateur u WHERE u.username=:user and u.password=:pass";
			Query query = em.createQuery( "SELECT u FROM Utilisateur u WHERE u.username=:user and u.password=:pass");

			query.setParameter("user", u.getUsername());
			query.setParameter("pass", u.getPassword());
			u=(Utilisateur)query.getSingleResult();
			
		} catch (Exception e) {
			return null;
			//e.printStackTrace();
		}

		return u;

	}

	@Override
	public Utilisateur searchUserByPseudo(String pseudo) {
		// TODO Auto-generated method stub
		return null;
	}

}
