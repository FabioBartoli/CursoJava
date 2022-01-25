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

public class Biblioteca {

	private static List<Livro> biblioteca = new ArrayList<Livro>();
	private static List<Usuario> cadastro = new ArrayList<Usuario>();
	private GuardadorDeDados guardador = new GuardadorDeDados();

	public static List<Livro> getBiblioteca() {
		List<Livro> copiaBiblioteca = new ArrayList<Livro>();
		for (int i = 0; i <= biblioteca.size()-1; i++) {
			copiaBiblioteca.add(biblioteca.get(i));
		}
		return copiaBiblioteca;
	}

	public static List<Usuario> getCadastro() {
		List<Usuario> copiaCadastro = new ArrayList<Usuario>();
		for(int i = 0; i <= cadastro.size()-1; i++) {
			copiaCadastro.add(cadastro.get(i));
		}
		return copiaCadastro;
	}

	public void adicionaLivro(Livro livro)
			throws DadosInvalidosException, LivroJaCadastradoException, ErroEscritaException, IOException {
		if (Biblioteca.biblioteca.contains(livro)) {
			throw new LivroJaCadastradoException();
		}
		if (livro.getAutor() != null && livro.getTitulo() != null && !livro.getAutor().isBlank()
				&& !livro.getTitulo().isBlank() && livro.getEstoqueInicial() > 0) {
			try {
				biblioteca.add(livro);
				guardador.salvaLivros(biblioteca, livro);
			} catch (Exception e) {
				throw new ErroEscritaException("Não foi possível salvar o livro na biblioteca!");
			}
		} else {
			throw new DadosInvalidosException();
		}
	}

	public void listaLivros() throws IOException {
		for (Livro livro : biblioteca) {
			System.out.println(livro);
		}
	}

	public void adicionaUsuario(Usuario usuario) throws UsuarioJaCadastradoException, ErroEscritaException, IOException {
		if (Biblioteca.cadastro.contains(usuario)) {
			throw new UsuarioJaCadastradoException();
		} else {
			if (usuario.getCpf() != null && usuario.getNomeUsuario() != null) {
				try {
					cadastro.add(usuario);
					guardador.salvaUsuarios(cadastro, usuario);
				} catch (Exception e) {
					throw new ErroEscritaException("Não foi possível adicionar o cadastro deste usuário!");
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

	public List<Livro> buscaTitulo(String tituloLivro) {
		return biblioteca.stream().filter(c -> c.getTitulo().contains(tituloLivro)).collect(Collectors.toList());
	}

	public List<Livro> buscaNomeAutor(String nomeAutor) {
		return biblioteca.stream().filter(c -> c.getAutor().contains(nomeAutor)).collect(Collectors.toList());
	}

}
