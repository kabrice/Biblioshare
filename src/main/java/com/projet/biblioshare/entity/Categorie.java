package com.projet.biblioshare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCategorie")
	private int id;
	
	@NotEmpty
	@Column(name="Libelle")
	private String libelle;
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	//constructeurs
	
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
