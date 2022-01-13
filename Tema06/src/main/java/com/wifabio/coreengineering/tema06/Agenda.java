package com.wifabio.coreengineering.tema06;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Agenda {

	List<Contato> agendaDeContatos = new ArrayList<Contato>();

	public void adicionaContato(Contato contato) {
		agendaDeContatos.add(contato);
	}

	public void removeContatoPeloNome(String removeContatoNome) {
		agendaDeContatos.removeIf(x -> x.getNome().equals(removeContatoNome));
	}

	public void removeContatoPeloID(int removeContatoID) {
		agendaDeContatos.removeIf(x -> x.getId() == removeContatoID);
	}

	public List<Contato> listaContato() {
		for (Contato contato : agendaDeContatos) {
			System.out.println(contato);
		}
		return agendaDeContatos;
	}

	public List<Contato> buscaContatoNome(String nomeContato) {
		return agendaDeContatos.stream().filter(c -> c.getNome().contains(nomeContato)).collect(Collectors.toList());
	}

	public Optional<Contato> buscaContatoID(int contatoID) {
		for (Contato contato : agendaDeContatos) {
			if (contatoID == contato.getId()) {
				return Optional.ofNullable(contato);
			}
		}
		return Optional.empty();
	}
}
