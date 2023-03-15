package libreria_herencia.DAO;

import java.util.Collection;
import libreria_herencia.entidades.Editorial;

public final class EditorialDAO extends DAO {

    public EditorialDAO() {
        super();
    }

    public void crear(Editorial editorial) {
        super.create(editorial);
    }

    public void editar(Editorial editorial) {
        super.update(editorial);
    }

    public void borrar(Integer id) throws Exception {
        try {
            Editorial editorial = findId(id);
            super.delete(editorial);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Editorial> listarEditorialles() {
        super.conect();
        Collection<Editorial> editoriales = em.createNamedQuery("Editorial.findAll").getResultList();
        super.disconect();
        return editoriales;
    }

    public Editorial findId(Integer id) throws Exception {
        try {
            super.conect();
            Editorial editorial = em.createNamedQuery("Editorial.findById", Editorial.class)
                    .setParameter("id", id).getSingleResult();
            super.disconect();
            return editorial;
        } catch (Exception e) {
            throw new Exception("NO EXISTE ESE EDITORIAL CON ESE ID");
        }
    }

}
