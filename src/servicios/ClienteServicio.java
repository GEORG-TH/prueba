package servicios;

import java.util.Collection;
import libreria_herencia.DAO.ClienteDAO;
import libreria_herencia.entidades.Cliente;

public class ClienteServicio {
    
    private ClienteDAO DAO;
    public ClienteServicio() {
        DAO = new ClienteDAO();
    }
    
    
    /*Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para
    administrar autores (consulta, creación, modificación y eliminación).*/
    public void consulta() {

    }

    public void creacion(Long documento , String nombre , String apellido , String telefono) throws Exception {
        try {
            //----------------------VALIDACIÓN --------------------------//
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar NOMBRE DEL CLIENTE");
            }
            if (apellido == null || apellido.trim().isEmpty()) {
                throw new Exception("Debe indicar APELLIDO DEL CLIENTE");
            }
            if (telefono == null || telefono.trim().isEmpty()) {
                throw new Exception("Debe indicar TELEFONO DEL CLIENTE");
            }
            //----------------------CREAR Y GUARDAR--------------------------//
            Cliente cliente = new Cliente(null, documento, nombre, apellido, telefono);
            DAO.crear(cliente);
        } catch (Exception e) {
           throw e;
        }
    }

    public void modificacion(Integer id, Long doucmento) throws Exception {
        try {
            //----------------------BUSCAR--------------------------//
            Cliente cliente = DAO.findId(id);
            //----------------------MODIFICAR--------------------------//
            cliente.setDocumento(doucmento);
            //----------------------GUARDAR CAMBIOS--------------------------//
            DAO.editar(cliente);
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminacion(Integer id) throws Exception {
        try {           
            //----------------------ELIMINAR--------------------------//
            DAO.borrar(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirClientes() throws Exception {
        try {
            //----------------------LISTAR--------------------------//
            Collection<Cliente> lista = DAO.listarClientes();
            //----------------------IMPRIMIR--------------------------//
            if (lista.isEmpty()) {
                throw new Exception("NO EXISTE CLIENTES PARA IMPRIMIR");
            } else {
                for (Cliente cliente : lista) {
                    System.out.println(cliente.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
}
