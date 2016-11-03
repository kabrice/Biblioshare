package com.projet.biblioshare.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projet.biblioshare.dao.IEditeurDao;
import com.projet.biblioshare.entity.Editeur;

@Transactional
public class EditeurServiceImp  implements IEditeurService{
	
	private IEditeurDao  editeurDao;
	
	public void setEditeurDao(IEditeurDao editeurDao) {
		this.editeurDao = editeurDao;
	}

	@Override
	public List<Editeur> listerEditeur() {
		// TODO Auto-generated method stub
		return editeurDao.listerEditeur();
	}

	@Override
	public void creerEditeur(Editeur e) {
		// TODO Auto-generated method stub
		editeurDao.creerEditeur(e);
	}

}
