package com.projet.biblioshare.dao;

import java.util.List;

import com.projet.biblioshare.entity.Livre;


public interface ILivreDao {

	public List<Livre> listerLivre();
	public void creeLivre(Livre l);
}
