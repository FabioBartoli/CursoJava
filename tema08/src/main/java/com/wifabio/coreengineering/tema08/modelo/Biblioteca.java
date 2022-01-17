package com.wifabio.coreengineering.tema08.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DadosInvalidosException;
import exceptions.ErroEscritaException;
import exceptions.LivroJaCadastradoException;
import exceptions.UsuarioJaCadastradoException;

public class Biblioteca {

	private List<Livro> biblioteca = new ArrayList<Livro>();
	private List<Usuario> cadastro = new ArrayList<Usuario>();
	GuardadorDeDados guardador = new GuardadorDeDados();

	public int contLivro = 1;
	public int contUser = 1;

	public void adicionaLivro(Livro livro)
			throws DadosInvalidosException, LivroJaCadastradoException, ErroEscritaException {
		if (this.biblioteca.contains(livro)) {
			throw new LivroJaCadastradoException();
		} else {
			if (livro.getAutor() != null && livro.getTitulo() != null) {
				try {
					int idLivro = livro.setId(contLivro++);
					biblioteca.add(livro);
					guardador.salvaLivros(biblioteca, livro, idLivro);
				} catch (Exception e) {
					throw new ErroEscritaException();
				}
			} else {
				throw new DadosInvalidosException();
			}
		}
	}

//	public boolean salvaLivros(boolean b) throws IOException {
//		String jsonUser = new Gson().toJson(biblioteca);
//		try {
//			FileWriter fileUser = new FileWriter("guardaDados/livros.json");
//			fileUser.write(jsonUser);
//			fileUser.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return b;
//	}

	public void listaLivros() {
		for (Livro livro : biblioteca) {
			System.out.println(livro);
		}
	}

	public void adicionaUsuario(Usuario usuario) throws UsuarioJaCadastradoException, IOException {
		if (this.cadastro.contains(usuario)) {
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

//	public boolean salvaUsuarios(boolean u) throws IOException {
//		String jsonUser = new Gson().toJson(cadastro);
//		try {
//			FileWriter fileUser = new FileWriter("guardaDados/usuarios.json");
//			fileUser.write(jsonUser);
//			fileUser.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return u;
//	}

}
