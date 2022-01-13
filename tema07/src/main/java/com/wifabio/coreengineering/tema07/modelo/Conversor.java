package com.wifabio.coreengineering.tema07.modelo;

import com.wifabio.coreengineering.tema07.exceptions.NumeroInvalidoException;
import com.wifabio.coreengineering.tema07.exceptions.NumeroRomanoException;

public class Conversor {

	private static int[] DECIMAIS = { 10, 9, 5, 4, 1 };
	private static String[] ROMANOS = { "X", "IX", "V", "IV", "I" };

	private static int conversorRomano(char letra) throws NumeroRomanoException {
		switch (letra) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		default: throw new NumeroRomanoException();
		}
	}

	public static int converteRomanoParaDecimal(String romano) throws NumeroInvalidoException, NumeroRomanoException {
		if (romano.length() == 0) {
			throw new NumeroRomanoException();
		}
		romano = romano.toUpperCase();
		boolean valido = romano.matches("^X{0,1}(IX|IV|V?I{0,3})$");
		boolean validaOVinte = romano.matches("XX");
		if (valido == false && validaOVinte == false) {
			throw new NumeroRomanoException();
		}
		int i = 0;
		int decimal = 0;

		while (i < romano.length()) {
			char letraAtual = romano.charAt(i);
			int numero = conversorRomano(letraAtual);
			i++;

			if (i == romano.length()) {
				decimal += numero;
			} else {
				int proximoNumero = conversorRomano(romano.charAt(i));
				if (proximoNumero > numero) {
					decimal += (proximoNumero - numero);
					i++;
				} else {
					decimal += numero;
				}
			}
		}
		return decimal;
	}

	public static String converteDecimalParaRomano(int decimal) throws NumeroInvalidoException {
		String romano = "";
		if (decimal >= 1 && decimal <= 20) {
			for (int i = 0; i < DECIMAIS.length; i++) {
				while (decimal >= DECIMAIS[i]) {
					romano += ROMANOS[i];
					decimal -= DECIMAIS[i];
				}
			}
			return romano;
		} else
			throw new NumeroInvalidoException();
	}
}