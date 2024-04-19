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

import com.talent.care.models.dao.IClienteDao;
import com.talent.care.models.entity.Cliente;
import com.talent.care.validators.ClienteValidator;


@RestController
@SessionAttributes("cliente")
public class ClientController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	
	@Autowired
	private ClienteValidator clienteValidator;
	
	@InitBinder
	public void initBinder(DataBinder binder) {
		binder.addValidators(clienteValidator);
	}
	
	@RequestMapping(path = "/clientes", method = RequestMethod.GET)
	public List<Cliente> clientesList() {
		return clienteDao.findAll();
	}
	
	@PostMapping("/guardar-cliente")
	public ResponseEntity<?> createCliente(@RequestBody Cliente cliente, BindingResult result){
		clienteValidator.validate(cliente, result);
		
		if(result.hasErrors()) {
			result.getAllErrors();
			return ResponseEntity.badRequest().body("Errro en la validacion de datos: "
													+result.getAllErrors());
			
		} else {
			clienteDao.save(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente");
		}
		
		
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente getClienteById(@PathVariable(name = "id") Long id) {
		System.out.println("Estoy aqui, getClienteById");
	    return clienteDao.findOne(id);
	}
	
	@DeleteMapping("/clientes/{id}")
	public void deleteCliente(@PathVariable(name = "id", required = true) Long id) {
		try {
			clienteDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
