package com.projet.biblioshare.service;

import org.springframework.transaction.annotation.Transactional;

import com.projet.biblioshare.dao.IAuteurDao;

@Transactional
public class AuteurServiceImp implements IAuteurService {

	@SuppressWarnings("unused")
	private IAuteurDao auteurDao;
	public void setAuteurDao(IAuteurDao auteurDao) {
		this.auteurDao = auteurDao;
	}
}
