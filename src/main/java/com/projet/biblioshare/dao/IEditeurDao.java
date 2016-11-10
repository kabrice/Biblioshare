package com.projet.biblioshare.dao;

import java.util.List;

import com.projet.biblioshare.entity.Editeur;

public interface IEditeurDao {
	public List<Editeur> listerEditeur();
	public void creerEditeur(Editeur e);

}
