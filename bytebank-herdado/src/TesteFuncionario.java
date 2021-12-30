
public class TesteFuncionario {

	public static void main(String[] args) {

		Gerente nico = new Gerente(); //Existe o TIPO funcionário, mas não podemos mais chamar ela diretamente como "new"
		nico.setNome("Nico Steppat");
		nico.setCpf("22355646-9");
		nico.setSalario(2600.00);
		
		System.out.println(nico.getNome());
		System.out.println(nico.getBonificacao());
	}

}
