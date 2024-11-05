import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Importar_Ingenieria {
    public LinkedList<Estudiantes_Ingenieria> importarIngenieria() {
        LinkedList<Estudiantes_Ingenieria> listaIng = new LinkedList<>();
        String rutaArchivoIng = "PrestamosIngenieria.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoIng))) {
            String linea;
            Estudiantes_Ingenieria ing = null;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Cedula: ")) {
                    if (ing != null) {
                        listaIng.add(ing);
                    }
                    ing = new Estudiantes_Ingenieria();
                    ing.setCedula(linea.substring(8).trim());
                } else if (linea.startsWith("Nombre: ")) {
                    if (ing != null) {
                        ing.setNombre(linea.substring(8).trim());
                    }
                } else if (linea.startsWith("Apellido:")) {
                    if (ing != null) {
                        ing.setApellido(linea.substring(10).trim());
                    }
                } else if (linea.startsWith("Telefono: ")) {
                    if (ing != null) {
                        ing.setTelefono(linea.substring(10).trim());
                    }
                } else if (linea.startsWith("Semestre: ")) {
                    if (ing != null) {
                        ing.setSemestre(Integer.parseInt(linea.substring(10).trim()));
                    }
                } else if (linea.startsWith("Promedio: ")) {
                    if (ing != null) {
                        ing.setPromedio(Float.parseFloat(linea.substring(10).trim()));
                    }
                } else if (linea.startsWith("Serial: ")) {
                    if (ing != null) {
                        ing.setSerial(linea.substring(8).trim());
                    }
                }
            }
            if (ing != null) {
                listaIng.add(ing);
            }
         

        } catch (Exception e) {
            e.getMessage();

        }
        return listaIng;
    }

    public LinkedList<ComputadorPortatil> importarComputadores() {
        LinkedList<ComputadorPortatil> listaPC = new LinkedList<>();
        String rutaArchivoIng = "InventarioPC.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoIng))) {
            String linea;
            ComputadorPortatil PC = null;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Serial: ")) {
                    if (PC != null) {
                        listaPC.add(PC);
                    }
                    PC = new ComputadorPortatil();
                    PC.setSerial(linea.substring(8).trim());
                } else if (linea.startsWith("Marca: ")) {
                    if (PC != null) {
                        PC.setMarca(linea.substring(7).trim());
                    }
                } else if (linea.startsWith("Tamaño: ")) {
                    if (PC != null) {
                        PC.setTamaño(Float.parseFloat(linea.substring(8).trim()));
                    }
                } else if (linea.startsWith("Precio: ")) {
                    if (PC != null) {
                        PC.setPrecio(Float.parseFloat(linea.substring(7).trim()));
                    }
                } else if (linea.startsWith("Sistema: ")) {
                    if (PC != null) {
                        PC.setSistema(linea.substring(9).trim());
                    }
                } else if (linea.startsWith("Procesador: ")) {
                    if (PC != null) {
                        PC.setProcesador(linea.substring(12).trim());
                    }
                } else if (linea.startsWith("Disponibilidad: ")) {
                    if (PC != null) {
                        PC.setDisponible(linea.substring(15).trim());;
                    }
                }
            }
            if (PC != null) {
                listaPC.add(PC);
            }
            

        } catch (Exception e) {
            e.getMessage();
        }
        return listaPC;
    }

    
    
}