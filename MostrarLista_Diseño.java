import java.util.LinkedList;

public class MostrarLista_Diseño {
    public void Mostrar(LinkedList<TabletaGrafica> listaTb) {
        System.out.println("----INVENTARIO TABLETAS----\n");

        if (listaTb == null || listaTb.isEmpty()) {
            System.out.println("La lista de tabletas está vacía ");
            return;
        }
        for (TabletaGrafica Tb : listaTb) {
            System.out.println("La marca es: " + Tb.getMarca());
            System.out.println("El tamaño es: " + Tb.getTamaño());
            System.out.println("El precio es: " + Tb.getPrecio());
            System.out.println("El almacenamiento es: " + Tb.getAlmanenamiento());
            System.out.println("El peso es: " + Tb.getPeso());
            System.out.println("La tableta se encuentra: " + Tb.getDisponibilidad());

            System.out.println("-------------------------------------------------------------------------------");

        }
    }

}
