package com.projet.biblioshare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.projet.biblioshare.entity.Editeur;

public class EditeurDaoImp implements IEditeurDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Editeur> listerEditeur() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select distinct  e from Editeur e");
		return req.getResultList();
	}

	@Override
	public void creerEditeur(Editeur e) {
		em.persist(e);
		em.flush();
		
	}

}
