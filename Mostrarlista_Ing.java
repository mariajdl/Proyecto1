import java.util.LinkedList;

public class Mostrarlista_Ing {

    public void mostrar(LinkedList<ComputadorPortatil> Listapc) {
        System.out.println("----INVENTARIO COMPUTADORES---\n");
        
        if (Listapc == null || Listapc.isEmpty()) {
            System.out.println("La lista de computadores está vacía ");
            return;
        }

        for (ComputadorPortatil cp : Listapc) {
            System.out.println("La marca del computador es: " + cp.getMarca());
            System.out.println("El tamaño del computador es: " + cp.getTamaño());
            System.out.println("El precio es: " + cp.getPrecio());
            System.out.println("El sistema del computador es: " + cp.getSistema());
            System.out.println("El procesador es: " + cp.getProcesador());
            System.out.println("El computador se encuentra: " + cp.getDisponible());
            System.out.println("----------------------------------------------------");

        }
    }
}