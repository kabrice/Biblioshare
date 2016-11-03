package com.projet.biblioshare.service;

import java.util.List;

import com.projet.biblioshare.entity.Editeur;

public interface IEditeurService {
	public List<Editeur> listerEditeur();
	public void creerEditeur(Editeur e);
}
