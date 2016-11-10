package com.projet.biblioshare.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projet.biblioshare.dao.ILivreDao;
import com.projet.biblioshare.entity.Livre;

@Transactional
public class LivreServiceImp implements ILivreService {
	
	private ILivreDao livreDao;	
	
	public void setLivreDao(ILivreDao livreDao) {
		this.livreDao = livreDao;
	}

	
	@Override
	public List<Livre> listerLivre() {
		// TODO Auto-generated method stub
		return livreDao.listerLivre();
	}

	@Override
	public void creeLivre(Livre l) {
		// TODO Auto-generated method stub
		livreDao.creeLivre(l);
	}


	@Override
	public List<Livre> listerNouveauLivre() {
		// TODO Auto-generated method stub
		return livreDao.listerNouveauLivre();
	}

}
