package com.talent.care.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.talent.care.models.entity.Factura;

@Component 
public class FacturaValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Factura.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 Factura factura  = (Factura) target;
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "Factura", "Tiene que exisitir una factura");
		
		if(!factura.getDetalle().matches("^[a-z, A,Z][1,20]")) {
			errors.rejectValue("detalle", "El detalle no esta correcto");
		
		}
		if(factura.getFecha() == null) {
			errors.rejectValue("fecha", "no se tiene registro de la compra ");
		}
	}

	
}
