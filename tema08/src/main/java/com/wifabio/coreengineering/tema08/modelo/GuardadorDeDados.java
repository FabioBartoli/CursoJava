package com.wifabio.coreengineering.tema08.modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import exceptions.ErroEscritaException;

public class GuardadorDeDados {

	private static String estanteLivros = "guardaDados/livros.json";
	private static String sistemaCadastro = "guardaDados/usuarios.json";

	public void salvaLivros(List<Livro> biblioteca, Livro livro, int idLivro) throws ErroEscritaException, IOException {
		String jsonUser = new Gson().toJson(biblioteca);
		for (int i = 0; i <= biblioteca.size(); i++) {
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

	public void salvaUsuarios(List<Usuario> cadastro, Usuario usuario, int idUser) throws IOException {
		String jsonUser = new Gson().toJson(cadastro);
		for (int i = 0; i <= cadastro.size(); i++) {
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

}
