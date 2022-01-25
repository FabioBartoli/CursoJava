package com.wifabio.coreengineering.tema08.modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.wifabio.coreengineering.tema08.exceptions.ErroEscritaException;

public class GuardadorDeDados {

	private static String estanteLivros = "guardaDados/livros.json";
	private static String sistemaCadastro = "guardaDados/usuarios.json";
	private static String emprestimos = "guardaDados/emprestimos.json";


	public void salvaLivros(List<Livro> biblioteca, Livro livro) throws ErroEscritaException, IOException {
		String jsonUser = new Gson().toJson(biblioteca);
		int contLivro = 0;
		for (int i = 0; i <= biblioteca.size(); i++) {
			livro.setId(contLivro++);
			FileWriter fileLivro = new FileWriter(estanteLivros);
			try {
				fileLivro.write(jsonUser);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fileLivro.close();
			}
		}
	}

	public void salvaUsuarios(List<Usuario> cadastro, Usuario usuario) throws IOException {
		int contUser = 0;
		String jsonUser = new Gson().toJson(cadastro);
		for (int i = 0; i <= cadastro.size(); i++) {
			usuario.setIdUser(contUser++);
			FileWriter fileUser = new FileWriter(sistemaCadastro);
			try {
				fileUser.write(jsonUser);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fileUser.close();
			}
		}
	}

	public void registraEmprestimo(List<Emprestimo> emprestar) throws IOException {
		String jsonUser = new Gson().toJson(emprestar);
		for (int i = 0; i <= emprestar.size(); i++) {
			FileWriter fileLivro = new FileWriter(emprestimos);
			try {
				fileLivro.write(jsonUser);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fileLivro.close();
			}
		}		
	}

}
