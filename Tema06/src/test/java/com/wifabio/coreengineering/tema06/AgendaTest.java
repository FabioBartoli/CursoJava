package com.wifabio.coreengineering.tema06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class AgendaTest {
	Agenda agenda = new Agenda();
	Contato contato = new Contato("Fabio Bartoli", "123456");
	
	@Test
	public void deveriaRegistrarContato() {
		agenda.adicionaContato(contato);
		assertEquals(agenda.listaContato().get(0), contato);
	}
	
	@Test
	public void deveriaListarContatos() {
		agenda.adicionaContato(contato);
		assertEquals(1, agenda.listaContato().size());
	}

	@Test
	public void deveriaApagarContatoPeloID() {
		agenda.removeContatoPeloID(1);
		assertEquals(0,agenda.listaContato().size());
	}
	
	@Test
	public void deveriaApagarContatoPeloNome() {
		agenda.adicionaContato(contato);
		String nome = "Fabio Bartoli";
		agenda.removeContatoPeloNome(nome);
		assertEquals(0,agenda.listaContato().size());
	}
	
	@Test
	public void deveriaBuscarContatoPeloID() {
		agenda.adicionaContato(contato);
		int id = contato.getId();
		assertEquals(agenda.buscaContatoID(id).isPresent(), true);
	}

	@Test
	public void deveriaBuscarContatoPeloNome() {
		agenda.adicionaContato(contato);
		String nomeContato = "Fabio Bartoli";
		assertEquals(agenda.buscaContatoNome(nomeContato).contains(contato),true);
	}

}
