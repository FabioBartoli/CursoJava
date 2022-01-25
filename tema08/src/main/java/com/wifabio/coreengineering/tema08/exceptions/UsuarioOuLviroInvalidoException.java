package com.wifabio.coreengineering.tema08.exceptions;

public class UsuarioOuLviroInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UsuarioOuLviroInvalidoException() {
		super("O ID digitado não corresponde a nenhum usuário! Por favor, verifique!");
	}

}
