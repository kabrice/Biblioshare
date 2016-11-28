package com.projet.biblioshare.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="activitelivreami")
public class ActiviteLivreAmi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdActivite")
	private int id;
 
	@ManyToOne
	@JoinColumn(name="IdLivre")
	private Livre livre;
	
	@ManyToOne
	@JoinColumn(name="IdUser1")
	private Utilisateur utilisateur1;
	
	@ManyToOne
	@JoinColumn(name="IdUser2")
	private Utilisateur utilisateur2;
	
	@Column(name="EtatEmprunt")
	private int etatemprunt;
	
	@Column(name="DateEmpruntLivre")
	private Date dateempruntlivre;

	public ActiviteLivreAmi(int id, Livre livre, Utilisateur utilisateur1, Utilisateur utilisateur2, int etatemprunt,
			Date dateempruntlivre) {
		super();
		this.id = id;
		this.livre = livre;
		this.utilisateur1 = utilisateur1;
		this.utilisateur2 = utilisateur2;
		this.etatemprunt = etatemprunt;
		this.dateempruntlivre = dateempruntlivre;
	}

	public ActiviteLivreAmi(Livre livre) {
		super();
		this.livre = livre;
	}
	
	public ActiviteLivreAmi(Livre livre, int etatemprunt, Date dateempruntlivre) {
		super();
		this.livre = livre;
		this.etatemprunt = etatemprunt;
		this.dateempruntlivre = dateempruntlivre;
	}

	public ActiviteLivreAmi() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getters and setters
	
	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Utilisateur getUtilisateur1() {
		return utilisateur1;
	}

	public void setUtilisateur1(Utilisateur utilisateur1) {
		this.utilisateur1 = utilisateur1;
	}

	public Utilisateur getUtilisateur2() {
		return utilisateur2;
	}

	public void setUtilisateur2(Utilisateur utilisateur2) {
		this.utilisateur2 = utilisateur2;
	}


	public int getEtatemprunt() {
		return etatemprunt;
	}

	public void setEtatemprunt(int etatemprunt) {
		this.etatemprunt = etatemprunt;
	}

	public Date getDateempruntlivre() {
		return dateempruntlivre;
	}

	public void setDateempruntlivre(Date dateempruntlivre) {
		this.dateempruntlivre = dateempruntlivre;
	}
	
	// Autres Methode 
	
	/*public void addEmprunt(Integer idDemandeur) {
		this.idDemandeur.add(idDemandeur);

	}
	public void removeIdDemandeur(Integer idDemandeur) {
		this.idDemandeur.remove(idDemandeur);

	}*/
	
}
