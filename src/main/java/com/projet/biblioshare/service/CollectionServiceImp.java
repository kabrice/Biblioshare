package com.projet.biblioshare.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projet.biblioshare.dao.ICollectionDao;
import com.projet.biblioshare.entity.Collection;

@Transactional
public class CollectionServiceImp implements ICollectionService {
	private ICollectionDao  collectionDao ;
	
	public void setCollectionDao(ICollectionDao collectionDao) {
		this.collectionDao = collectionDao;
	}

	@Override
	public List<Collection> listerCollection() {
		// TODO Auto-generated method stub
		return collectionDao.listerCollection();
	}

	@Override
	public void creerCollection(Collection co) {
		// TODO Auto-generated method stub
		collectionDao.creerCollection(co);
		
	}

}
