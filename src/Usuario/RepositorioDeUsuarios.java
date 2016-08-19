package Usuario;

import java.util.HashSet;

public class RepositorioDeUsuarios {

	private HashSet<Usuario> repositorioUsuarios = new HashSet<Usuario>();
	
	public void agregarUsuario(Usuario usuario) {
		this.repositorioUsuarios.add(usuario);
	}
		
}
