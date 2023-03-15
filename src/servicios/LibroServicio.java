package servicios;

import java.util.Collection;
import libreria_herencia.DAO.LibroDAO;
import libreria_herencia.entidades.Autor;
import libreria_herencia.entidades.Editorial;
import libreria_herencia.entidades.Libro;

public class LibroServicio {

    private LibroDAO DAO;

    public LibroServicio() {
        DAO = new LibroDAO();
    }

    /*Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para
    administrar autores (consulta, creación, modificación y eliminación).*/
    public void consulta() {

    }

    public void creacion(String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) throws Exception {
        try {
            //----------------------VALIDACIÓN --------------------------//
            if (titulo == null) {
                throw new Exception("Debe indicar NOMBRE DEL LIBRO");
            }
            //----------------------CREAR Y GUARDAR--------------------------//
            Libro libro = new Libro(null, titulo, anio, ejemplares, null, null, autor, editorial);
            DAO.crear(libro);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificacion(Long isbn, String titulo) throws Exception {
        try {
            //----------------------BUSCAR--------------------------//
            Libro libro = DAO.findIsbn(isbn);
            //----------------------MODIFICAR--------------------------//
            libro.setTitulo(titulo);
            //----------------------GUARDAR CAMBIOS--------------------------//
            DAO.editar(libro);
        } catch (Exception e) {
            throw e;
        }

    }
    public void modificacion2(Libro libro) throws Exception {
        try {
            //----------------------GUARDAR CAMBIOS--------------------------//
            DAO.editar(libro);
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminacion(Long isbn) throws Exception {
        try {
            //----------------------ELIMINAR--------------------------//
            DAO.borrar(isbn);
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirLibros() throws Exception {
        try {
            //----------------------LISTAR--------------------------//
            Collection<Libro> lista = DAO.listarLibros();
            //----------------------IMPRIMIR--------------------------//
            if (lista.isEmpty()) {
                throw new Exception("NO EXISTE LIBROS PARA IMPRIMIR");
            } else {
                for (Libro libro : lista) {
                    System.out.println(libro.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
}
