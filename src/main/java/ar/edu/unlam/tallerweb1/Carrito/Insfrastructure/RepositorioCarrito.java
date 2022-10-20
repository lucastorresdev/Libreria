package ar.edu.unlam.tallerweb1.Carrito.Insfrastructure;
import ar.edu.unlam.tallerweb1.Libro.Domain.Libro;
import ar.edu.unlam.tallerweb1.Usuario.Domain.Usuario;

import java.util.List;

public interface RepositorioCarrito{

    void agregarLibroAlCarrito(Usuario usuario, Libro libro);
    List <Integer> obtenerListaDeIdDeLibrosDelCarrito(Usuario usuario);
    void quitarLibroDelCarrito(Usuario usuario, Libro libro);

}
