package ar.edu.unlam.tallerweb1.Usuario.Domain;
import ar.edu.unlam.tallerweb1.Usuario.Domain.Usuario;

public interface ServicioRegistro {
    Usuario consultarUsuario(String email, String usuarioName);

    void almacenarUsuario(Usuario usuarioBuscado);
}
