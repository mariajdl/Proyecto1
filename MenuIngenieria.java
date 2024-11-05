import java.util.Scanner;
import java.util.LinkedList;

public class MenuIngenieria {
    LinkedList<ComputadorPortatil> listaPCs = new LinkedList<>();
    LinkedList<Estudiantes_Ingenieria> listaEstudiantes = new LinkedList<>();
    Estudiantes_Ingenieria estI = new Estudiantes_Ingenieria();
    ComputadorPortatil pc = new ComputadorPortatil();

    String cedula;
    String nombre;
    String apellido;
    String telefono;
    int semestre;
    float promedio;
    String serial;
    String marca;
    float tamaño;
    float precio;
    String sistema;
    String procesador;
    Scanner sc = new Scanner(System.in);

    public void MenuIng(LinkedList<Estudiantes_Ingenieria> listaEstudiantes, LinkedList<ComputadorPortatil> listaPCs) {
        int opcion;
        do {
            System.out.println("\nBienvenido al Menú de Ingenierías");
            String menuI = "\n--- SUB-MENÚ ---\n"
                    + "1. Registrar préstamo de equipo\n"
                    + "2. Modificar préstamo de equipo (Por serial o cédula)\n"
                    + "3. Devolución de equipo (se elimina el registro)\n"
                    + "4. Buscar equipo (Por serial o cédula)\n"
                    + "5. Volver al menú principal\n"
                    + "Ingrese la opción deseada: ";

            System.out.print(menuI);
            try {
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nRegistrando préstamo...");
                        listaEstudiantes = registro(listaEstudiantes);
                        listaPCs = RegistroPC(listaPCs);
                        ExportarArchivo(listaEstudiantes, listaPCs);

                        break;
                    case 2:
                        System.out.println("\nModificando préstamo...");
                        Modificar(menuI, listaEstudiantes);
                        ExportarArchivo(listaEstudiantes, listaPCs);
                        break;
                    case 3:
                        System.out.println("\nProcesando devolución...");
                        devolución(listaEstudiantes, listaPCs);
                        ExportarArchivo(listaEstudiantes, listaPCs);
                        break;
                    case 4:
                        System.out.println("\nBuscando equipo...");
                        Buscar(listaEstudiantes, menuI);
                        break;
                    case 5:
                        System.out.println("\nVolviendo al menu Principal...");

                        break;

                    default:
                        System.out.println("\nOpción no válida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nError: Por favor, ingrese un número válido.");
                sc.nextLine();
                opcion = 0;
            }

        } while (opcion != 5);

    }

    public static void ExportarArchivo(LinkedList<Estudiantes_Ingenieria> lista,
            LinkedList<ComputadorPortatil> Listapc) {
        ExportarArchivo I = new ExportarArchivo();
        I.exportarING(lista, Listapc);
    }

    public LinkedList<Estudiantes_Ingenieria> Importar_Ingenieria() {
        Importar_Ingenieria i = new Importar_Ingenieria();
        LinkedList<Estudiantes_Ingenieria> lista_ing = i.importarIngenieria();
        return lista_ing;
    }

    public LinkedList<ComputadorPortatil> importarComputadores() {
        Importar_Ingenieria j = new Importar_Ingenieria();
        LinkedList<ComputadorPortatil> lista_PC = j.importarComputadores();
        return lista_PC;
    }

    public LinkedList<Estudiantes_Ingenieria> registro(LinkedList<Estudiantes_Ingenieria> lista_ing) {
        Estudiantes_Ingenieria estI = new Estudiantes_Ingenieria();
        System.out.println("\n------REGISTRAR PRÉSTAMO DE EQUIPO------");

        boolean encontrado;

        do {
            encontrado = false;

            try {

                do {
                    System.out.println("Ingrese el número de cédula: ");
                    cedula = sc.next();

                    if (!cedula.matches("[a-zA-Z0-9]+")) {
                        System.out.println("Cédula inválida, vuelva a intentarlo.");
                    }
                } while (!cedula.matches("[a-zA-Z0-9]+"));

                for (Estudiantes_Ingenieria estudiantes_Ingenieria : lista_ing) {
                    if (estudiantes_Ingenieria.getCedula().equals(cedula)) {
                        System.out.println("Este estudiante ya tiene registro de préstamo de equipo.");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    estI.setCedula(cedula);
                    System.out.println("Cédula registrada exitosamente.");
                    break;
                }

            } catch (Exception e) {
                System.out.println("Ocurrió un error. Vuelva a intentarlo.");
                sc.next();
            }

        } while (encontrado);

        do {
            try {
                System.out.println("Ingrese el nombre: ");
                nombre = sc.next();
                if (!nombre.matches("^[a-zA-Z ]+$")) {
                    System.out.println("Nombre inválido, vuelva a intentarlo.");

                } else {
                    estI.setNombre(nombre);

                }
            } catch (Exception e) {
                System.out.println("Nombre inválido");
            }

        } while (!nombre.matches("^[a-zA-Z ]+$"));

        do {
            try {
                System.out.println("Ingrese el apellido: ");
                apellido = sc.next();
                if (!apellido.matches("^[a-zA-Z ]+$")) {
                    System.out.println("Apellido inválido, vuelva a intentarlo.");

                } else {
                    estI.setApellido(apellido);
                }
            } catch (Exception e) {
                System.out.println("Apellido inválido");
            }

        } while (!apellido.matches("^[a-zA-Z ]+$"));

        do {
            try {
                System.out.println("Ingrese el número de teléfono: ");
                telefono = sc.next();
                if (!telefono.matches("\\d{7,10}")) {
                    System.out.println("Teléfono inválido, ingrese de 7 a 10 dígitos.");
                } else {
                    estI.setTelefono(telefono);
                }
            } catch (Exception e) {
                System.out.println("Teléfono inválido");
            }

        } while (!telefono.matches("\\d{7,10}"));

        do {

            try {
                System.out.println("Ingrese el número de semestre: ");
                semestre = sc.nextInt();
                if (semestre < 1 || semestre > 12) {
                    System.out.println("Semestre inválido, ingrese un valor entre 1 y 12.");
                } else {
                    estI.setSemestre(semestre);
                    break;
                }
            } catch (Exception e) {
                System.out.println("ingrese un numero valido para el semestre");
                sc.nextLine();
            }

        } while (true);

        do {
            System.out.println("Ingrese el promedio: ");
            String prom = sc.next();
            prom = prom.replace(',', '.');

            try {
                promedio = Float.parseFloat(prom);

                if (promedio < 0.0 || promedio > 5.0) {
                    System.out.println("Promedio inválido, ingrese un valor entre 0.0 y 5.0.");
                } else {
                    estI.setPromedio(promedio);
                    break;

                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número decimal.");
            }
        } while (true);

        do {

            try {
                do {
                    System.out.println("Ingrese el número de serial: ");
                    serial = sc.next();

                    if (!serial.matches("[a-zA-Z0-9]+")) {
                        System.out.println("El número de serie debe ser alfanumérico.");
                    }
                } while (!serial.matches("[a-zA-Z0-9]+"));

                encontrado = false;
                for (Estudiantes_Ingenieria estudiantes_Ingenieria : lista_ing) {
                    if (estudiantes_Ingenieria.getSerial().equals(serial)) {
                        System.out.println("Este equipo ya está prestado.");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    estI.setSerial(serial);
                }

            } catch (Exception e) {
                System.out.println("Ocurrio un error");
            }
        } while (encontrado);

        lista_ing.add(estI);
        return lista_ing;

    }

    public LinkedList<ComputadorPortatil> RegistroPC(LinkedList<ComputadorPortatil> lista_PC) {
        ComputadorPortatil pc = new ComputadorPortatil();
        pc.setSerial(serial);
        do {

            try {
                System.out.println("Ingrese la marca del computador: ");
                marca = sc.next();
                if (!marca.matches("^[a-zA-Z ]+$")) {

                } else {
                    pc.setMarca(marca);

                }
            } catch (Exception e) {

            }
        } while (!marca.matches("^[a-zA-Z ]+$"));

        do {
            System.out.println("Ingrese el tamaño del computador: ");
            String tam = sc.next();
            tam = tam.replace(',', '.');

            try {
                tamaño = Float.parseFloat(tam);
                if (tamaño <= 0.0) {

                } else {
                    pc.setTamaño(tamaño);
                    break;

                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        } while (true);

        do {
            System.out.println("Ingrese el precio del computador: ");
            String tam = sc.next();
            tam = tam.replace(',', '.');
            try {

                precio = Float.parseFloat(tam);
                if (precio <= 0.0) {

                } else {
                    pc.setPrecio(precio);
                    break;

                }
            } catch (Exception e) {
                System.out.println("ingrese el precio correcto del computador ");
                sc.nextLine();
            }

        } while (true);

        int opcion = 0;
        do {

            try {
                String menu1 = "\n--  Sistema Operativo --\n"
                        + "1. Windows 7\n"
                        + "2. Windows 10\n"
                        + "3. Windows 11\n"
                        + "Seleccione una opción";
                System.out.println(menu1);
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        pc.setSistema("Windows 7");
                        break;

                    case 2:
                        pc.setSistema("Windows 10");
                        break;
                    case 3:
                        pc.setSistema("Windows 11");
                        break;

                    default:
                        System.out.println("opción invalida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("ingrese una opción valida");
                sc.nextLine();

            }

        } while (opcion < 1 || opcion > 3);

        int option = 0;
        do {
            try {
                String menu2 = "\n-- Procesador computador--\n"
                        + "1. AMD Ryzen\n"
                        + "2. Intel core i5\n"
                        + "Seleccione una opción";

                System.out.println(menu2);
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        pc.setProcesador("AMD Ryzen");
                        break;

                    case 2:
                        pc.setProcesador("Intel core i5");
                        break;

                    default:
                        System.out.println("opción invalida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                sc.nextLine();
            }

        } while (option < 1 || option > 2);
        pc.setDisponible("En prestamo");
        lista_PC.add(pc);
        return lista_PC;
    }

    public Estudiantes_Ingenieria Buscar(LinkedList<Estudiantes_Ingenieria> lista_ing, String BuscarSerial) {
        if (lista_ing == null || lista_ing.isEmpty()) {
            System.out.println("La lista de estudiantes está vacía ");
            return null;
        }

        System.out.println("Ingrese el número de serial o  cédula a buscar: \n");
        String buscar = sc.next();
        Estudiantes_Ingenieria objresult = new Estudiantes_Ingenieria();
        for (Estudiantes_Ingenieria estudiantes_Ingenieria : lista_ing) {
            if (estudiantes_Ingenieria.getSerial().equalsIgnoreCase(buscar) ||
                    estudiantes_Ingenieria.getCedula().equalsIgnoreCase(buscar)) {
                System.out.println("Equipo encontrado: " + estudiantes_Ingenieria.toString());
                System.out.println("-------------------------------------------------------");
                objresult.setCedula(estudiantes_Ingenieria.getCedula());
                objresult.setNombre(estudiantes_Ingenieria.getNombre());
                objresult.setApellido(estudiantes_Ingenieria.getApellido());
                objresult.setTelefono(estudiantes_Ingenieria.getTelefono());
                objresult.setSemestre(estudiantes_Ingenieria.getSemestre());
                objresult.setPromedio(estudiantes_Ingenieria.getPromedio());

                return objresult;

            }

        }
        System.out.println("No se encontro el equipo");
        return null;
    }

    public LinkedList<Estudiantes_Ingenieria> Modificar(String nombre, LinkedList<Estudiantes_Ingenieria> lista_ing) {
        Estudiantes_Ingenieria o = new Estudiantes_Ingenieria();
        o = this.Buscar(lista_ing, nombre);
        int opcion = 0;
        if (!o.getNombre().isEmpty()) {
            for (Estudiantes_Ingenieria p : lista_ing) {
                if (p.getNombre().equalsIgnoreCase(o.getNombre())) {
                    do {
                        String Menum = "1. Para modificar telefono\n"
                                + "2. Para modificar el semestre\n"
                                + "3. modificar los dos registros\n"
                                + "4 Salir\n"
                                + "Seleccione la opcion deseada ";
                        System.out.println(Menum);
                        try {
                            opcion = sc.nextInt();
                            sc.nextLine();

                            switch (opcion) {
                                case 1:
                                    do {
                                        System.out.println("Ingrese el número de teléfono:");
                                        telefono = sc.next();
                                        if (!telefono.matches("\\d{7,10}")) {
                                            System.out.println("Teléfono inválido, ingrese de 7 a 10 dígitos.");
                                        } else {
                                            p.setTelefono(telefono);
                                            System.out.println("Modificado exitosamente");
                                        }

                                    } while (!telefono.matches("\\d{7,10}"));
                                    break;

                                case 2:
                                    System.out.println("Ingrese el semestre:");
                                    semestre = sc.nextInt();
                                    if (semestre < 1 || semestre > 10) {
                                        System.out.println("Semestre invalido, vuelva a intentarlo.");
                                    } else {
                                        p.setSemestre(semestre);
                                        System.out.println("Modificado exitosamente");
                                    }

                                    break;

                                case 3:
                                    do {
                                        System.out.println("Ingrese el número de teléfono: ");
                                        telefono = sc.next();
                                        if (!telefono.matches("\\d{7,10}")) {
                                            System.out.println("Teléfono inválido, ingrese de 7 a 10 dígitos.");
                                        } else {
                                            p.setTelefono(telefono);
                                            System.out.println("Modificado exitosamente");
                                        }

                                    } while (!telefono.matches("\\d{7,10}"));

                                    System.out.println("Ingrese el semestre:");
                                    semestre = sc.nextInt();
                                    if (semestre < 1 || semestre > 10) {
                                        System.out.println("Semestre invalido, vuelva a intentarlo");
                                    } else {
                                        p.setSemestre(semestre);
                                        System.out.println("Modificado exitosamente");
                                    }
                                    break;
                                case 4:
                                    System.out.println("Saliendo del menu...");
                                    break;

                                default:
                                    System.out.println("opcion invalida");
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
        }
        return lista_ing;
    }

    public LinkedList<Estudiantes_Ingenieria> devolución(LinkedList<Estudiantes_Ingenieria> lista_ing,
            LinkedList<ComputadorPortatil> lista_PC) {
        System.out.println("Ingrese el numero de cedula o serial del estudiante a devolver: ");
        String numeros = sc.next();
        boolean estan = false;

        for (Estudiantes_Ingenieria estudiantes_Ingenieria : lista_ing) {
            if (estudiantes_Ingenieria.getCedula().equals(numeros)
                    || estudiantes_Ingenieria.getSerial().equals(numeros)) {

                String serialcp = estudiantes_Ingenieria.getSerial();

                for (ComputadorPortatil computadorPortatil : lista_PC) {
                    if (computadorPortatil.getSerial().equals(serialcp)) {
                        computadorPortatil.setDisponible("Disponible");
                        break;
                    }
                }
            }
        }

        for (int i = lista_ing.size() - 1; i >= 0; i--) {
            Estudiantes_Ingenieria estudiantes_Ingenieria = lista_ing.get(i);

            if (estudiantes_Ingenieria.getCedula().equals(numeros)
                    || estudiantes_Ingenieria.getSerial().equals(numeros)) {
                lista_ing.remove(i);
                System.out.println("COMPUTADOR REGRESADO EXITOSAMENTE\n");
                estan = true;
                break;
            }

        }

        if (!estan) {
            System.out.println("No se encontró estudiante con esa cédula o serial.");
        }

        return lista_ing;
    }
}