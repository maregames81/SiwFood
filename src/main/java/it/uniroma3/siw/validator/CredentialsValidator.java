package it.uniroma3.siw.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.CredentialsService;

@Component
public class CredentialsValidator implements Validator {

	@Autowired private CredentialsService credentialsService;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Credentials.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Credentials credentials = (Credentials)target;
		if (credentials.getUsername()!=null && this.credentialsService.existByUsername(credentials.getUsername())) {
			errors.reject("username.duplicate");
		}
	}

}
