package servicios;

import java.util.Collection;
import libreria_herencia.DAO.EditorialDAO;
import libreria_herencia.entidades.Editorial;

public class EditorialServicio {

    private EditorialDAO DAO;

    public EditorialServicio() {
        DAO = new EditorialDAO();
    }

    /*Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para
    administrar autores (consulta, creación, modificación y eliminación).*/
    public void consulta() {

    }

    public void creacion(String nombre) throws Exception {
        try {
            //----------------------VALIDACIÓN --------------------------//
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar NOMBRE DEL EDITORIAL");
            }
            //----------------------CREAR Y GUARDAR--------------------------//
            Editorial editorial = new Editorial(null, nombre);
            DAO.crear(editorial);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificacion(Integer id, String nombre) throws Exception {
        try {
            //----------------------VALIDACIÓN --------------------------//
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar NOMBRE DEL EDITORIAL");
            }
            //----------------------BUSCAR--------------------------//
            Editorial editorial = DAO.findId(id);
            //----------------------MODIFICAR--------------------------//
            editorial.setNombre(nombre);
            //----------------------GUARDAR CAMBIOS--------------------------//
            DAO.editar(editorial);
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

    public void imprimirEditoriales() throws Exception {
        try {
            //----------------------LISTAR--------------------------//
            Collection<Editorial> lista = DAO.listarEditorialles();
            //----------------------IMPRIMIR--------------------------//
            if (lista.isEmpty()) {
                throw new Exception("NO EXISTE EDITORIALES PARA IMPRIMIR");
            } else {
                for (Editorial editorial : lista) {
                    System.out.println(editorial.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
}
