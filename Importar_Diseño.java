import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Importar_Diseño {

    public LinkedList<Estudiantes_Diseño> importar_Diseño() {
        LinkedList<Estudiantes_Diseño> listaD = new LinkedList<>();
        String rutaArchivoDis = "EstudiantesDiseño.txt";
   

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoDis))) {
            String linea;
            Estudiantes_Diseño objD = null;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Cedula: ")) {
                    if (objD != null) {
                        listaD.add(objD);
                    }
                    objD = new Estudiantes_Diseño();
                    objD.setCedula(linea.substring(8).trim());

                } else if (linea.startsWith("Nombre: ")) {
                    if (objD != null) {
                        objD.setNombre(linea.substring(8).trim());
                    }

                } else if (linea.startsWith("Apellido: ")) {
                    if (objD != null) {
                        objD.setApellido(linea.substring(10).trim());
                    }

                } else if (linea.startsWith("Telefono: ")) {
                    if (objD != null) {
                        objD.setTelefono(linea.substring(10).trim());
                    }

                } else if (linea.startsWith("Modalidad: ")) {
                    if (objD != null) {
                        objD.setModalidad(linea.substring(11).trim());
                    }

                } else if (linea.startsWith("Asignatura: ")) {
                    if (objD != null) {
                        objD.setAsignaturas(Integer.parseInt(linea.substring(12).trim()));
                    }

                } else if (linea.startsWith("Serial: ")) {
                    if (objD != null) {
                        objD.setSerial(Integer.parseInt(linea.substring(8).trim()));
                    }
                }
            }
            if (objD != null) {
                listaD.add(objD);
            }
            

        } catch (Exception e) {
            e.getMessage();
        }
        return listaD;
    }

    public LinkedList<TabletaGrafica> Importar_Tabletas() {
        LinkedList<TabletaGrafica> ListaT = new LinkedList<>();
        String rutaArchivoDis = "InventarioTableta.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoDis))) {
            String linea;
            TabletaGrafica tab = null;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Serial: ")) {
                    if (tab != null) {
                        ListaT.add(tab);
                    }
                    tab = new TabletaGrafica();
                    tab.setSerial(Integer.parseInt(linea.substring(8).trim()));

                } else if (linea.startsWith("Marca: ")) {
                    if (tab != null) {
                        tab.setMarca(linea.substring(7).trim());
                    }

                } else if (linea.startsWith("Tamaño: ")) {
                    if (tab != null) {
                        tab.setTamaño(Float.parseFloat(linea.substring(7).trim()));
                    }

                } else if (linea.startsWith("Precio: ")) {
                    if (tab != null) {
                        tab.setPrecio(Float.parseFloat(linea.substring(7).trim()));
                    }

                } else if (linea.startsWith("Almacenamiento: ")) {
                    if (tab != null) {
                        tab.setAlmanenamiento(linea.substring(16).trim());
                    }

                } else if (linea.startsWith("Peso: ")) {
                    if (tab != null) {
                        tab.setPeso(Float.parseFloat(linea.substring(5).trim()));
                    }
                } else if (linea.startsWith("Disponibilidad: ")) {
                    if (tab != null) {
                        tab.setDisponibilidad(linea.substring(16).trim());
                    }
                }
               
            }
            if (tab != null) {
                ListaT.add(tab);
            }
           

        } catch (Exception e) {
            e.getMessage();
        }

        return ListaT;
    }
}
