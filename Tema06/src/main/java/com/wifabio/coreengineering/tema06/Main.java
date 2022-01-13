package com.wifabio.coreengineering.tema06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		Scanner insere = new Scanner(System.in);
		int tecla;

		do {
			DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
			System.out.println("===============================");
			System.out.println("Bem-Vindo(a) a Agenda! --> " + LocalDateTime.now().format(formatadorComHoras));
			System.out.println("Escolha uma opção:");
			System.out.println("1. Registrar Contato " + "\n2. Remover Contato pelo Nome"
					+ "\n3. Remover Contato pelo ID" + "\n4. Listar todos Contatos" + "\n5. Buscar Contato pelo Nome"
					+ "\n6. Buscar Contato pelo ID" + "\n7. Sair");
			tecla = insere.nextInt();

			switch (tecla) {
			case 1:
				System.out.println("===============================");
				System.out.println("====> Registrar Contato:" + "\n Insira o Nome: ");
				insere.nextLine();
				String nome = insere.nextLine();
				System.out.println("Insira o Telefone: ");
				String telefone = insere.nextLine();
				agenda.adicionaContato(new Contato(nome, telefone));
				System.out.println("===============================");
				break;

			case 2:
				System.out.println("===============================");
				System.out.println("====> Remover Contato pelo Nome: ");
				System.out.println("Digite o Nome Completo do Contato: ");
				insere.nextLine();
				String removeContatoNome = insere.nextLine();
				agenda.removeContatoPeloNome(removeContatoNome);
				break;

			case 3:
				System.out.println("===============================");
				System.out.println("====> Remover Contato pelo ID: ");
				System.out.println("Digite o ID do Contato: ");
				insere.nextLine();
				int removeContatoID = insere.nextInt();
				agenda.removeContatoPeloID(removeContatoID);
				break;

			case 4:
				System.out.println("===============================");
				System.out.println("====> Listar Todos Contatos:");
				agenda.listaContato();
				break;

			case 5:
				System.out.println("Informe nome:");
				insere.nextLine();
				String nomeContato = insere.nextLine();
				System.out.println("===============================");
				System.out.println("Contato: ");
				List<Contato> buscaNome = agenda.buscaContatoNome(nomeContato);
				System.out.println(buscaNome);
				break;

			case 6:
				System.out.println("===============================");
				System.out.println("Informe ID:");
				int buscaID = insere.nextInt();
				System.out.println(agenda.buscaContatoID(buscaID));
				break;

			default:
				System.out.println("Opção não encontrada");
				break;
			}

		} while (tecla != 7);
	insere.close();
	}
}
