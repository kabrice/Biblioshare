package com.projet.biblioshare.service;

import java.util.List;

import com.projet.biblioshare.entity.Categorie;

public interface ICategorieService {
	public List<Categorie> listerCategorie();

	public void creerCategorie(Categorie c);
}
