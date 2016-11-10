package com.projet.biblioshare.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.projet.biblioshare.entity.Utilisateur;

public class UtilisateurValidation implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Utilisateur.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
//		
//			Utilisateur user=(Utilisateur) arg0;
//			if(!(user.getPassword().equals(user.getPasswordConfirm()))){
//			arg1.rejectValue("password", "mot de passe non cohérent");
//			}
//		
		
	}

}
