package com.wifabio.coreengineering.tema07.modelo;

import java.util.HashMap;

import com.wifabio.coreengineering.tema07.exceptions.NumeroInvalidoException;

public class Conversor {

	public final static HashMap<String, Integer> tabela = new HashMap<>();

	static {
		tabela.put("I", 1);
		tabela.put("II", 2);
		tabela.put("III", 3);
		tabela.put("IV", 4);
		tabela.put("V", 5);
		tabela.put("VI", 6);
		tabela.put("VII", 7);
		tabela.put("VIII", 8);
		tabela.put("IX", 9);
		tabela.put("X", 10);
		tabela.put("XI", 11);
		tabela.put("XII", 12);
		tabela.put("XIII", 13);
		tabela.put("XIV", 14);
		tabela.put("XV", 15);
		tabela.put("XVI", 16);
		tabela.put("XVII", 17);
		tabela.put("XVIII", 18);
		tabela.put("XIX", 19);
		tabela.put("XX", 20);
	}

	public static int converteRomanoParaDecimal(String romano) throws NumeroInvalidoException {
		if (tabela.containsKey(romano)) {
			int decimal = tabela.get(romano);
			return decimal;
		}
		throw new NumeroInvalidoException();
	}

	public static String converteDecimalParaRomano(Integer decimal) throws NumeroInvalidoException {
		String romano = tabela.entrySet().stream().filter(d -> decimal.equals(d.getValue())).findFirst()
				.orElseThrow(() -> new NumeroInvalidoException()).getKey();
		return romano;
	}
}