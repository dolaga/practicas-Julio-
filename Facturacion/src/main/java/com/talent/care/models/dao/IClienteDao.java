package com.talent.care.models.dao;

import java.util.List;

import com.talent.care.models.entity.Cliente;

public interface IClienteDao {

	public List<Cliente> findAll();
	public void save(Cliente cliente);
	public Cliente findOne(Long id);
	public void delete(Long id);
	
}
