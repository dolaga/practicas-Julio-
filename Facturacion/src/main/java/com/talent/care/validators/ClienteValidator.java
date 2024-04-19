package com.talent.care.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.talent.care.models.entity.Cliente;

@Component
public class ClienteValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Cliente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Cliente cliente = (Cliente) target;
		
		ValidationUtils.rejectIfEmpty(errors, "nombre", "El nombre no puede ser vacio");
		
		if(!cliente.getNombre().matches("[a-z,A-Z]{1,15}?[ ]?[a-z,A-Z]{1,15}")) {
			errors.rejectValue("nombre", "El nombre no es valido");
		}
		
		if(!cliente.getNumeroTelefono().matches("[0-9]{10}")) {
			errors.rejectValue("nombre", "El numero de telefono debe ser de 10 digitos");
		}
		
		if(cliente.getDiaCreacion() == null) {
			errors.rejectValue("diaCreacion", "El dia de creacion tiene que ser valido");
		}
		
	}
	
}
