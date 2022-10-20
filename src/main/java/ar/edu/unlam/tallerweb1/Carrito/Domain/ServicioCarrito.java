package ar.edu.unlam.tallerweb1.Carrito.Domain;
import ar.edu.unlam.tallerweb1.Libro.Domain.Libro;
import ar.edu.unlam.tallerweb1.Usuario.Domain.Usuario;

import java.util.List;

public interface ServicioCarrito{

    void agregarLibroAlCarrito(Usuario usuario, Libro libro);
    void quitarLibroDelCarrito(Integer id, Integer usuario);
    List<Integer> obtenerListaDeIdDeLibrosDelCarrito(Integer usuarioId);

}
