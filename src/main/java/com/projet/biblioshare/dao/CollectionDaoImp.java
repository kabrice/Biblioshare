package com.projet.biblioshare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.projet.biblioshare.entity.Collection;

public class CollectionDaoImp implements ICollectionDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Collection> listerCollection() {
		Query req = em.createQuery("select distinct  c from Collection c");
		return req.getResultList();
	}

	@Override
	public void creerCollection(Collection co) {
		// TODO Auto-generated method stub
		em.persist(co);
		em.flush();
	}

}
