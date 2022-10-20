package ar.edu.unlam.tallerweb1.Carrito.Domain;
import ar.edu.unlam.tallerweb1.Libro.Domain.Libro;
import ar.edu.unlam.tallerweb1.Usuario.Domain.Usuario;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Carrito")
public class Carrito{

    public Carrito(){

    }

    public Carrito(Usuario usuario, Libro libro, Integer cantidad){

        this.usuario = usuario;
        this.libro = libro;
        this.cantidad = cantidad;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_libro")
    private Libro libro;

    @Column(name = "Cantidad")
    private Integer cantidad;


}
