package com.wifabio.coreengineering.tema08.servicos;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.wifabio.coreengineering.tema08.exceptions.EmprestimoInvalidoException;
import com.wifabio.coreengineering.tema08.exceptions.UsuarioJaCadastradoException;
import com.wifabio.coreengineering.tema08.exceptions.UsuarioOuLviroInvalidoException;
import com.wifabio.coreengineering.tema08.modelo.Biblioteca;
import com.wifabio.coreengineering.tema08.modelo.Emprestimo;
import com.wifabio.coreengineering.tema08.modelo.GuardadorDeDados;
import com.wifabio.coreengineering.tema08.modelo.Livro;
import com.wifabio.coreengineering.tema08.modelo.Usuario;

public class ServicoEmprestimo {
	GuardadorDeDados guardador = new GuardadorDeDados();
	private List<Emprestimo> empresta = new ArrayList<Emprestimo>();

	public List<Emprestimo> getEmpresta() {
		return empresta;
	}

	public void setEmpresta(List<Emprestimo> emprestar) {
		this.empresta = emprestar;
	}

	public List<Usuario> listaCadastros() {
		List<Usuario> listaCadastro = Biblioteca.getCadastro();
		return listaCadastro;
	}

	public List<Livro> listaLivros() {
		List<Livro> listaLivro = Biblioteca.getBiblioteca();
		return listaLivro;
	}

	public void adicionaEmprestimo(int idUser, int idLivro, LocalDate dataEmprestimo)
			throws IOException, UsuarioJaCadastradoException {
		System.out.println("Emprestimo solicitado... consultando...");
		if (idUser <= listaCadastros().size() && idLivro <= listaLivros().size()) {
			Usuario usuario = listaCadastros().stream().filter(a -> a.getIdUser() == idUser)
					.collect(Collectors.toList()).get(0);
			Livro livro = listaLivros().stream().filter(a -> a.getId() == idLivro).collect(Collectors.toList()).get(0);

			if (usuario.getQtdeLivrosEmprestados() < 5 && livro.getEstoque() > 0) {
				System.out.println("Emprestimo realizado! Confira os dados:");

				usuario.setQtdeLivrosEmprestados(usuario.getQtdeLivrosEmprestados() + 1);
				livro.setEstoque(livro.getEstoque() - 1);

				LocalDate dataDevolucao = dataEmprestimo.plusDays(7);
				Emprestimo emprestimo = new Emprestimo(usuario, livro, dataEmprestimo, dataDevolucao);

				for (Emprestimo outroEmprestimo : empresta) {
					int novoID = outroEmprestimo.getIdEmprestimo() + 1;
					emprestimo.setIdEmprestimo(novoID);
				}

				empresta.add(emprestimo);
				guardador.registraEmprestimo(empresta);
				System.out.println(emprestimo);
			} else {
				throw new EmprestimoInvalidoException();
			}

		} else {
			throw new UsuarioOuLviroInvalidoException();
		}
	}

	public void devolveEmprestimo(int idEmprestimo, LocalDate dataDevolucaoReal)
			throws IOException, EmprestimoInvalidoException {
		Collections.sort(empresta, new Comparator<Emprestimo>() {
			@Override
			public int compare(Emprestimo emprestimo1, Emprestimo emprestimo2) {
				String id1 = String.valueOf(emprestimo1.getIdEmprestimo());
				String id2 = String.valueOf(emprestimo2.getIdEmprestimo());
				return id1.compareTo(id2);
			}
		});
		Emprestimo emprestimo = empresta.get(idEmprestimo);
		Usuario usuario = emprestimo.getUsuario();
		Livro livro = emprestimo.getLivro();
		Duration prov = Duration.between(dataDevolucaoReal.atStartOfDay(), emprestimo.dataDevolucao.atStartOfDay());
		long expiracao = prov.toDays();
		System.out.println("\n------------------------\nRemovendo o seguinte empréstimo: ");
		System.out.println(emprestimo);
		System.out.println("Data real da devolução: " + dataDevolucaoReal);
		if (expiracao < 0) {
			float multa = (expiracao * -1) * 5;
			System.out
					.println("Será cobrada multa no valor de R$" + multa + " pelo atraso na devolução do empréstimo!");
		} else {
			System.out.println("O livro foi devolvido dentro do período de empréstimo, portanto, não há multas!");
		}
		empresta.remove(emprestimo);
		System.out.println("Emprestimo removido!");
		usuario.setQtdeLivrosEmprestados(usuario.getQtdeLivrosEmprestados() - 1);
		livro.setEstoque(livro.getEstoque() + 1);
		System.out.println("Agora, o livro '" + livro.getTitulo() + "' está com a seguinte quantidade em estoque: "
				+ livro.getEstoque());
		guardador.registraEmprestimo(empresta);
	}

	public void renovaEmprestimo(int idEmprestimo, LocalDate dataRenovacao) throws IOException {
		Collections.sort(empresta, new Comparator<Emprestimo>() {
			@Override
			public int compare(Emprestimo emprestimo1, Emprestimo emprestimo2) {
				String id1 = String.valueOf(emprestimo1.getIdEmprestimo());
				String id2 = String.valueOf(emprestimo2.getIdEmprestimo());
				return id1.compareTo(id2);
			}
		});
		System.out.println("\n------------------------\nTentando renovar o empréstimo.....");
		Emprestimo emprestimo = empresta.get(idEmprestimo);
		long expiracao = emprestimo.getTempoExpira();
		empresta.remove(emprestimo);
		if (expiracao >= 0) {
			System.out.println("\n------------------------\nAtualmente, os dados eram: ");
			System.out.println(emprestimo);
			LocalDate novaDevolucao = emprestimo.dataDevolucao.plusDays(7);
			emprestimo.setDataDevolucao(novaDevolucao);
			empresta.add(emprestimo);
			guardador.registraEmprestimo(empresta);
			System.out.println("\nAgora, a nova data para devolução do livro é: " + novaDevolucao);
		} else {
			System.out.println("Não é possível renovar o empréstimo, pois a devolução está atrasada!! Confira:");
			System.out.println(emprestimo);
		}

	}

}
