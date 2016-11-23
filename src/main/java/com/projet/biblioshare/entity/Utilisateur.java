package com.projet.biblioshare.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
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
	
	
	@Column(name="Credit",columnDefinition="Decimal(10,2) default '100.00'")
	private Double credit;
	
	@NotEmpty(message="l'e-mail ne doit pas etre vide")
	@Email
	@Column(name="Email")
	private String email;
	
	@NotEmpty(message="le mot de passe ne doit pas etre vide")
	@Column(name="Password")
	private String password;
	
	@NotEmpty(message="le mot de passe ne doit pas etre vide")
	@Column(name="PasswordConfirm")
	private String passwordConfirm;
	

	@NotEmpty
	@Length(max=10,message="mininum 5 lettre maximun 10",min=5)
	@Column(name="Username")
	private String username;
	
	
	@Column(name="Notification")
	private int notification;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="Demandes", joinColumns=@JoinColumn(name="IdUser"))
	@Column(name="Demande")
	private List<Integer> idDemandeur;
	
	
	 @ManyToMany
	 @JoinTable(name = "Amis",
	            joinColumns =
	                @JoinColumn(name = "Utilisateur1", referencedColumnName = "IdUser"),
	            inverseJoinColumns =
	                @JoinColumn(name = "Utilisateur2", referencedColumnName = "IdUser"))
	    private List<Utilisateur> users;
	
	 
	public Utilisateur(String nom, String prenom, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}

	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
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
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	
	public List<Utilisateur> getUsers() {
		return users;
	}
	public void setUsers(List<Utilisateur> users) {
		this.users = users;
	}
	
	public  void addUtilisateur(Utilisateur user) {
		users.add(user);
		if(user.getUsers().contains(this)){
			user.addUtilisateur(this);
		}
	}
	public void addIdDemandeur(Integer idDemandeur) {
		this.idDemandeur.add(idDemandeur);

	}
	public void removeIdDemandeur(Integer idDemandeur) {
		this.idDemandeur.remove(idDemandeur);

	}
	public int getNotification() {
		return notification;
	}
	public void setNotification(int notification) {
		this.notification = notification;
	}
	public List<Integer> getIdDemandeur() {
		return idDemandeur;
	}
	public void setIdDemandeur(List<Integer> idDemandeur) {
		this.idDemandeur = idDemandeur;
	}

	

	
	
	
}
