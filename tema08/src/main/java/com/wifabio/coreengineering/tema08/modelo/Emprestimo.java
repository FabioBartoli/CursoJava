package com.wifabio.coreengineering.tema08.modelo;

import java.time.Duration;
import java.time.LocalDate;

public class Emprestimo {

	private int idEmprestimo = 0;
	private Usuario usuario;
	private Livro livro;
	private LocalDate dataEmprestimo;
	public LocalDate dataDevolucao;

	public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		super();
		this.usuario = usuario;
		this.livro = livro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public long getTempoExpira() {
		LocalDate dataAtual = LocalDate.now();
		Duration prov = Duration.between(dataAtual.atStartOfDay(), dataDevolucao.atStartOfDay());
		long tempoExpira = prov.toDays();
		return tempoExpira;
	}

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	public int setIdEmprestimo(int idEmprestimo) {
		return this.idEmprestimo = idEmprestimo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public String toString() {
		return "\nID do Empréstimo: " + this.idEmprestimo + "\nUsuário: "
				+ usuario.getNomeUsuario() + "\nLivro: " + livro.getTitulo() + "\nData emprestimo: "
				+ this.dataEmprestimo + "\nData Devolução Esperada: " + this.dataDevolucao
				+ "\nTempo para devolução do livro: " + getTempoExpira() + " dias" + "\nEstoque restante do livro '"
				+ livro.getTitulo() + "': " + livro.getEstoque() + "\n------------------------";
	}

}
