package libreria_herencia.DAO;

import java.util.Collection;
import libreria_herencia.entidades.Libro;

public final class LibroDAO extends DAO {

    public LibroDAO() {
        super();
    }

    public void crear(Libro libro) {
        super.create(libro);
    }

    public void editar(Libro libro) {
        super.update(libro);
    }

    public void borrar(Long isbn) throws Exception {
        try {
            Libro libro = findIsbn(isbn);
            super.delete(libro);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Libro> listarLibros() {
        super.conect();
        Collection<Libro> libros = em.createNamedQuery("Libro.findAll").getResultList();
        super.disconect();
        return libros;
    }

    public Libro findIsbn(Long isbn) throws Exception {
        try {
            super.conect();
            Libro libro = em.createNamedQuery("Libro.findByIsbn", Libro.class)
                    .setParameter("isbn", isbn).getSingleResult();
            super.disconect();
            return libro;
        } catch (Exception e) {
            throw new Exception("NO EXISTE ESE LIBRO CON ESE ISBN");
        }
    }
}
