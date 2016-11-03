package com.projet.biblioshare.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projet.biblioshare.dao.ICategorieDao;
import com.projet.biblioshare.entity.Categorie;

@Transactional
public class CategorieServiceImp implements ICategorieService {

	private ICategorieDao categorieDao ;
	
	public void setCategorieDao(ICategorieDao categorieDao) {
		this.categorieDao = categorieDao;
	}

	@Override
	public List<Categorie> listerCategorie() {
		// TODO Auto-generated method stub
		return categorieDao.listerCategorie();
	}

	@Override
	public void creerCategorie(Categorie c) {
		// TODO Auto-generated method stub
		categorieDao.creerCategorie(c);
		
	}
}
