package com.wifabio.coreengineering.tema08.exceptions;

public class DadosInvalidosException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DadosInvalidosException() {
		super("Dados incorretos! O livro deve conter um título, autor e quantidade maior do que zero");
	}

}
