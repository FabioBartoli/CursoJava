package com.wifabio.coreengineering.tema08.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wifabio.coreengineering.tema08.exceptions.DadosInvalidosException;
import com.wifabio.coreengineering.tema08.exceptions.ErroEscritaException;
import com.wifabio.coreengineering.tema08.exceptions.LivroEmprestadoException;
import com.wifabio.coreengineering.tema08.exceptions.LivroJaCadastradoException;
import com.wifabio.coreengineering.tema08.exceptions.UsuarioJaCadastradoException;
import com.wifabio.coreengineering.tema08.servicos.ServicoEmprestimo;

public class Biblioteca {

	private static List<Livro> biblioteca = new ArrayList<Livro>();
	private static List<Usuario> cadastro = new ArrayList<Usuario>();
	GuardadorDeDados guardador = new GuardadorDeDados();
	ServicoEmprestimo emprestimo = new ServicoEmprestimo();
	public int contLivro = 1;

	public static List<Livro> getBiblioteca() {
		return biblioteca;
	}
	
	public static List<Usuario> getCadastro() {
		return cadastro;
	}

	public int contUser = 1;

	public void adicionaLivro(Livro livro)
			throws DadosInvalidosException, LivroJaCadastradoException, ErroEscritaException, IOException {
		if (Biblioteca.biblioteca.contains(livro)) {
			throw new LivroJaCadastradoException();
		} else {
			if (livro.getAutor() != null && livro.getTitulo() != null && !livro.getAutor().isBlank()
					&& !livro.getTitulo().isBlank() && livro.getEstoqueInicial() > 0) {
				try {
					livro.setId(contLivro++);
					biblioteca.add(livro);
					guardador.salvaLivros(biblioteca, livro);
				} catch (Exception e) {
					throw new ErroEscritaException();
				}
			} else {
				throw new DadosInvalidosException();
			}
		}
	}

	public void listaLivros() throws IOException {
		for (Livro livro : biblioteca) {
			System.out.println(livro);
		}
	}

	public void adicionaUsuario(Usuario usuario) throws UsuarioJaCadastradoException, IOException {
		if (Biblioteca.cadastro.contains(usuario)) {
			throw new UsuarioJaCadastradoException();
		} else {
			if (usuario.getCpf() != null && usuario.getNomeUsuario() != null) {
				try {
					int idUser = usuario.setIdUser(contUser++);
					cadastro.add(usuario);
					guardador.salvaUsuarios(cadastro, usuario, idUser);
				} catch (Exception e) {
					throw new DadosInvalidosException();
				}
			} else {
				throw new DadosInvalidosException();
			}
		}
	}
	
	public static List<Usuario> listaUsuarios() throws IOException {
		for (Usuario usuario : cadastro) {
			System.out.println(usuario);
		}
		return cadastro;
	}
	
	public static List<Usuario> getUsuarios() throws IOException {
		for (Usuario usuario : cadastro) {
		}
		return cadastro;
	}

	public void excluiLivro(int livroID) throws LivroEmprestadoException, IOException, DadosInvalidosException {
		try {
			Livro livro = biblioteca.get(livroID);
			if (livro.getEstoque() != livro.getEstoqueInicial()) {
				throw new LivroEmprestadoException();
			} else {
				biblioteca.remove(livroID);
				livro.setEstoque(0);
				guardador.salvaLivros(biblioteca, livro);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\n*****ID Inválido!*******");
		}
	}

	public void buscaTitulo(String tituloLivro) {
		System.out.println(biblioteca.stream().filter(c -> c.getTitulo().contains(tituloLivro)).collect(Collectors.toList()));
	}
	
	public void buscaNomeAutor(String nomeAutor) {
		System.out.println(biblioteca.stream().filter(c -> c.getAutor().contains(nomeAutor)).collect(Collectors.toList()));
	}

}
