package com.wifabio.coreengineering.tema08.exceptions;

public class LivroJaCadastradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public LivroJaCadastradoException() {
		super("Um livro com o mesmo nome e do mesmo autor já está cadastrado em nosso sistema!");
	}

}
