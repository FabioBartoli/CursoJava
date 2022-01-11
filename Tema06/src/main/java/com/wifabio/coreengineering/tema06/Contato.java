package com.wifabio.coreengineering.tema06;

public class Contato {
	private String nome;
	private String telefone;
	private int id;
	private static int cont = 1;

	public Contato(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.id = cont++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\n-----------------------\n" + "ID do Contato: " + this.getId() + "\nNome do contato: " + this.nome + "\nTelefone: " + this.telefone + "\n----------------------";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
