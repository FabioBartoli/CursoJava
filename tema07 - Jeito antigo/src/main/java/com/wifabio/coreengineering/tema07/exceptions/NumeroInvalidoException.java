package com.wifabio.coreengineering.tema07.exceptions;

public class NumeroInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    public NumeroInvalidoException() {
        super("O número inserido está fora do range permitido! Insira um número inteiro ou romano entre 1 e 20");
    }
}
