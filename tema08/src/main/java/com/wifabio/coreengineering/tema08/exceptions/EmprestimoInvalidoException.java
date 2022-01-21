package com.wifabio.coreengineering.tema08.exceptions;

public class EmprestimoInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EmprestimoInvalidoException() {
		super("O empréstimo que você está tentando remover não existe!");
	}

}
