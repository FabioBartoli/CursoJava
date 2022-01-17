package exceptions;

public class UsuarioJaCadastradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UsuarioJaCadastradoException() {
		super("Este CPF já está sendo utilizado por um usuário!");
	}

}
