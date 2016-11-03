package com.projet.biblioshare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.projet.biblioshare.entity.Categorie;

public class CategorieDaoImp implements ICategorieDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Categorie> listerCategorie() {
		Query req = em.createQuery("select distinct  c from Categorie c");
		return req.getResultList();
		
	}

	@Override
	public void creerCategorie(Categorie c) {
		// TODO Auto-generated method stub
		em.persist(c);
		em.flush();
	}

}
