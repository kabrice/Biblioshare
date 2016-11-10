package com.projet.biblioshare.service;

import java.util.List;

import com.projet.biblioshare.entity.Collection;

public interface ICollectionService {
	public List<Collection> listerCollection();
	public void creerCollection(Collection co);
}
