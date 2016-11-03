package com.projet.biblioshare.service;

import java.util.List;

import com.projet.biblioshare.entity.Livre;

public interface ILivreService {


	public List<Livre> listerLivre();
	public void creeLivre(Livre l);
}
