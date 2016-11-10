package com.projet.biblioshare.dao;

import java.util.List;

import com.projet.biblioshare.entity.Collection;

public interface ICollectionDao {
	public List<Collection> listerCollection();
	public void creerCollection(Collection co);
}
