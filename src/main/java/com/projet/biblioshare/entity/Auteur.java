package com.projet.biblioshare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="auteur")
public class Auteur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdAuteur")
	private int id;
	
	@NotEmpty
	@Column(name="Nom")
	private String nom;
	
	@NotEmpty
	@Column(name="Prenom")
	private String prenom;
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
   //Constructeurs
	public Auteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Auteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
