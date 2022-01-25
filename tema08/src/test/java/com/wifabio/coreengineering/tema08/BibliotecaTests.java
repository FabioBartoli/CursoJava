package com.wifabio.coreengineering.tema08;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.wifabio.coreengineering.tema08.exceptions.DadosInvalidosException;
import com.wifabio.coreengineering.tema08.exceptions.ErroEscritaException;
import com.wifabio.coreengineering.tema08.exceptions.LivroEmprestadoException;
import com.wifabio.coreengineering.tema08.exceptions.LivroJaCadastradoException;
import com.wifabio.coreengineering.tema08.exceptions.UsuarioJaCadastradoException;
import com.wifabio.coreengineering.tema08.modelo.Biblioteca;
import com.wifabio.coreengineering.tema08.modelo.Livro;
import com.wifabio.coreengineering.tema08.modelo.Usuario;

public class BibliotecaTests {

	@Test
	public void deveriaAdicionarUsuario() throws UsuarioJaCadastradoException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Usuario usuario = new Usuario("Fabio Bartoli", "456789123");
		biblioteca.adicionaUsuario(usuario);
		assertEquals(Biblioteca.getUsuarios().get(0).getNomeUsuario(), "Fabio Bartoli");
	}

	@Test
	public void deveriaRetornarErroPorCPFJaEstarCadastrado() throws UsuarioJaCadastradoException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Usuario usuario1 = new Usuario("Fabio Bartoli", "4567891232");
		Usuario usuario2 = new Usuario("Outro Usuario", "4567891232");
		assertThrows(UsuarioJaCadastradoException.class, () -> {
			biblioteca.adicionaUsuario(usuario1);
			biblioteca.adicionaUsuario(usuario2);
		});
	}
	
	@Test
	public void deveriaAdicionarLivro() throws DadosInvalidosException, LivroJaCadastradoException, ErroEscritaException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Livro adicionaLivro = new Livro("Código Limpo", "Robert C. Martin", 23);
		biblioteca.adicionaLivro(adicionaLivro);
		int idLivro = adicionaLivro.getId()-1;
		assertEquals(Biblioteca.getBiblioteca().get(idLivro).getTitulo(), "Código Limpo");
	}

	@Test
	public void deveriaExcluirLivroQueNaoEstaEmprestado() throws DadosInvalidosException, LivroJaCadastradoException, ErroEscritaException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Livro livro2 = new Livro("Blade Runner", "Philip K. Dick", 10);
		biblioteca.adicionaLivro(livro2);
		int idLivro = livro2.getId();
		biblioteca.excluiLivro(0);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			Biblioteca.getBiblioteca().get(idLivro);
		});
	}
	
	@Test
	public void deveriaRetornarErroPeloTituloDoLivroEstarVazio() throws DadosInvalidosException, LivroJaCadastradoException, ErroEscritaException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Livro livro = new Livro("", "Fabio Bartoli", 8);
		assertThrows(DadosInvalidosException.class, () -> {
			biblioteca.adicionaLivro(livro);
		});
	}
	
	@Test
	public void deveriaRetornarErroPeloNomeAutorEstarVazio() throws DadosInvalidosException, LivroJaCadastradoException, ErroEscritaException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Livro livro = new Livro("Livro Bom", "", 8);
		assertThrows(DadosInvalidosException.class, () -> {
			biblioteca.adicionaLivro(livro);
		});
	}
	
	@Test
	public void deveriaRetornarErroPelaQuantidadeDeLivrosSerZero() {
		Biblioteca biblioteca = new Biblioteca();
		Livro livro = new Livro("Arquitetura Limpa", "Robert C. Martin", 0);
		assertThrows(DadosInvalidosException.class, () -> {
			biblioteca.adicionaLivro(livro);
		});
	}
	
	
	@Test
	public void deveriaRetornarErroPorTentarExcluirLivroQueEstaEmprestado()
			throws LivroEmprestadoException, UsuarioJaCadastradoException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Livro livro3 = new Livro("Carrie", "Stephen Kink", 5);
		Usuario usuarioNovo = new Usuario("João da Silva", "1234156");
		biblioteca.adicionaLivro(livro3);
		biblioteca.adicionaUsuario(usuarioNovo);
		livro3.setEstoque(4);
		assertThrows(LivroEmprestadoException.class, () -> {
			biblioteca.excluiLivro(2);
		});
	}
	
	@Test
	public void deveriaRetornarErroAoTentarCadastrarLivroJaCadastrado() throws DadosInvalidosException, LivroJaCadastradoException, ErroEscritaException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Livro livroH = new Livro("Harry Potter", "J. K. Rowling", 5);
		Livro livroH2 = new Livro("Harry Potter", "J. K. Rowling", 15);
		biblioteca.adicionaLivro(livroH);
		assertThrows(LivroJaCadastradoException.class, () -> {
			biblioteca.adicionaLivro(livroH2);
		});
	}
	
}
