package libreria_herencia;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import libreria_herencia.DAO.AutorDAO;
import libreria_herencia.DAO.ClienteDAO;
import libreria_herencia.DAO.EditorialDAO;
import libreria_herencia.DAO.LibroDAO;
import libreria_herencia.DAO.PrestamoDAO;
import libreria_herencia.entidades.Autor;
import libreria_herencia.entidades.Cliente;
import libreria_herencia.entidades.Editorial;
import libreria_herencia.entidades.Libro;
import libreria_herencia.entidades.Prestamo;
import servicios.AutorServicio;
import servicios.ClienteServicio;
import servicios.EditorialServicio;
import servicios.LibroServicio;
import servicios.PrestamoServicio;

public class Menu {

    private AutorServicio as = new AutorServicio();
    private EditorialServicio es = new EditorialServicio();
    private ClienteServicio cs = new ClienteServicio();
    private LibroServicio ls = new LibroServicio();
    private PrestamoServicio ps = new PrestamoServicio();
    private AutorDAO aDAO = new AutorDAO();
    private EditorialDAO eDAO = new EditorialDAO();
    private ClienteDAO cDAO = new ClienteDAO();
    private LibroDAO lDAO = new LibroDAO();
    private PrestamoDAO pDAO = new PrestamoDAO();
    private Scanner cr = new Scanner(System.in).useDelimiter("\n");

    public Menu() {
    }

    public void ejecucion() throws InputMismatchException, Exception {
        try {
            System.out.println("--------------OPCIONES-----------------");
            System.out.println("1. AUTOR");
            System.out.println("2. EDITORIAL");
            System.out.println("3. LIBRO");
            System.out.println("4. CLIENTE");
            System.out.println("5. PRESTAMO");
            System.out.println("");
            System.out.print("Elegir opcion: ");
            int res, res2;
            boolean val;
            do {
                val = false;
                res = cr.nextInt();
                if (!(res == 1 || res == 2 || res == 3 || res == 4 || res == 5)) {
                    val = true;
                    System.out.println("NO EXISTE ESA OPCION. INTENTE DENUEVO");
                }
            } while (val);
            System.out.println("");
            switch (res) {
                case 1:
                    res2 = opcs("AUTOR");
                    switch (res2) {
                        case 1:
                            System.out.println("Ingresar nombre del autor");
                            as.creacion(cr.next());
                            break;
                        case 2:
                            System.out.println("Ingresar ID del autor y nombre a modificar");
                            as.modificacion(cr.nextInt(), cr.next());
                            break;
                        case 3:
                            System.out.println("Ingresar ID del autor");
                            as.eliminacion(cr.nextInt());
                            
                            break;
                        case 4:
                            as.imprimirAutores();
                            break;
                        case 5:
                            System.out.println("Ingresar ID del autor");
                            System.out.println(aDAO.findId(cr.nextInt()).toString());
                            break;
                    }
                    break;
                case 2:
                    res2 = opcs("EDITORIAL");
                    switch (res2) {
                        case 1:
                            System.out.println("Ingresar nombre del editorial");
                            es.creacion(cr.next());
                            break;
                        case 2:
                            System.out.println("Ingresar ID del editorial y nombre a modificar");
                            es.modificacion(cr.nextInt(), cr.next());
                            break;
                        case 3:
                            System.out.println("Ingresar ID del editorial");
                            es.eliminacion(cr.nextInt());
                            break;
                        case 4:
                            es.imprimirEditoriales();
                            break;
                        case 5:
                            System.out.println("Ingresar ID del editorial");
                            System.out.println(eDAO.findId(cr.nextInt()).toString());
                            break;
                    }
                    break;
                case 3:
                    res2 = opcs("LIBRO");
                    switch (res2) {
                        case 1:
                            System.out.println("Ingresar titulo del libro, año , n° de ejemplares");
                            String titulo = cr.next();
                            Integer anio = cr.nextInt(),
                             ejemplares = cr.nextInt();
                            System.out.println("-----------------");
                            System.out.println("AUTORES DISPONIBLES:  ");
                            as.imprimirAutores();
                            System.out.println("Indicar ID");
                            Integer ida = cr.nextInt();
                            Autor autor = aDAO.findId(ida);
                            System.out.println("-----------------");
                            System.out.println("EDITORIALES DISPONIBLES");
                            es.imprimirEditoriales();
                            System.out.println("Indicar ID");
                            Integer ide = cr.nextInt();
                            Editorial editorial = eDAO.findId(ide);
                            ls.creacion(titulo, anio, ejemplares, autor, editorial);
                            break;
                        case 2:
                            System.out.println("Ingresar ISBN del libro y titulo a modificar");
                            ls.modificacion(cr.nextLong(), cr.next());
                            break;
                        case 3:
                            System.out.println("Ingresar ISBN del libro");
                            ls.eliminacion(cr.nextLong());
                            break;
                        case 4:
                            ls.imprimirLibros();
                            break;
                        case 5:
                            System.out.println("Ingresar ISBN del libro");
                            System.out.println(lDAO.findIsbn(cr.nextLong()).toString());
                            break;
                    }
                    break;
                case 4:
                    res2 = opcs("CLIENTE");
                    switch (res2) {
                        case 1:
                            System.out.println("Ingresar n° de documento , nombre , apellido y n° de telefono: ");
                            cs.creacion(cr.nextLong(), cr.next(), cr.next(), cr.next());
                            break;
                        case 2:
                            System.out.println("Ingresar ID del cliente y n° de documento a modificar");
                            cs.modificacion(cr.nextInt(), cr.nextLong());
                            break;
                        case 3:
                            System.out.println("Ingresar ID del cliente");
                            cs.eliminacion(cr.nextInt());
                            break;
                        case 4:
                            cs.imprimirClientes();
                            break;
                        case 5:
                            System.out.println("Ingresar ID del cliente");
                            System.out.println(cDAO.findId(cr.nextInt()).toString());
                            break;
                        case 6:
                            System.out.println("Ingresar ID del cliente");
                            ps.imprimirPrestamosdeClientes(cDAO.findId(cr.nextInt()).getId());
                    }
                    break;
                case 5:
                    res2 = opcs("PRESTAMO");
                    switch (res2) {
                        case 1:
                            System.out.println("Ingresar fecha de prestamo (dd/mm/aa)");
                            int dia = cr.nextInt(),
                             mes = (cr.nextInt() - 1),
                             anio = (cr.nextInt() - 1900);
                            System.out.println("Ingresar fecha de devolución (dd/mm/aa)");
                            int dia1 = cr.nextInt(),
                             mes1 = (cr.nextInt() - 1),
                             anio1 = (cr.nextInt() - 1900);
                            Date d1 = new Date(anio, mes, dia);
                            Date d2 = new Date(anio1, mes1, dia1);
                            if (d1.after(d2)) {
                                throw new Exception("FECHAS INGRESADAS INCORRECTAS");
                            }
                            System.out.println("-----------------");
                            System.out.println("LIBROS DISPONIBLES:  ");
                            ls.imprimirLibros();
                            System.out.println("Indicar ISBN");
                            Long isbnl = cr.nextLong();
                            Libro libro = validarLibro(lDAO.findIsbn(isbnl));
                            while (libro == null) {
                                System.out.println("DEBE INDICAR OTRO YA QUE SE HA AGOTADO");
                                System.out.println("Indicar ISBN");
                                isbnl = cr.nextLong();
                                libro = validarLibro(lDAO.findIsbn(isbnl));
                            }
                            ls.modificacion2(libro);
                            System.out.println("-----------------");
                            System.out.println("CLIENTES DISPONIBLES");
                            cs.imprimirClientes();
                            System.out.println("Indicar ID");
                            Integer idc = cr.nextInt();
                            Cliente cliente = cDAO.findId(idc);
                            ps.creacion(d1, d2, libro, cliente);
                            break;
                        case 2:
                            System.out.println("Ingresar ID del prestamo y fecha de devolución (dd/mm/aa) a modificar");
                            dia = cr.nextInt();
                            mes = (cr.nextInt() - 1);
                            anio = (cr.nextInt() - 1900);
                            ps.modificacion(cr.nextInt(), new Date(anio, mes, dia));
                            break;
                        case 3:
                            System.out.println("Ingresar ID del prestamo");
                            ps.eliminacion(cr.nextInt());
                            break;
                        case 4:
                            ps.imprimirPrestamos();
                            break;
                        case 5:
                            System.out.println("Ingresar ID del prestamo");
                            System.out.println(pDAO.findId(cr.nextInt()).toString());
                            break;
                        case 6:
                            System.out.println("-----------------");
                            System.out.println("PRESTAMOS DISPONIBLES:  ");
                            ps.imprimirPrestamos();
                            System.out.println("Ingresar ID del prestamo");
                            Integer id = cr.nextInt();
                            ls.modificacion2(devolucion(id));
                            ps.eliminacion(id);
                            break;
                    }
                    break;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Debe ingresar un valor númerico");
        } catch (Exception e) {
            throw e;
        }
    }

    private Libro validarLibro(Libro libro) {

        if (libro.getEjemplaresRestantes() > 0) {
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
            return libro;
        } else {
            return null;
        }
    }

    private Libro devolucion(Integer id) throws Exception {
        try {
            Prestamo prestamo = pDAO.findId(id);
            prestamo.getLibro().setEjemplaresPrestados(prestamo.getLibro().getEjemplaresPrestados() - 1);
            prestamo.getLibro().setEjemplaresRestantes(prestamo.getLibro().getEjemplaresRestantes() + 1);
            return prestamo.getLibro();
        } catch (Exception e) {
            throw e;
        }

    }

    private int opcs(String op) throws Exception {
        try {
            boolean val, val2 = true;
            System.out.println("");
            System.out.println("--------------OPCIONES DE " + op + "-----------------");
            System.out.println("1. CREAR");
            System.out.println("2. MODIFICAR");
            System.out.println("3. ELIMINAR");
            System.out.println("4. IMPRIMIR LISTA");
            if (op.equalsIgnoreCase("libro")) {
                System.out.println("5. BUSCAR POR ISBN");
            } else {
                System.out.println("5. BUSCAR POR ID");
            }
            if (op.equalsIgnoreCase("PRESTAMO")) {
                System.out.println("6. DEVOLUCION");
                val2 = false;
            } else if (op.equalsIgnoreCase("cliente")) {
                System.out.println("6. MOSTRAR PRESTAMOS DEL CLIENTE");
                val2 = false;
            }
            System.out.println("");
            System.out.print("Elegir opcion: ");
            int res;
            if (val2) {
                do {
                    val = false;
                    res = cr.nextInt();
                    if (!(res == 1 || res == 2 || res == 3 || res == 4 || res == 5)) {
                        val = true;
                        System.out.println("NO EXISTE ESA OPCION. INTENTE DENUEVO");
                    }
                } while (val);
                return res;
            } else {
                do {
                    val = false;
                    res = cr.nextInt();
                    if (!(res == 1 || res == 2 || res == 3 || res == 4 || res == 5 || res == 6)) {
                        val = true;
                        System.out.println("NO EXISTE ESA OPCION. INTENTE DENUEVO");
                    }
                } while (val);
                return res;
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void baseDeDatos() {

        try {

            //----------------------AUTORES--------------------------//
            as.creacion("MARIO VARGAS LLOSA");
            as.creacion("RICARDO PALMA");
            as.creacion("CESAR VALLEJO");
            as.creacion("MIGUEL DE CERVANTES");
            as.creacion("VICTOR HUGO");
            as.creacion("AGATHA CHISTIE");
            as.creacion("CHARLES DICKENS");
            as.creacion("FEDERICO GARCIA LORCA");
            as.creacion("GABRIEL GARCIA MARQUEZ");
            as.creacion("ERNEST HEMINGWAY");
            //----------------------EDITORIALES--------------------------//
            es.creacion("ACANTILADO");
            es.creacion("AGUILAR");
            es.creacion("AKAL");
            es.creacion("ALBA");
            es.creacion("ALFAGUARA");
            es.creacion("ALIANZA");
            es.creacion("ALMADÍA");
            es.creacion("ANAGRAMA");
            es.creacion("ARIEL");
            es.creacion("ATALANTA");
            //----------------------LIBROS-------------------------//
            ls.creacion("CIUDAD Y LOS PERROS", 1963, 100, aDAO.findId(1), eDAO.findId(1));
            ls.creacion("TRADICIONES PERUANAS", 1872, 90, aDAO.findId(2), eDAO.findId(2));
            ls.creacion("TRILCE", 1922, 200, aDAO.findId(3), eDAO.findId(3));
            ls.creacion("DON QUIJOTE DE LA MANCHA", 1605, 300, aDAO.findId(4), eDAO.findId(4));
            ls.creacion("LOS MISERABLES", 1862, 400, aDAO.findId(5), eDAO.findId(5));
            ls.creacion("MUERTE EN EL NILO", 1937, 50, aDAO.findId(6), eDAO.findId(6));
            ls.creacion("CUENTOS DE NAVIDAD", 1843, 40, aDAO.findId(7), eDAO.findId(7));
            ls.creacion("ROMANCERO GITANO", 1928, 150, aDAO.findId(8), eDAO.findId(8));
            ls.creacion("CIEN AÑOS DE SOLEDAD", 1967, 250, aDAO.findId(9), eDAO.findId(9));
            ls.creacion("EL VIEJO Y EL MAR", 1952, 350, aDAO.findId(10), eDAO.findId(10));
            //----------------------CLIENTES-------------------------//
            cs.creacion(63749734L, "JUAN", "PEREZ", "943243023");
            cs.creacion(34245234L, "LUIS", "GOMEZ", "953252355");
            cs.creacion(34274235L, "MANUEL", "RODRIGUEZ", "952352593");
            cs.creacion(39472000L, "CESAR", "REYES", "482740284");
            cs.creacion(91324034L, "MARCO", "GONZALES", "293048364");
            cs.creacion(63969305L, "JULIO", "GARCIA", "826410982");
            cs.creacion(12943239L, "JOSE", "MORIENTES", "193028534");
            cs.creacion(84928031L, "PEDRO", "LEIVA", "930283947");
            cs.creacion(93823753L, "DARIO", "SANCHEZ", "988438495");
            cs.creacion(82385452L, "MARCELO", "SOSA", "183854820");
            cs.creacion(32124142L, "BRIGITTE", "DE LA CRUZ", "912424533");
            //----------------------PRESTAMOS-------------------------//
            ps.creacion(new Date(2023 - 1900, 3 - 1, 10), new Date(2023 - 1900, 3 - 1, 11), lDAO.findIsbn(1L), cDAO.findId(1));
            ps.creacion(new Date(2023 - 1900, 3 - 1, 12), new Date(2023 - 1900, 3 - 1, 13), lDAO.findIsbn(2L), cDAO.findId(2));
            ps.creacion(new Date(2023 - 1900, 4 - 1, 1), new Date(2023 - 1900, 4 - 1, 2), lDAO.findIsbn(3L), cDAO.findId(3));
            ps.creacion(new Date(2023 - 1900, 4 - 1, 2), new Date(2023 - 1900, 4 - 1, 3), lDAO.findIsbn(4L), cDAO.findId(4));
            ps.creacion(new Date(2023 - 1900, 5 - 1, 20), new Date(2023 - 1900, 5 - 1, 21), lDAO.findIsbn(5L), cDAO.findId(5));
            ps.creacion(new Date(2023 - 1900, 5 - 1, 25), new Date(2023 - 1900, 5 - 1, 26), lDAO.findIsbn(6L), cDAO.findId(6));
            ps.creacion(new Date(2023 - 1900, 6 - 1, 13), new Date(2023 - 1900, 6 - 1, 14), lDAO.findIsbn(7L), cDAO.findId(7));
            ps.creacion(new Date(2023 - 1900, 8 - 1, 27), new Date(2023 - 1900, 8 - 1, 28), lDAO.findIsbn(8L), cDAO.findId(8));
            ps.creacion(new Date(2023 - 1900, 9 - 1, 29), new Date(2023 - 1900, 9 - 1, 30), lDAO.findIsbn(9L), cDAO.findId(9));
            ps.creacion(new Date(2023 - 1900, 11 - 1, 30), new Date(2023 - 1900, 12 - 1, 1), lDAO.findIsbn(10L), cDAO.findId(10));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
