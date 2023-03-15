package libreria_herencia.DAO;

import java.util.Collection;
import libreria_herencia.entidades.Autor;

public final class AutorDAO extends DAO<Autor> {

    public AutorDAO() {
        super();
    }

    public void crear(Autor autor) {
        super.create(autor);
    }

    public void editar(Autor autor) {
        super.update(autor);
    }

    public void borrar(Integer id) throws Exception {
        try {
            Autor autor = findId(id);
            super.delete(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Autor> listarAutores() {
        super.conect();
        Collection<Autor> autores = em.createNamedQuery("Autor.findAll").getResultList();
        super.disconect();
        return autores;
    }

    public Autor findId(Integer id) throws Exception {
        try {
            super.conect();
            Autor autor = em.createNamedQuery("Autor.findById", Autor.class)
                    .setParameter("id", id).getSingleResult();
            super.disconect();
            return autor;
        } catch (Exception e) {
            throw new Exception("NO EXISTE ESE AUTOR CON ESE ID");
        }
    }

}
