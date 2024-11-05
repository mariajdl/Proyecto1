
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    static LinkedList<Estudiantes_Ingenieria> estIng = new LinkedList<>();
    static LinkedList<Estudiantes_Diseño> estuDis = new LinkedList<>();
    static LinkedList<ComputadorPortatil> PC = new LinkedList<>();
    static LinkedList<TabletaGrafica> tableta = new LinkedList<>();
    static MenuIngenieria a = new MenuIngenieria();
    static MenuDiseño b = new MenuDiseño();

    public static void main(String[] args) {

        System.out.println("Sistema de Gestion de prestamo equipos electronicos San Juan de Dios");
        Menu llenar = new Menu();
        llenar.LLenarListas();
        
        Mostrarlista_Ing list = new Mostrarlista_Ing();
        MostrarLista_Diseño listD = new MostrarLista_Diseño();

        System.out.println("Datos importados correctamente.\n");
        int opcion;
        try (Scanner sc = new Scanner(System.in)) {
            do {

                String menuP = "\n--- Menu Principal ---\n"

                        + "1. Estudiantes de Ingeniería\n"
                        + "2. Estudiantes de Diseño\n"
                        + "3. Imprimir Inventario Total\n"
                        + "4. Salir del Programa\n"

                        + "Seleccione una opción : ";
                System.out.print(menuP);
                try {

                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            a.MenuIng(estIng, PC);

                            break;
                        case 2:
                            b.menuDiseño(estuDis, tableta);
                            break;
                        case 3:
                            System.out.println("\nImprimiendo inventario...");
                            list.mostrar(PC);
                            System.out.println("\n");
                            listD.Mostrar(tableta);

                            break;
                        case 4:
                            System.out.println("Gracias por usar el sistema, Hasta pronto");
                            break;
                        default:
                            System.out.println("Opcion invalida, Intente de nuevo");
                            break;

                    }
                } catch (Exception e) {
                    System.out.println("\nError: Por favor, ingrese un número válido.");
                    sc.nextLine();
                    opcion = 0;
                }

            } while (opcion != 4);
        }
    }

    public void LLenarListas() {

        estIng = a.Importar_Ingenieria();
        PC = a.importarComputadores();
        estuDis = b.Importar_Diseño();
        tableta = b.importartabletas();
    }

}
