package com.wifabio.coreengineering.tema08.exceptions;

public class LivroEmprestadoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public LivroEmprestadoException() {
		super("Não é possível excluir este livro, pois uma ou mais unidades dele estão emprestadas no momento!!");
	}

}
