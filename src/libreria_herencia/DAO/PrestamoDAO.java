package libreria_herencia.DAO;

import java.util.Collection;
import libreria_herencia.entidades.Prestamo;

public final class PrestamoDAO extends DAO {

    public PrestamoDAO() {
        super();
    }

    public void crear(Prestamo prestamo) {
        super.create(prestamo);
    }

    public void editar(Prestamo prestamo) {
        super.update(prestamo);
    }

    public void borrar(Integer id) throws Exception {
        try {
            Prestamo prestamo = findId(id);
            super.delete(prestamo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Prestamo> listarPrestamos() {
        super.conect();
        Collection<Prestamo> prestamos = em.createNamedQuery("Prestamo.findAll").getResultList();
        super.disconect();
        return prestamos;
    }
    public Collection<Prestamo> prestamoDeClientes(Integer id) {
        super.conect();
        Collection<Prestamo> prestamos = em.createNamedQuery("Prestamo.prestamoDeCliente", Prestamo.class)
                    .setParameter("id", id).getResultList();
        super.disconect();
        return prestamos;
    }

    public Prestamo findId(Integer id) throws Exception {
        try {
            super.conect();
            Prestamo prestamo = em.createNamedQuery("Prestamo.findById", Prestamo.class)
                    .setParameter("id", id).getSingleResult();
            super.disconect();
            return prestamo;
        } catch (Exception e) {
            throw new Exception("NO EXISTE ESE PRESTAMO CON ESE ID");
        }
    }
}
