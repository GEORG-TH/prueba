package servicios;

import java.util.Collection;
import java.util.Date;
import libreria_herencia.DAO.PrestamoDAO;
import libreria_herencia.entidades.Cliente;
import libreria_herencia.entidades.Libro;
import libreria_herencia.entidades.Prestamo;

public class PrestamoServicio {

    private PrestamoDAO DAO;

    public PrestamoServicio() {
        DAO = new PrestamoDAO();
    }

    /*Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para
    administrar autores (consulta, creación, modificación y eliminación).*/
    public void consulta() {

    }

    public void creacion(Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente cliente) throws Exception {
        try {
            //----------------------CREAR Y GUARDAR--------------------------//
            Prestamo prestamo = new Prestamo(null, fechaPrestamo, fechaDevolucion, libro, cliente);
            DAO.crear(prestamo);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificacion(Integer id, Date fechaDevolucion) throws Exception {
        try {
            //----------------------BUSCAR--------------------------//
            Prestamo prestamo = DAO.findId(id);
            //----------------------MODIFICAR--------------------------//
            prestamo.setFechaDevolucion(fechaDevolucion);
            //----------------------GUARDAR CAMBIOS--------------------------//
            DAO.editar(prestamo);
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

    public void imprimirPrestamos() throws Exception {
        try {
            //----------------------LISTAR--------------------------//
            Collection<Prestamo> lista = DAO.listarPrestamos();
            //----------------------IMPRIMIR--------------------------//
            if (lista.isEmpty()) {
                throw new Exception("NO EXISTE PRESTAMOS PARA IMPRIMIR");
            } else {
                for (Prestamo prestamo : lista) {
                    System.out.println(prestamo.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
    public void imprimirPrestamosdeClientes(Integer id) throws Exception {
        try {
            //----------------------LISTAR--------------------------//
            Collection<Prestamo> lista = DAO.prestamoDeClientes(id);
            //----------------------IMPRIMIR--------------------------//
            if (lista.isEmpty()) {
                throw new Exception("NO EXISTE PRESTAMOS DE ESE CLIENTE");
            } else {
                for (Prestamo prestamo : lista) {
                    System.out.println(prestamo.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
}
