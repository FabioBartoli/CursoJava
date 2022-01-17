package com.wifabio.coreengineering.tema08.modelo;

import java.io.IOException;

import exceptions.DadosInvalidosException;
import exceptions.LivroJaCadastradoException;

public class Main {

	public static void main(String[] args) throws DadosInvalidosException, LivroJaCadastradoException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Livro livro = new Livro("Matéria Escura", "Blake Crouch");
		Livro livro2 = new Livro("Memórias Postumas de Bras Cubas", "Machado de Asssis");
		Livro livro3 = new Livro("1984", "George Orwell");
		Livro livro4 = new Livro("1984", "George Moeu");
		Livro livro5 = new Livro("Recursão", "Blake Crouch");
		Livro livro6 = new Livro("Duna", "Frank Herbert");


		
		biblioteca.adicionaLivro(livro);
		biblioteca.adicionaLivro(livro2);
		biblioteca.adicionaLivro(livro3);
		biblioteca.adicionaLivro(livro4);
		biblioteca.adicionaLivro(livro5);
		biblioteca.adicionaLivro(livro6);



		
		Usuario usuario1 = new Usuario("Fabio Bartoli", "123456789");
		biblioteca.adicionaUsuario(usuario1);
		Usuario usuario2 = new Usuario("Fabio Bartoli", "987654321");
		biblioteca.adicionaUsuario(usuario2);


	
		biblioteca.listaLivros();
	
	}

	
}
