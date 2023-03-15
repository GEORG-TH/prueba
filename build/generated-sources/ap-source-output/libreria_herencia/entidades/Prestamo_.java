package libreria_herencia.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import libreria_herencia.entidades.Cliente;
import libreria_herencia.entidades.Libro;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-09T18:44:13")
@StaticMetamodel(Prestamo.class)
public class Prestamo_ { 

    public static volatile SingularAttribute<Prestamo, Libro> libro;
    public static volatile SingularAttribute<Prestamo, Cliente> cliente;
    public static volatile SingularAttribute<Prestamo, Date> fechaDevolucion;
    public static volatile SingularAttribute<Prestamo, Date> fechaPrestamo;
    public static volatile SingularAttribute<Prestamo, Integer> id;

}