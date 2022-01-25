package com.wifabio.coreengineering.tema08.exceptions;

public class EmprestimoInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EmprestimoInvalidoException() {
		super("Não é possível fazer o empréstimo pois o usuário já está com mais de 5 livros emprestados ou o livro está sem estoque!!");
	}

}
