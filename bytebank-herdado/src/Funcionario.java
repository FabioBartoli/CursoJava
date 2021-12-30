//Não podemos instanciar essa classe, pois é abstrata
public abstract class Funcionario {

	private String nome;
	private String cpf;
	private double salario;
	

	
	public Funcionario() {
		
	}
	
	public abstract double getBonificacao(); //Abstract no método significa que o método não tem uma implementação aqui, mas os filhos precisam dele

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
