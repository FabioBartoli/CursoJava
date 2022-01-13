package com.wifabio.coreengineering.tema07.modelo;

import java.util.Scanner;

public class Main {
	
	static Scanner insere = new Scanner(System.in);
	int tecla;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Insira o romano:");
		String romano = insere.nextLine();
		int decimalConvertido = ConversorCor.converteRomanoParaDecimal(romano);
		System.out.println("Numero convertido: " + decimalConvertido);
		
		System.out.println("Insira o inteiro:");
		int decimal = insere.nextInt();
		String romanoConvertido = ConversorCor.converteDecimalParaRomano(decimal);
		System.out.println("Romano convertido: " + romanoConvertido);
	}

}
