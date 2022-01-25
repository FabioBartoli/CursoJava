package com.wifabio.coreengineering.tema08.servicos;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import com.wifabio.coreengineering.tema08.exceptions.DadosInvalidosException;
import com.wifabio.coreengineering.tema08.exceptions.LivroJaCadastradoException;
import com.wifabio.coreengineering.tema08.modelo.Biblioteca;
import com.wifabio.coreengineering.tema08.modelo.Livro;
import com.wifabio.coreengineering.tema08.modelo.Relatorio;
import com.wifabio.coreengineering.tema08.modelo.Usuario;

public class Main {
	static Scanner insere = new Scanner(System.in);
	static int tecla;

	public static void main(String[] args) throws DadosInvalidosException, LivroJaCadastradoException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		ServicoEmprestimo empresta = new ServicoEmprestimo();
		Relatorio relatorio = new Relatorio(empresta);
		Livro livro1 = new Livro("Matéria Escura", "Blake Crouch", 12);
		Livro livro2 = new Livro("Memórias Postumas de Bras Cubas", "Machado de Assis", 4);
		Livro livro3 = new Livro("1984", "George Orwell", 3);
		Livro livro4 = new Livro("IT", "Stephen King", 1);
		Livro livro5 = new Livro("Recursão", "Blake Crouch", 5);
		Livro livro6 = new Livro("Os crimes ABC", "Agatha Christie", 2);
		Livro livro7 = new Livro("Lugar Nenhum", "Neil Gaiman", 6);
		Livro livro8 = new Livro("Mr. Mercedes", "Stephen King", 10);
		Livro livro9 = new Livro("Os filhos de Húrin", "J.R.R. Tolkien", 3);
		Livro livro10 = new Livro("Frankenstein", "Mary Shelley", 8);
		biblioteca.adicionaLivro(livro1);
		biblioteca.adicionaLivro(livro2);
		biblioteca.adicionaLivro(livro3);
		biblioteca.adicionaLivro(livro4);
		biblioteca.adicionaLivro(livro5);
		biblioteca.adicionaLivro(livro6);
		biblioteca.adicionaLivro(livro7);
		biblioteca.adicionaLivro(livro8);
		biblioteca.adicionaLivro(livro9);
		biblioteca.adicionaLivro(livro10);

		Usuario usuario1 = new Usuario("Fabio Bartoli", "123456789");
		Usuario usuario2 = new Usuario("Joaquim Silva", "987654321");
		Usuario usuario3 = new Usuario("Charles Antonio", "89485964451");
		Usuario usuario4 = new Usuario("Joao Souza", "55848448");
		Usuario usuario5 = new Usuario("Amanda Ribeiro", "7748885118");
		Usuario usuario6 = new Usuario("Rebeca Andrade", "7417111181");
		Usuario usuario7 = new Usuario("Roberto Gonçalves", "545445");
		Usuario usuario8 = new Usuario("Estevão Martins", "86485646");
		Usuario usuario9 = new Usuario("Maria Helena", "55656565");
		Usuario usuario10 = new Usuario("Janaina Azevedo", "87872121");
		Usuario usuario11 = new Usuario("Erick de Souza", "54545445");
		Usuario usuario12 = new Usuario("Rafael Gomes", "445646464");
		Usuario usuario13 = new Usuario("Felipe Padilha", "512122561");
		Usuario usuario14 = new Usuario("Carolina Veiga", "599592684");
		Usuario usuario15 = new Usuario("Júlia Cunha", "84545421");
		biblioteca.adicionaUsuario(usuario1);
		biblioteca.adicionaUsuario(usuario2);
		biblioteca.adicionaUsuario(usuario3);
		biblioteca.adicionaUsuario(usuario4);
		biblioteca.adicionaUsuario(usuario5);
		biblioteca.adicionaUsuario(usuario6);
		biblioteca.adicionaUsuario(usuario7);
		biblioteca.adicionaUsuario(usuario8);
		biblioteca.adicionaUsuario(usuario9);
		biblioteca.adicionaUsuario(usuario10);
		biblioteca.adicionaUsuario(usuario11);
		biblioteca.adicionaUsuario(usuario12);
		biblioteca.adicionaUsuario(usuario13);
		biblioteca.adicionaUsuario(usuario14);
		biblioteca.adicionaUsuario(usuario15);

		empresta.adicionaEmprestimo(2, 3, LocalDate.of(2022, 01, 01));
		empresta.adicionaEmprestimo(2, 10, LocalDate.of(2021, 12, 18));
		empresta.adicionaEmprestimo(11, 7, LocalDate.of(2021, 11, 11));
		empresta.adicionaEmprestimo(3, 7, LocalDate.of(2021, 11, 11));
		empresta.adicionaEmprestimo(3, 8, LocalDate.of(2021, 12, 11));
		empresta.adicionaEmprestimo(11, 6, LocalDate.of(2022, 01, 11));
		empresta.adicionaEmprestimo(2, 8, LocalDate.of(2022, 01, 19));
		empresta.adicionaEmprestimo(2, 4, LocalDate.of(2022, 01, 19));
		empresta.adicionaEmprestimo(10, 9, LocalDate.of(2022, 01, 19));
		empresta.adicionaEmprestimo(10, 5, LocalDate.of(2022, 01, 19));
		empresta.adicionaEmprestimo(5, 5, LocalDate.of(2022, 01, 20));

		do {
			System.out.println(">=======BIBLIOTECA!<======");
			System.out.println("Escolha uma opção:");
			System.out.println("1. Livros \n2. Usuários \n3. Busca \n4. Empréstimo \n5. Relatórios \n0. Sair");
			System.out.println("");
			tecla = insere.nextInt();

			switch (tecla) {
			case 1:
				do {
					System.out.println("Escolha uma opção: ");
					System.out.println(
							"1. Adicionar um Livro \n2. Remover um Livro \n3. Listar todos livro cadastrados \n0. Sair");
					tecla = insere.nextInt();

					switch (tecla) {
					case 1:
						System.out.println("\nDigite o título do livro: ");
						insere.nextLine();
						String titulo = insere.nextLine();
						System.out.println("\nDigite o Autor do livro: ");
						String autor = insere.nextLine();
						System.out.println("\nInsira a quantidade de livros a adicionar no estoque: ");
						int quantidade = insere.nextInt();
						Livro livro = new Livro(titulo, autor, quantidade);
						biblioteca.adicionaLivro(livro);
						break;
					case 2:
						System.out.println("\nEscolha o livro a excluir:");
						biblioteca.listaLivros();
						System.out.println("\nDigite o ID do livro a excluir: ");
						int livroID = insere.nextInt() - 1;
						biblioteca.excluiLivro(livroID);
						break;
					case 3:
						biblioteca.listaLivros();
						break;
					case 0:
						System.out.println("Obrigado por utilizar a Biblioteca!");
						break;
					default:
						System.out.println("\n---------\nSelecione uma opção válida!\n---------\n");
					}
				} while (tecla != 0);
				break;
			case 2:
				do {
					System.out.println("Escolha uma opção: ");
					System.out.println("\n1. Cadastrar usuário \n2. Listar todos usuários \n0. Sair");
					tecla = insere.nextInt();

					switch (tecla) {
					case 1:
						System.out.println("Digite o nome do usuário: ");
						insere.nextLine();
						String nomeUsuario = insere.nextLine();
						System.out.println("Insira o CPF do Usuário");
						String cpf = insere.nextLine();
						Usuario usuario = new Usuario(nomeUsuario, cpf);
						biblioteca.adicionaUsuario(usuario);
						break;
					case 2:
						Biblioteca.listaUsuarios();
						break;
					case 0:
						System.out.println("Obrigado por utilizar a Biblioteca!");
						break;
					default:
						System.out.println("Selecione uma opção válida!");
					}
				} while (tecla != 0);
				break;
			case 3:
				do {
					System.out.println("Escolha uma opção: ");
					System.out.println("\n1. Buscar por título \n2. Buscar por autor \n0. Sair");
					tecla = insere.nextInt();

					switch (tecla) {
					case 1:
						System.out.println("Insira o título: ");
						insere.nextLine();
						String tituloLivro = insere.nextLine();
						System.out.println(biblioteca.buscaTitulo(tituloLivro));
						break;
					case 2:
						System.out.println("Insira o nome do Autor: ");
						insere.nextLine();
						String nomeAutor = insere.nextLine();
						System.out.println(biblioteca.buscaNomeAutor(nomeAutor));
						break;
					case 0:
						System.out.println("Obrigado por utilizar a Biblioteca!");
						break;
					default:
						System.out.println("Selecione uma opção válida!");
					}
				} while (tecla != 0);
				break;
			case 4:
				do {
					System.out.println("Escolha uma opção: ");
					System.out.println(
							"\n1. Registrar Empréstimo \n2. Renovar Empréstimo \n3. Devolver Empréstimo \n0. Sair");
					tecla = insere.nextInt();

					switch (tecla) {
					case 1:
						Biblioteca.listaUsuarios();
						System.out.println("Escolha o usuário (ID): ");
						int idUser = insere.nextInt();
						biblioteca.listaLivros();
						System.out.println("Escolha o livro (ID): ");
						int idLivro = insere.nextInt();
						System.out.println("Digite o dia do empréstimo (dd): ");
						int dia = insere.nextInt();
						System.out.println("Digite o mês do empréstimo (mm): ");
						int mes = insere.nextInt();
						System.out.println("Digite o ano do empréstimo (yyyy): ");
						int ano = insere.nextInt();
						empresta.adicionaEmprestimo(idUser, idLivro, LocalDate.of(ano, mes, dia));
						break;
					case 2:
						relatorio.listaEmprestimos();
						System.out.println("Digite o número do empréstimo a renovar (ID): ");
						int renovar = insere.nextInt();
						System.out.println("Digite o dia de renovação do empréstimo: ");
						int diaRenovacao = insere.nextInt();
						System.out.println("Digite o mês de renovação do empréstimo: ");
						int mesRenovacao = insere.nextInt();
						System.out.println("Digite o ano de renovação do empréstimo: ");
						int anoRenovacao = insere.nextInt();
						empresta.renovaEmprestimo(renovar, LocalDate.of(anoRenovacao, mesRenovacao, diaRenovacao));
						break;
					case 3:
						relatorio.listaEmprestimos();
						System.out.println("Digite o empréstimo a devolver (ID): ");
						int devolver = insere.nextInt();
						System.out.println("Digite o dia da devolução do empréstimo: ");
						int diaDevolucao = insere.nextInt();
						System.out.println("Digite o mês da devolução do empréstimo: ");
						int mesDevolucao = insere.nextInt();
						System.out.println("Digite o ano da devolução do empréstimo: ");
						int anoDevolucao = insere.nextInt();
						empresta.devolveEmprestimo(devolver, LocalDate.of(anoDevolucao, mesDevolucao, diaDevolucao));
						break;
					case 0:
						System.out.println("Obrigado por utilizar a Biblioteca!");
						break;
					default:
						System.out.println("Selecione uma opção válida!");
					}
				} while (tecla != 0);
				break;
			case 5:
				do {
					System.out.println("Escolha uma opção: ");
					System.out.println(
							"\n1. Ver livros emprestados \n2. Exibir Top 10 usuários que locam livros \n3. Exibir relatório de usuários com empréstimos atrasados \n0. Sair");
					tecla = insere.nextInt();

					switch (tecla) {
					case 1:
						relatorio.listaEmprestimos();
						break;
					case 2:
						relatorio.listaTop10Usuarios();
						break;
					case 3:
						relatorio.listaAtrasos();
						break;
					case 0:
						System.out.println("Obrigado por utilizar a Biblioteca!");
						break;
					default:
						System.out.println("Selecione uma opção válida!");
					}
				} while (tecla != 0);
				break;
			case 0:
				System.out.println("Obrigado por utilizar a Biblioteca!");
				break;
			default:
				System.out.println("Selecione uma opção válida!");
			}

		} while (tecla != 0);
		insere.close();
	}
}