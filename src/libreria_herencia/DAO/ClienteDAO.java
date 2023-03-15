package libreria_herencia.DAO;

import java.util.Collection;
import libreria_herencia.entidades.Cliente;

public final class ClienteDAO extends DAO {

    public ClienteDAO() {
        super();
    }

    public void crear(Cliente cliente) {
        super.create(cliente);
    }

    public void editar(Cliente cliente) {
        super.update(cliente);
    }

    public void borrar(Integer id) throws Exception {
        try {
            Cliente cliente = findId(id);
            super.delete(cliente);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Cliente> listarClientes() {
        super.conect();
        Collection<Cliente> clientes = em.createNamedQuery("Cliente.findAll").getResultList();
        super.disconect();
        return clientes;
    }

    public Cliente findId(Integer id) throws Exception {
        try {
            super.conect();
            Cliente cliente = em.createNamedQuery("Cliente.findById", Cliente.class)
                    .setParameter("id", id).getSingleResult();
            super.disconect();
            return cliente;
        } catch (Exception e) {
            throw new Exception("NO EXISTE ESE CLIENTE CON ESE ID");
        }
    }
}
