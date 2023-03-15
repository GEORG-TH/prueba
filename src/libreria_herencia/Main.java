package libreria_herencia;





public class Main {

    public static void main(String[] args) throws Exception {
        try {
           Menu m = new Menu();
           m.baseDeDatos();
           m.ejecucion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
