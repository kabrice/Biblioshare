package com.projet.biblioshare.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		//System.out.println(u.getUsername()+" "+u.getPassword());

		try {
			//String select = "SELECT u FROM com.projet.biblioshare.entity.Utilisateur u WHERE u.username=:user and u.password=:pass";
			Query query = em.createQuery( "SELECT u FROM Utilisateur u WHERE u.username=:user and u.password=:pass");

			query.setParameter("user", u.getUsername());
			query.setParameter("pass", u.getPassword());
			u=(Utilisateur)query.getSingleResult();
			
		} catch (Exception e) {
			return null;
			//e.printStackTrace();
		}

		return u;

	}

	@Override
	public int checkUserName(Utilisateur u) {
		// TODO Auto-generated method stub
		
		try {
			Query req = em.createQuery("select   u from Utilisateur u where u.username=:user");
			req.setParameter("user", u.getUsername());	
			if(req.getSingleResult()==null){
				//this.addUser(u);
				System.out.println("utilisateur ajouté");
				return 1;
			}
			else{
				return 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 1;
		}
		
	}

	@Override
	public void telechargerLivre(Utilisateur utilisateur, int idLivre) {
		// TODO Auto-generated method stub
		//Livre livre=null;
		
			try {
				//juste pour verifier si je récupère bien le bon livre
				//livre=em.find(Livre.class, idLivre);
				//System.out.println("identifiant "+livre.getId()+"editeur "+livre.getEditeur().getNom()+"description "+livre.getDescription()+ " utilisateur "+utilisateur.getUsername());
				
				int idUser=utilisateur.getId();
				Query query=em.createNativeQuery("INSERT INTO Livre_Utilisateur values(?,?)");
				query.setParameter(1, idUser);
				query.setParameter(2, idLivre);
				query.executeUpdate();
				
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
		Livre livre=null;
		int result=0;
		
		try {
			//juste pour verifier si je récupère bien le bon livre
			livre=em.find(Livre.class, idLivre);
			System.out.println("identifiant "+livre.getId()+"editeur "+livre.getEditeur().getNom()+"description "+livre.getDescription()+ " utilisateur "+utilisateur.getUsername());
			
			int idUser= utilisateur.getId();
			
			Query query=em.createNativeQuery("Select count(*) from Livre_Utilisateur WHERE IdUser=:user and IdLivre=:livre ");
			query.setParameter("user", idUser);
			query.setParameter("livre", idLivre);
			
			result= ((Number) query.getSingleResult()).intValue();
			
			if(result==0){
				System.out.println("résultat retourné "+result);
				return 1;
			}
			else {
				System.out.println("résultat retourné "+result);
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
		int idUser=utilisateur.getId();
		List<Livre> mesLivres=new ArrayList<Livre>();
	
		try {
			Query query=em.createNativeQuery("Select IdLivre from Livre_Utilisateur WHERE IdUser=:user");
			query.setParameter("user", idUser);
			List<Integer> idlivres =  query.getResultList();
			
			for(Integer i:idlivres){
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

			int idUser= utilisateur.getId();
			
			Query query=em.createNativeQuery("Select count(*) from Livre_Utilisateur WHERE IdUser=:user");
			query.setParameter("user", idUser);
			return ((Number) query.getSingleResult()).intValue();
			
		} catch (Exception e) {
			return 0;
		}
		
		
	}


	

}
