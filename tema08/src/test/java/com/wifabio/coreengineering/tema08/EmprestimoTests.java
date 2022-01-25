package com.wifabio.coreengineering.tema08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.wifabio.coreengineering.tema08.exceptions.DadosInvalidosException;
import com.wifabio.coreengineering.tema08.exceptions.EmprestimoInvalidoException;
import com.wifabio.coreengineering.tema08.exceptions.ErroEscritaException;
import com.wifabio.coreengineering.tema08.exceptions.LivroJaCadastradoException;
import com.wifabio.coreengineering.tema08.exceptions.UsuarioJaCadastradoException;
import com.wifabio.coreengineering.tema08.exceptions.UsuarioOuLviroInvalidoException;
import com.wifabio.coreengineering.tema08.modelo.Biblioteca;
import com.wifabio.coreengineering.tema08.modelo.Livro;
import com.wifabio.coreengineering.tema08.modelo.Usuario;
import com.wifabio.coreengineering.tema08.servicos.ServicoEmprestimo;

public class EmprestimoTests {

	@Test
	public void deveriaEmprestarLivro() throws UsuarioJaCadastradoException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Usuario usuario = new Usuario("Fabio Bartoli", "123456789");
		Livro livro = new Livro("Outsider", "Stephen Kink", 3);
		biblioteca.adicionaUsuario(usuario);
		biblioteca.adicionaLivro(livro);
		int idUser = usuario.getIdUser();
		int idLivro = livro.getId();
		ServicoEmprestimo empresta = new ServicoEmprestimo();
		empresta.adicionaEmprestimo(idUser, idLivro, LocalDate.of(2022, 01, 20));
		assertEquals(empresta.getEmpresta().get(0).getUsuario().getNomeUsuario(), "Fabio Bartoli");
		assertEquals(empresta.getEmpresta().get(0).getLivro(), livro);
	}

	@Test
	public void deveriaDarErroPeloIDDoUsuarioSerInvalido() throws UsuarioJaCadastradoException, IOException {
		ServicoEmprestimo empresta = new ServicoEmprestimo();
		assertThrows(UsuarioOuLviroInvalidoException.class, () -> {
			empresta.adicionaEmprestimo(5, 0, LocalDate.of(2022, 01, 20));
		});
	}

	@Test
	public void deveriaDarErroPeloIDDoLivroSerInvalido() throws UsuarioJaCadastradoException, IOException {
		ServicoEmprestimo empresta = new ServicoEmprestimo();
		assertThrows(UsuarioOuLviroInvalidoException.class, () -> {
			empresta.adicionaEmprestimo(0, 5, LocalDate.of(2022, 01, 20));
		});
	}

	@Test
	public void deveriaDarErroPoisOUsuarioJaEstaComCincoLivrosEmprestados()
			throws DadosInvalidosException, LivroJaCadastradoException, ErroEscritaException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		ServicoEmprestimo empresta = new ServicoEmprestimo();
		Usuario usuarioNovo = new Usuario("João Silva", "456789123");
		Livro livroNovo = new Livro("Eu, Robô", "Isaac Asimov", 7);
		biblioteca.adicionaLivro(livroNovo);
		biblioteca.adicionaUsuario(usuarioNovo);
		empresta.adicionaEmprestimo(usuarioNovo.getIdUser(), livroNovo.getId(), LocalDate.of(2022, 01, 22));
		empresta.adicionaEmprestimo(usuarioNovo.getIdUser(), livroNovo.getId(), LocalDate.of(2022, 01, 22));
		empresta.adicionaEmprestimo(usuarioNovo.getIdUser(), livroNovo.getId(), LocalDate.of(2022, 01, 22));
		empresta.adicionaEmprestimo(usuarioNovo.getIdUser(), livroNovo.getId(), LocalDate.of(2022, 01, 22));
		empresta.adicionaEmprestimo(usuarioNovo.getIdUser(), livroNovo.getId(), LocalDate.of(2022, 01, 22));
		assertThrows(EmprestimoInvalidoException.class, () -> {
			empresta.adicionaEmprestimo(usuarioNovo.getIdUser(), livroNovo.getId(), LocalDate.of(2022, 01, 22));
		});
	}

	@Test
	public void deveriaDarErroPoisOLivroEstaSemEstoqueParaEmprestar()
			throws DadosInvalidosException, LivroJaCadastradoException, ErroEscritaException, IOException {
		Biblioteca biblioteca = new Biblioteca();
		Livro livroSemEstoque = new Livro("O Morro dos Ventos Uivantes", "Emily Brontë", 1);
		Usuario usuarioEmprestimo = new Usuario("Maria Carla", "22222222");
		biblioteca.adicionaUsuario(usuarioEmprestimo);
		biblioteca.adicionaLivro(livroSemEstoque);
		int idUsuario = usuarioEmprestimo.getIdUser();
		int idLivro = livroSemEstoque.getId();
		ServicoEmprestimo empresta = new ServicoEmprestimo();
		empresta.adicionaEmprestimo(idUsuario, idLivro, LocalDate.of(2022, 01, 22));
		assertThrows(EmprestimoInvalidoException.class, () -> {
			empresta.adicionaEmprestimo(idUsuario, idLivro, LocalDate.of(2022, 01, 22));
		});
	}

}