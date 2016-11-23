package com.projet.biblioshare.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "livre")
public class Livre {
	// champs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdLivre")
	private int id;
	
	@NotEmpty
	@Column(name = "Description")
	private String description;

	@NotEmpty
	@Column(name = "Libelle")
	private String libelle;
	
	@NotEmpty
	@Column(name = "Prix",columnDefinition="Decimal(10,2) default '10.00'")
	private Double prix;
	
	@NotEmpty
	@Column(name = "image")
	private String image;
	
	@NotEmpty
	@Column(name = "DateSortie")
	private Date dateSortie;
	
	@ManyToMany(mappedBy="livres")
	private Set<Utilisateur> utilisateur;
	
	@ManyToOne
	@JoinColumn(name="IdEditeur")
	private Editeur editeur;
	
	@ManyToOne
	@JoinColumn(name="IdCategorie")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="IdCollection")
	private Collection collection;
	
	// getters and setters
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Set<Utilisateur> getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Set<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}
	
	
	
	//constructeur avec et sans parametre

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	
	

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Livre(String description, String libelle, Date dateSortie) {
		super();
		this.description = description;
		this.libelle = libelle;
		this.dateSortie = dateSortie;
	}

	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
