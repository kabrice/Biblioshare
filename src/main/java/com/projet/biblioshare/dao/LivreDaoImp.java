package com.projet.biblioshare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.projet.biblioshare.entity.Livre;

public class LivreDaoImp implements ILivreDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Livre> listerLivre() {

		Query req = em.createQuery("select distinct  l from Livre l");
		return req.getResultList();
	}

	@Override
	public void creeLivre(Livre l) {
		// TODO Auto-generated method stub
		em.persist(l);
		em.flush();
	}

}
