package ar.edu.unlam.tallerweb1.Usuario.Domain;

import ar.edu.unlam.tallerweb1.Usuario.Domain.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(String email, String password);

	Usuario buscarUsuarioPorId(Integer usuarioId);
}
