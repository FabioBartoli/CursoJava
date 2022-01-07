package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

//		Comparator<String> comparador = new ComparadorPorTamanho();
//		palavras.sort(comparador);

		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));

		
		/*****
		Function<String, Integer> funcao = s -> s.length();
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		*///
		
//		Collections.sort(palavras, comparador);
		System.out.println(palavras);

//		for (String p : palavras) {
//			System.out.println(p);y7u
//		}

		palavras.forEach(s -> System.out.println(s)); //Maneira lambda
		palavras.forEach(System.out::println); //Maneira method reference

	}
}