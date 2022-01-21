package com.wifabio.coreengineering.tema08.exceptions;

public class ErroEscritaException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ErroEscritaException() {
		super("Erro ao escrever os dados! Confira o programa novamente.");
	}

}
