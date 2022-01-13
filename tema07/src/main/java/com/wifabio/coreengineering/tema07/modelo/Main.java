package com.wifabio.coreengineering.tema07.modelo;

import java.util.Scanner;

public class Main {

	static Scanner insere = new Scanner(System.in);
	static int tecla;

	public static void main(String[] args) {

		do {
			System.out.println(">======= Conversor de Números! <======");
			System.out.println("Escolha uma opção:");
			System.out
					.println("1. Converter Romano Para Decimal " + "\n2. Converter Inteiro Para Romano" + "\n3. Sair");
			System.out.println("");
			tecla = insere.nextInt();

			switch (tecla) {
			case 1:
				System.out.println("Insira o romano (Entre I e XX):");
				insere.nextLine();
				String romano = insere.nextLine();
				int decimalConvertido = Conversor.converteRomanoParaDecimal(romano);
				System.out.println("Numero convertido: " + decimalConvertido);
				System.out.println("");
				break;

			case 2:
				System.out.println("Insira o inteiro (Entre 1 e 20):");
				int decimal = insere.nextInt();
				String romanoConvertido = Conversor.converteDecimalParaRomano(decimal);
				System.out.println("Romano convertido: " + romanoConvertido);
				System.out.println("");
				break;
			}

		} while (tecla != 3);
		insere.close();

	}

}
