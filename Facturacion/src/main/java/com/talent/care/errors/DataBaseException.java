package com.talent.care.errors;


public class DataBaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataBaseException() {
		super("Contacte al administrador de base de datos, hubo un error al guardar el registro");
	}
}
