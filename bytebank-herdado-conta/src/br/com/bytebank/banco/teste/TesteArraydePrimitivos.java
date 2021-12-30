package br.com.bytebank.banco.teste;

public class TesteArraydePrimitivos {

	public static void main(String[] args) {

		int[] idades = new int[5]; // Inicia o array com os valores padroes do tipo int -> 0

//		idades[0] = 29; 
//		idades[1] = 39; 
//		idades[2] = 49; 
//		idades[3] = 59; 
//		idades[4] = 69; 
//		idades[666] = 5641; 
//
//		int idade4 = idades[4];
//
//		System.out.println(idade4);
//
//		System.out.println(idades.length);

		for (int i = 0; i < idades.length; i++) {
			idades[i] = i * i;
			System.out.println(idades[i]);

		}
//		
//		for (int i = 0; i < idades.length; i++) {
//		}

	}

}
