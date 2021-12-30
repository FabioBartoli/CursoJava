package bytebank;

public class TesteReferencias {
	public static void main(String[] args) {
		Conta terceiraConta = new Conta();
		terceiraConta.saldo = 300;
		
		System.out.println("Saldo da primeira: " + terceiraConta.saldo);
		
		Conta quartaConta = terceiraConta;
		System.out.println("Saldo da segunda: " + quartaConta.saldo);
		
		quartaConta.saldo += 100;
		System.out.println("Saldo da segunda: " + quartaConta.saldo);

		
		System.out.println("Saldo da primeira: " + terceiraConta.saldo);

		
		if(terceiraConta == quartaConta) {
			System.out.println("São a mesma conta!!");
		}
		
	}
}
