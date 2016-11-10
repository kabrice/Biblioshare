package com.projet.biblioshare.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "editeur")
public class Editeur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdEditeur")
	private int id;

	@NotEmpty
	@Column(name = "Nom")
	private String nom;

	@NotEmpty
	@Column(name = "DateEdition")
	private Date dateEdition;

	// getters and setters
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

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}

	// Constructeurs
	public Editeur(String nom, Date dateEdition) {
		super();
		this.nom = nom;
		this.dateEdition = dateEdition;
	}

	public Editeur() {
		super();
		// TODO Auto-generated constructor stub
	}

}
