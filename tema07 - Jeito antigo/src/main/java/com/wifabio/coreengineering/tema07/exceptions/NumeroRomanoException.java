package com.wifabio.coreengineering.tema07.exceptions;

public class NumeroRomanoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    public NumeroRomanoException() {
        super("O número romano inserido está incorreto. O valor máximo permitido é XX");
    }
}
