package com.projet.biblioshare.dao;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.projet.biblioshare.entity.Livre;
import com.projet.biblioshare.entity.Utilisateur;

public class UtilisateurDaoImp implements IUtilisateurDao {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> listUser() {
		Query req = em.createQuery("select distinct  u from Utilisateur u");
		return req.getResultList();
	}

	@Override
	public void addUser(Utilisateur u) {
		// TODO Auto-generated method stub
		em.persist(u);
		em.flush();

	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Utilisateur.class, id));
	}

	@Override
	public void saveUser(Utilisateur u) {
		if (u == null) {
			try {
				em.persist(u);
				em.flush();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Utilisateur loginUser(Utilisateur u) {
		// TODO Auto-generated method stub
		// System.out.println(u.getUsername()+" "+u.getPassword());

		try {
			// String select = "SELECT u FROM
			// com.projet.biblioshare.entity.Utilisateur u WHERE
			// u.username=:user and u.password=:pass";
			Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.username=:user and u.password=:pass");

			query.setParameter("user", u.getUsername());
			query.setParameter("pass", u.getPassword());
			u = (Utilisateur) query.getSingleResult();

		} catch (Exception e) {
			return null;
			// e.printStackTrace();
		}

		return u;

	}

	@Override
	public int checkUserName(Utilisateur u) {
		// TODO Auto-generated method stub

		try {
			Query req = em.createQuery("select   u from Utilisateur u where u.username=:user");
			req.setParameter("user", u.getUsername());
			if (req.getSingleResult() == null) {
				// this.addUser(u);
				System.out.println("utilisateur ajouté");
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 1;
		}

	}

	@Override
	public void telechargerLivre(Utilisateur utilisateur, int idLivre) {
		Double debit = 0.0;
		
		try {

			int idUser = utilisateur.getId();
			Query query = em.createNativeQuery("INSERT INTO Livre_Utilisateur values(?,?)");
			query.setParameter(1, idUser);
			query.setParameter(2, idLivre);
			query.executeUpdate();

			Double credit = em.find(Utilisateur.class, utilisateur.getId()).getCredit();
			Double prixLivre = em.find(Livre.class, idLivre).getPrix();
			debit = credit - prixLivre;
			utilisateur.setCredit(debit);

			em.merge(utilisateur);

			em.flush();
			System.out.println("livre ajouté a la bibliothèque");
			//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * verivie si l'utilisateur ne possède deja pas ce livre
	 */
	@Override
	public int dejaTelechargerLivre(Utilisateur utilisateur, int idLivre) {
		int result = 0;

		try {
			// juste pour verifier si je récupère bien le bon livre
			
			int idUser = utilisateur.getId();

			Query query = em
					.createNativeQuery("Select count(*) from Livre_Utilisateur WHERE IdUser=:user and IdLivre=:livre ");
			query.setParameter("user", idUser);
			query.setParameter("livre", idLivre);

			result = ((BigInteger) query.getSingleResult()).intValue();

			if (result == 0) {
				System.out.println("résultat retourné " + result);
				return 1;
			} else {
				System.out.println("résultat retourné " + result);
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livre> afficherLivreUser(Utilisateur utilisateur) {
		int idUser = utilisateur.getId();
		List<Livre> mesLivres = new ArrayList<Livre>();

		try {
			Query query = em.createNativeQuery("Select IdLivre from Livre_Utilisateur WHERE IdUser=:user");
			query.setParameter("user", idUser);
			List<Integer> idlivres = query.getResultList();

			for (Integer i : idlivres) {
				mesLivres.add(em.find(Livre.class, i));
			}
			return mesLivres;

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public int CountNbLivresUsers(Utilisateur utilisateur) {

		try {

			int idUser = utilisateur.getId();

			Query query = em.createNativeQuery("Select count(*) from Livre_Utilisateur WHERE IdUser=:user");
			query.setParameter("user", idUser);
			return ((Number) query.getSingleResult()).intValue();

		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public int verifierCredit(Utilisateur utilisateur, int idLivre) {
		Livre l = em.find(Livre.class, idLivre);
		if (utilisateur.getCredit() < l.getPrix()) {
			return 0;
		}
		return 1;
	}

	@Override
	public List<Livre> showLivreByAuthor(Utilisateur utilisateur, int idAuteur) {
		return null;
	}

	@Override
	public List<Livre> showLivreByCategory(Utilisateur utilisateur, int idCategorie) {
		int idUser = utilisateur.getId();
		List<Livre> LBA = new ArrayList<Livre>();

		try {
			Query query = em.createNativeQuery(
					"select IdLivre from livre where idCategorie=:categorie and IdLivre in (Select IdLivre from Livre_Utilisateur WHERE IdUser=:user)");
			query.setParameter("user", idUser);
			query.setParameter("categorie", idCategorie);
			@SuppressWarnings("unchecked")
			List<Integer> idlivres = query.getResultList();

			for (Integer i : idlivres) {
				LBA.add(em.find(Livre.class, i));
			}

			return LBA;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Livre> showLivreByEditor(Utilisateur utilisateur, int idEditeur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livre> showLivreByCollection(Utilisateur utilisateur, int idCollection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur demanderAmis(Utilisateur utilisateur, int idUser) {
		Utilisateur userAmis = em.find(Utilisateur.class, idUser);

		try {

			userAmis.addIdDemandeur(utilisateur.getId());
			userAmis.setNotification(userAmis.getNotification() + 1);
			// System.out.println("username " + userAmis.getUsername());
			em.merge(userAmis);
			em.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;

	}

	@Override
	public void accepterAmis(Utilisateur utilisateur, int IdUser) {

		try {
			Query query = em.createNativeQuery("INSERT INTO Amis values(?,?)");
			query.setParameter(1, utilisateur.getId());
			query.setParameter(2, IdUser);
			query.executeUpdate();

			Query query2 = em.createNativeQuery("INSERT INTO Amis values(?,?)");
			query2.setParameter(1, IdUser);
			query2.setParameter(2, utilisateur.getId());

			query2.executeUpdate();
			utilisateur.removeIdDemandeur(IdUser);
			utilisateur.setNotification(utilisateur.getNotification() - 1);
			em.merge(utilisateur);
			em.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Utilisateur rechercherUser(int idUser) {
		// TODO Auto-generated method stub
		return em.find(Utilisateur.class, idUser);
	}

	@Override
	public List<Utilisateur> afficherNotification(Utilisateur utilisateur) {
		// SELECT Demande FROM Demandes WHERE IdUser=6;
		int idUser = utilisateur.getId();
		List<Utilisateur> listeDemandeurs = new ArrayList<Utilisateur>();

		try {
			Query query = em.createNativeQuery("Select Demande from Demandes WHERE IdUser=:user");
			query.setParameter("user", idUser);
			@SuppressWarnings("unchecked")
			List<Integer> idemandeurs = query.getResultList();

			for (Integer i : idemandeurs) {
				listeDemandeurs.add(em.find(Utilisateur.class, i));
			}
			return listeDemandeurs;

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public int demandeDejaEnvoyer(Utilisateur utilisateur, int iduser2) {

		int result = 0;
		int idUser = utilisateur.getId();
		try {

			Query query = em
					.createNativeQuery("select count(*) from Demandes where Demande=:idDemandeur and idUser=:user");
			query.setParameter("idDemandeur", idUser);
			query.setParameter("user", iduser2);

			result = ((Number) query.getSingleResult()).intValue();

			if (result == 0) {
				System.out.println("résultat retourné " + result);
				return 1;
			} else {
				System.out.println("résultat retourné " + result);
				return 0;
			}

		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}

	@Override
	public List<Utilisateur> listerAmis(Utilisateur utilisateur) {
		List<Utilisateur> lstUser = new ArrayList<Utilisateur>();
		int idUser = utilisateur.getId();

		try {
			Query query = em.createNativeQuery("select Utilisateur2  from Amis where Utilisateur1=:user");
			query.setParameter("user", idUser);
			@SuppressWarnings("unchecked")
			List<Integer> lstIdUser = query.getResultList();

			for (Integer i : lstIdUser) {
				lstUser.add(em.find(Utilisateur.class, i));
			}

			for (Utilisateur u : lstUser) {
				System.err.println("nom user " + u.getUsername());
			}
			return lstUser;
		} catch (Exception e) {
			System.out.println("je ne retourne rien");
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Utilisateur> listerUserPasAmis(Utilisateur utilisateur) {

		try {
			List<Integer> listNA = new ArrayList<Integer>();
			List<Utilisateur> listUser = new ArrayList<Utilisateur>();
			try {
				Query req = em.createNativeQuery(
						"select idUser from utilisateur where IdUser not in (select Utilisateur1 from Amis where Utilisateur2 = :user ) ");
				req.setParameter("user", utilisateur.getId());

				listNA = req.getResultList();

				for (Integer i : listNA) {
					if (i != utilisateur.getId()) {
						listUser.add(em.find(Utilisateur.class, i));
					}

				}

				return listUser;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUser();
	}

	@Override
	public void refuseAmis(Utilisateur utilisateur, int IdUser) {
		utilisateur.removeIdDemandeur(IdUser);
		utilisateur.setNotification(utilisateur.getNotification() - 1);
		em.merge(utilisateur);
		em.flush();
	}

}
