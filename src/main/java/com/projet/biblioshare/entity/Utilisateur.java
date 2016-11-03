package com.projet.biblioshare.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdUser")
	private int id;
	
	@NotEmpty(message="le nom ne doit pas etre vide")
	@Column(name="Nom")
	private String nom;
	
	@NotEmpty(message="le prenom ne doit pas etre vide")
	@Column(name="Prenom")
	private String prenom;
	
	@NotEmpty(message="l'e-mail ne doit pas etre vide")
	@Email
	@Column(name="Email")
	private String email;
	
	@NotEmpty(message="le mot de passe ne doit pas etre vide")
	@Column(name="Password")
	private String password;
	

	@NotEmpty
	@Length(max=10,message="mininum 5 lettre maximun 10",min=5)
	@Column(name="Username")
	private String username;
	
	 
	public Utilisateur(String nom, String prenom, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}

	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Livre_Utilisateur",joinColumns={@JoinColumn(name="IdUser")},inverseJoinColumns={@JoinColumn(name="IdLivre")})
	private Set<Livre> livres;
	
	public Utilisateur() {
		super();
	}
	//Getters and setters
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

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
}
