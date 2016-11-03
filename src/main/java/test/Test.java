package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projet.biblioshare.entity.Categorie;
import com.projet.biblioshare.entity.Collection;

import com.projet.biblioshare.entity.Utilisateur;
import com.projet.biblioshare.service.ICategorieService;
import com.projet.biblioshare.service.ICollectionService;
import com.projet.biblioshare.service.IUtilisateurService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		//test users
		IUtilisateurService service=(IUtilisateurService) context.getBean("utilisateurService");
//		service.addUser(new Utilisateur("Diego", "Franklin","root","root"));
//		service.addUser(new Utilisateur("Edgar", "ikamdem","match", "football"));
		List<Utilisateur> users=service.listUser();
		for(Utilisateur u: users){
			System.out.println("Nom: "+u.getNom()+" Prenom :"+u.getPrenom()+" Email: "+u.getEmail());
		}
		//test categorie
//		ICategorieService categorieService= (ICategorieService) context.getBean("categorieService");
//		categorieService.creerCategorie(new Categorie("horreur"));
//		List<Categorie> categories=categorieService.listerCategorie();
//		for(Categorie c: categories){
//			System.out.println("Libelle:"+c.getLibelle());
//		}
		//test collection
//		ICollectionService collectionService=(ICollectionService) context.getBean("collectionService");
//		collectionService.creerCollection(new Collection(" harry potter"));
//		List<Collection> collections=collectionService.listerCollection();
//		for(Collection co:collections){
//			System.out.println("collection Name "+co.getLibelle());
//		}
		
	
		
	}

}
