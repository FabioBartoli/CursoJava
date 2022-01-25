package com.wifabio.coreengineering.tema08.modelo;

public class Livro {

	private int id;
	private String titulo;
	private String autor;
	private int estoque;
	private int estoqueInicial;

	public Livro(String titulo, String autor, int estoque) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.estoque = estoque;
		estoqueInicial = estoque;
	}
	
	public int getEstoqueInicial() {
		return estoqueInicial;
	}

	public int getEstoque() {
		return estoque;
	}

	public int setEstoque(int estoque) {
		return this.estoque = estoque;
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "\nID do livro: " + this.id + "\nTítulo: " + this.titulo + "\nAutor: " + this.autor
				+ "\nQuantidade em estoque: " + this.estoque + "\n-----------------";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object outroLivro) {
		if (this == outroLivro)
			return true;
		if (outroLivro == null)
			return false;
		if (getClass() != outroLivro.getClass())
			return false;
		Livro other = (Livro) outroLivro;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
