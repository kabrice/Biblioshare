package com.projet.biblioshare.dao;

import java.util.List;

import com.projet.biblioshare.entity.Categorie;

public interface ICategorieDao {
	public List<Categorie> listerCategorie();
	public void creerCategorie(Categorie c);
}
