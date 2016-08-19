package Usuario;
import Usuario.Usuario;

public abstract class Login {
		
	public static Usuario iniciarSesion (Usuario usuarioAValidar, String passwordIngresado) {
		return usuarioAValidar.validarPassword(passwordIngresado);
	}

}
