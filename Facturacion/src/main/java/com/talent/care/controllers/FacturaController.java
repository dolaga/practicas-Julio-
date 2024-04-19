package com.talent.care.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.talent.care.models.dao.IFacturaDao;
import com.talent.care.models.entity.Factura;
import com.talent.care.validators.FacturaValidator;

@RestController
@SessionAttributes("factura")
public class FacturaController {
	
	@Autowired
	private IFacturaDao fac;
	
	
	@Autowired
	private FacturaValidator val;
	
	@InitBinder
	public void initBinder(DataBinder binder) {
		binder.addValidators(val);
		
	}
	
	@RequestMapping(path = "/factura", method = RequestMethod.GET)
	public List<Factura> facturaList(){
		return fac.findAll();
		
	}
	
	@PostMapping(path = "/factura-guardar")
	
	public ResponseEntity<?> createFactura(@RequestBody Factura factura, BindingResult result){
		val.validate(factura, result);
		
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body("Error al guardar una factura" + result.getAllErrors());
		}else {
			fac.save(factura);
			return ResponseEntity.status(HttpStatus.CREATED).body("la factura se creo correctamente");
		}
		
	}
	
	@GetMapping(path = "factura-localizar")
	public Factura GetFactura(@PathVariable(name= "id") Long id ) {
		System.out.println("Cliente encontrado");
		return  fac.findOne(id);
	}
	
	@DeleteMapping("factura-eliminar")
	public void  DeleteFatura(@PathVariable(name= "id", required = true) Long id) {
		System.out.println("Factura eliminada");
		 try {
			 fac.delete(id);
		 }catch (Exception e){
			 e.printStackTrace();
			 
		 }
	}
	
	

}
