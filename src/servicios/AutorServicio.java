package servicios;

import java.util.Collection;
import libreria_herencia.DAO.AutorDAO;
import libreria_herencia.entidades.Autor;

public class AutorServicio {

    private AutorDAO DAO;

    public AutorServicio() {
        DAO = new AutorDAO();
    }

    /*Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para
    administrar autores (consulta, creación, modificación y eliminación).*/
    public void consulta() {

    }

    public void creacion(String nombre) throws Exception {
        try {
            //----------------------VALIDACIÓN --------------------------//
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar NOMBRE DEL AUTOR");
            }
            //----------------------CREAR Y GUARDAR--------------------------//
            Autor autor = new Autor(null, nombre);
            DAO.crear(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificacion(Integer id, String nombre) throws Exception {
        try {
            //----------------------VALIDACIÓN --------------------------//
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar NOMBRE DEL AUTOR");
            }
            //----------------------BUSCAR--------------------------//
            Autor autor = DAO.findId(id);
            //----------------------MODIFICAR--------------------------//
            autor.setNombre(nombre);
            //----------------------GUARDAR CAMBIOS--------------------------//
            DAO.editar(autor);
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

    public void imprimirAutores() throws Exception {
        try {
            //----------------------LISTAR--------------------------//
            Collection<Autor> lista = DAO.listarAutores();
            //----------------------IMPRIMIR--------------------------//
            if (lista.isEmpty()) {
                throw new Exception("NO EXISTE AUTORES PARA IMPRIMIR");
            } else {
                for (Autor autor : lista) {
                    System.out.println(autor.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
}
