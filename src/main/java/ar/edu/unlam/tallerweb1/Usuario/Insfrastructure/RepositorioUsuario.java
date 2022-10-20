package ar.edu.unlam.tallerweb1.Usuario.Insfrastructure;
import ar.edu.unlam.tallerweb1.Usuario.Domain.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario buscarUsuario(String email, String password);
	void guardar(Usuario usuario);
    Usuario buscar(String email);
	Usuario busquedaUsuarioName(String userName);
	void modificar(Usuario usuario);

    Usuario buscarUsuarioPorId(Integer usuarioId);

}
