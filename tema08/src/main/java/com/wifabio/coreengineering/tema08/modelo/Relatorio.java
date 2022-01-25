package com.wifabio.coreengineering.tema08.modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.wifabio.coreengineering.tema08.servicos.ServicoEmprestimo;

public class Relatorio {

	private ServicoEmprestimo emprestimo = new ServicoEmprestimo();

	public Relatorio(ServicoEmprestimo emprestimo) {
		super();
		this.emprestimo = emprestimo;
	}

	public List<Emprestimo> listaEmprestimos() {
		List<Emprestimo> listaEmprestimo = emprestimo.getEmpresta();
		for (Emprestimo emprestimo : listaEmprestimo) {
			System.out.println(emprestimo);
		}
		return listaEmprestimo;
	}

	public List<Usuario> listaUsuarios() throws IOException {
		List<Usuario> listaUsuarios = Biblioteca.getUsuarios();
		return listaUsuarios;
	}

	public void listaTop10Usuarios() throws IOException {
		List<Usuario> listaUsuarios = listaUsuarios().stream()
				.sorted(Comparator.comparing(Usuario::getQtdeLivrosEmprestados).reversed())
				.collect(Collectors.toList());
		List<Usuario> listaTop10 = new ArrayList<Usuario>(10);
		for (int i = 0; i < listaUsuarios.size(); i++) {
			listaTop10.add(listaUsuarios.get(i));
			if (i == 9) {
				break;
			}
		}
		System.out.println(listaTop10);
	}

	public void listaAtrasos() {
		List<Emprestimo> emprestimos = emprestimo.getEmpresta();
		List<Emprestimo> atrasos = new ArrayList<Emprestimo>();
		for (Emprestimo emprestimo : emprestimos) {
			long diasAtraso = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), LocalDate.now());
			if (diasAtraso > 7) {
				atrasos.add(emprestimo);
			}
		}
		System.out.println(atrasos);
	}

}
