package com.talent.care.models.dao;

import java.util.List;

import com.talent.care.models.entity.Factura;

public interface IFacturaDao {
	
	
	public List<Factura> findAll();
	public void save(Factura factura);
	public Factura findOne(Long id);
	public void delete(Long id);
	
	
}
