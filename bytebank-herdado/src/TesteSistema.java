
public class TesteSistema {

	public static void main(String[] args) {

		Gerente g = new Gerente();
		g.setSenha(2222);
		
		SistemaInterno si = new SistemaInterno();
		si.autentica(g);
		
		Administrador adm = new Administrador();
		adm.setSenha(222255);
		si.autentica(adm);
		
//		Designer d = new Designer();
//		d.setSenha(2222);
//		si.autentica(d);
	}

}
