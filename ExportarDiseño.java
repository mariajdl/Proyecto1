import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExportarDiseño {

    public void exportarDiseño(LinkedList<Estudiantes_Diseño> listaEstudiantes, LinkedList<TabletaGrafica> listaTabletas) {
        if (listaEstudiantes.isEmpty() && listaTabletas.isEmpty()) {
            System.out.println("Las listas están vacías; no se puede exportar.");
            return;
        }

        try (FileWriter escritor = new FileWriter("EstudiantesDiseño.txt")) {
            if (!listaEstudiantes.isEmpty()) {
                escritor.write("=== Estudiantes de Diseño ===\n");
                for (Estudiantes_Diseño estudiante : listaEstudiantes) {
                    escritor.write("Cedula: " + estudiante.getCedula() + "\n");
                    escritor.write("Nombre: " + estudiante.getNombre() + "\n");
                    escritor.write("Apellido: " + estudiante.getApellido() + "\n");
                    escritor.write("Telefono: " + estudiante.getTelefono() + "\n");
                    escritor.write("Modalidad: " + estudiante.getModalidad() + "\n");
                    escritor.write("Asignatura: " + estudiante.getAsignaturas() + "\n");
                    escritor.write("Serial: " + estudiante.getSerial() + "\n");
                    escritor.write("--------------------------------------------------------------------------------------\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }

        try (FileWriter escritor = new FileWriter("InventarioTableta.txt")) {
            if (!listaTabletas.isEmpty()) {
                escritor.write("=== Inventario de Tabletas ===\n");
                for (TabletaGrafica tableta : listaTabletas) {
                    escritor.write("Serial: " + tableta.getSerial() + "\n");
                    escritor.write("Marca: " + tableta.getMarca() + "\n");
                    escritor.write("Tamaño: " + tableta.getTamaño() + "\n");
                    escritor.write("Precio: " + tableta.getPrecio() + "\n");
                    escritor.write("Almacenamiento: " + tableta.getAlmanenamiento() + "\n");
                    escritor.write("Peso: " + tableta.getPeso() + "\n");
                    escritor.write("Disponibilidad: " + tableta.getDisponibilidad() + "\n");
                    escritor.write("--------------------------------------------------------------------------------------\n");
                }
            }

            System.out.println("Archivo 'ExportacionCompleta.txt' exportado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }
    }
}

