import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class MenuDiseño {
    LinkedList<TabletaGrafica> listaTBs = new LinkedList<>();
    LinkedList<Estudiantes_Diseño> listaEstudiantes_Diseños = new LinkedList<>();
    Estudiantes_Diseño estuDis = new Estudiantes_Diseño();
    TabletaGrafica tablet = new TabletaGrafica();

    String marca;
    float tamaño;
    float precio;
    int almanenamiento;
    float peso;
    String cedula;
    String nombre;
    String apellido;
    String telefono;
    String modalidad;
    int asignaturas;
    int serial;
    Scanner sc = new Scanner(System.in);

    public void menuDiseño(LinkedList<Estudiantes_Diseño> listaEstudiantes_Diseños,
            LinkedList<TabletaGrafica> listaTBs) {

        int opcion;
        do {
            System.out.println("\nBienvenido al Menú de Diseño");
            String menuD = "\n--- SUB-MENÚ ---\n"
                    + "1. Registrar préstamo de equipo\n"
                    + "2. Modificar préstamo de equipo (Por serial o cédula)\n"
                    + "3. Devolución de equipo (se elimina el registro)\n"
                    + "4. Buscar equipo (Por serial o cédula)\n"
                    + "5. Volver al menú principal\n"
                    + "Ingrese la opción deseada: ";

            System.out.print(menuD);

            try {

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Registrando préstamo...");
                        listaEstudiantes_Diseños = registrodiseño(listaEstudiantes_Diseños);
                        listaTBs = Registrotable(listaTBs);
                        ExportarDiseño(listaEstudiantes_Diseños, listaTBs);

                        break;
                    case 2:
                        System.out.println("Modificando préstamo...");
                        ModificarDis(menuD, listaEstudiantes_Diseños);
                        ExportarDiseño(listaEstudiantes_Diseños, listaTBs);
                        break;
                    case 3:
                        System.out.println("Procesando devolución...");
                        DevoluciónDis(listaEstudiantes_Diseños, listaTBs);
                        ExportarDiseño(listaEstudiantes_Diseños, listaTBs);

                        break;
                    case 4:
                        System.out.println("Buscando equipo...");
                        BuscarDis(listaEstudiantes_Diseños, menuD);

                        break;
                    case 5:
                        System.out.println("Volviendo al menú...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nError: Por favor, ingrese un número válido.");
                sc.nextLine();
                opcion = 0;
            }
        } while (opcion != 5);

    }

    public void ExportarDiseño(LinkedList<Estudiantes_Diseño> listas,
            LinkedList<TabletaGrafica> ListaTBs) {
        ExportarDiseño I = new ExportarDiseño();
        I.exportarDiseño(listas, ListaTBs);
    }

    public LinkedList<Estudiantes_Diseño> Importar_Diseño() {
        Importar_Diseño o = new Importar_Diseño();
        LinkedList<Estudiantes_Diseño> lista_Diseño = o.importar_Diseño();
        return lista_Diseño;
    }

    public LinkedList<TabletaGrafica> importartabletas() {
        Importar_Diseño p = new Importar_Diseño();
        LinkedList<TabletaGrafica> listaGraficas = p.Importar_Tabletas();
        return listaGraficas;
    }

    public LinkedList<Estudiantes_Diseño> registrodiseño(LinkedList<Estudiantes_Diseño> lista_Diseño) {
        System.out.println("\n------REGISTRAR PRÉSTAMO DE EQUIPO------");
        Estudiantes_Diseño estuDis = new Estudiantes_Diseño();
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

                for (Estudiantes_Diseño estudiantes_Diseño : lista_Diseño) {
                    if (estudiantes_Diseño.getCedula().equals(cedula)) {
                        System.out.println("Este estudiante ya tiene registro de préstamo de equipo.");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    estuDis.setCedula(cedula);
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
                    estuDis.setNombre(nombre);

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
                    estuDis.setApellido(apellido);
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
                    estuDis.setTelefono(telefono);
                }
            } catch (Exception e) {
                System.out.println("Teléfono inválido");
            }

        } while (!telefono.matches("\\d{7,10}"));

        int option = 0;
        do {
            try {
                String menu2 = "\n-- Modalidad de estudio --\n"
                        + "1. Presencial\n"
                        + "2. Virtual\n"
                        + "Seleccione una opción";

                System.out.println(menu2);
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        estuDis.setModalidad("Presencial");
                        break;

                    case 2:
                        estuDis.setModalidad("Virtual");
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

        do {

            try {
                System.out.println("Ingrese la cantidad de asignaturas que esta viendo: ");
                asignaturas = sc.nextInt();
                if (asignaturas < 0 || asignaturas > 12) {
                    System.out.println(" inválido, ingrese un valor entre 1 y 12.");
                } else {
                    estuDis.setAsignaturas(asignaturas);
                    break;
                }
            } catch (Exception e) {
                System.out.println("ingrese un numero valido de asignaturas");
                sc.nextLine();
            }

        } while (true);

        do {
            try {
                System.out.println("Ingrese el serial: ");
                serial = sc.nextInt();

                encontrado = false;
                for (Estudiantes_Diseño estudiantes_Diseño : lista_Diseño) {
                    if (estudiantes_Diseño.getSerial() == serial) {
                        System.out.println("Este serial ya está registrado para otro equipo.");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    estuDis.setSerial(serial);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ingrese un número de serial válido.");
                sc.nextLine();
            }
        } while (true);

        lista_Diseño.add(estuDis);
        return lista_Diseño;

    }

    public LinkedList<TabletaGrafica> Registrotable(LinkedList<TabletaGrafica> listaGraficas) {
        TabletaGrafica tablet = new TabletaGrafica();
        tablet.setSerial(serial);
        do {
            try {
                System.out.println("Ingrese la marca de la tableta grafica: ");
                marca = sc.next();
                if (!marca.matches("^[a-zA-Z ]+$")) {

                } else {
                    tablet.setMarca(marca);

                }
            } catch (Exception e) {

            }

        } while (!marca.matches("^[a-zA-Z ]+$"));

        do {
            System.out.println("Ingrese el tamaño la tableta grafica: ");
            String tam = sc.next();
            tam = tam.replace(',', '.');

            try {
                tamaño = Float.parseFloat(tam);
                if (tamaño <= 0.0) {

                } else {
                    tablet.setTamaño(tamaño);
                    break;

                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        } while (true);

        do {
            System.out.println("Ingrese el precio de la tableta grafica: ");
            String tam = sc.next();
            tam = tam.replace(',', '.');
            try {

                precio = Float.parseFloat(tam);
                if (precio <= 0.0) {

                } else {
                    tablet.setPrecio(precio);
                    break;

                }
            } catch (Exception e) {
                System.out.println("ingrese el precio correcto de la tableta grafica ");
                sc.nextLine();
            }

        } while (true);

        int opcion = 0;
        do {

            try {
                String menu1 = "\n-- Almacenamiento --\n"
                        + "1. 256GB 7\n"
                        + "2. 512GB 10\n"
                        + "3. 1TB 11\n"
                        + "Seleccione una opción";
                System.out.println(menu1);
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        tablet.setAlmanenamiento("256GB");
                        break;

                    case 2:
                        tablet.setAlmanenamiento("512GB");
                        break;
                    case 3:
                        tablet.setAlmanenamiento("1TB");
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

        do {
            System.out.println("Ingrese el peso en kilogramos de la tableta grafica: ");
            String tam = sc.next();
            tam = tam.replace(',', '.');
            try {

                peso = Float.parseFloat(tam);
                if (precio <= 0.0) {

                } else {
                    tablet.setPeso(peso);
                    break;

                }
            } catch (Exception e) {
                System.out.println("ingrese el peso correcto de la tableta grafica ");
                sc.nextLine();
            }

        } while (true);

        tablet.setDisponibilidad("En prestamo");
        listaGraficas.add(tablet);
        return listaGraficas;
    }

    public Estudiantes_Diseño BuscarDis(LinkedList<Estudiantes_Diseño> lista_Diseño, String BuscarSerial) {

        if (lista_Diseño == null || lista_Diseño.isEmpty()) {
            System.out.println("La lista de estudiantes está vacía");
            return null;
        }
        System.out.println("Ingrese el número de serial o cédula a buscar: \n");
        String buscar = sc.next();
        Estudiantes_Diseño objresult = new Estudiantes_Diseño();

        int serialBuscar = -1;
        try {
            serialBuscar = Integer.parseInt(buscar);
        } catch (NumberFormatException e) {

        }

        boolean encontrado = false;
        for (Estudiantes_Diseño estudiantes_Diseño : lista_Diseño) {
            if ((serialBuscar != -1 && estudiantes_Diseño.getSerial() == serialBuscar) ||
                    estudiantes_Diseño.getCedula().equalsIgnoreCase(buscar)) {

                System.out.println("Equipo encontrado: " + estudiantes_Diseño.toString());
                System.out.println("-------------------------------------------------------");
                objresult.setCedula(estudiantes_Diseño.getCedula());
                objresult.setNombre(estudiantes_Diseño.getNombre());
                objresult.setApellido(estudiantes_Diseño.getApellido());
                objresult.setTelefono(estudiantes_Diseño.getTelefono());
                objresult.setModalidad(estudiantes_Diseño.getModalidad());
                objresult.setAsignaturas(estudiantes_Diseño.getAsignaturas());

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El equipo no se encontró");
        }
        return objresult;
    }

    public LinkedList<Estudiantes_Diseño> ModificarDis(String nombre, LinkedList<Estudiantes_Diseño> lista_Diseño) {

        Estudiantes_Diseño o = new Estudiantes_Diseño();
        o = this.BuscarDis(lista_Diseño, nombre);
        int opcion = 0;
        if (!o.getNombre().isEmpty()) {
            for (Estudiantes_Diseño estudiantes_Diseño : lista_Diseño) {
                if (estudiantes_Diseño.getNombre().equalsIgnoreCase(o.getNombre())) {
                    do {
                        String Menum = "1. Para modificar telefono\n"
                                + "2. Para modificar la modalidad de estudio\n"
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
                                            estudiantes_Diseño.setTelefono(telefono);
                                            System.out.println("Modificado exitosamente");
                                        }

                                    } while (!telefono.matches("\\d{7,10}"));
                                    break;

                                case 2:
                                    int option = 0;
                                    do {
                                        System.out.println("Ingrese la modalidad:");
                                        System.out.println("1. Virtual");
                                        System.out.println("2. Presencial");

                                        try {
                                            option = sc.nextInt();

                                            if (option == 1) {
                                                estudiantes_Diseño.setModalidad("Virtual");
                                                System.out.println("Modalidad cambiada a Virtual.");
                                            } else if (option == 2) {
                                                estudiantes_Diseño.setModalidad("Presencial");
                                                System.out.println("Modalidad cambiada a Presencial.");
                                            } else {
                                                System.out.println("Opción inválida, seleccione 1 o 2.");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("Por favor, ingrese una opción válida.");
                                            sc.nextLine();
                                        }
                                    } while (option != 1 && option != 2);
                                    break;

                                case 3:
                                    do {
                                        System.out.println("Ingrese el número de teléfono: ");
                                        telefono = sc.next();
                                        if (!telefono.matches("\\d{7,10}")) {
                                            System.out.println("Teléfono inválido, ingrese de 7 a 10 dígitos.");
                                        } else {
                                            estudiantes_Diseño.setTelefono(telefono);
                                            System.out.println("Modificado exitosamente");
                                        }

                                    } while (!telefono.matches("\\d{7,10}"));
                                    int op = 0;
                                    do {
                                        System.out.println("Ingrese la modalidad:");
                                        System.out.println("1. Virtual");
                                        System.out.println("2. Presencial");

                                        try {
                                            op = sc.nextInt();

                                            if (op == 1) {
                                                estudiantes_Diseño.setModalidad("Virtual");
                                                System.out.println("Modalidad cambiada a Virtual.");
                                            } else if (op == 2) {
                                                estudiantes_Diseño.setModalidad("Presencial");
                                                System.out.println("Modalidad cambiada a Presencial.");
                                            } else {
                                                System.out.println("Opción inválida, seleccione 1 o 2.");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("Por favor, ingrese una opción válida.");
                                            sc.nextLine();
                                        }
                                    } while (op != 1 && op != 2);

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
                    break;
                }
            }
        }
        return lista_Diseño;
    }

    public LinkedList<Estudiantes_Diseño> DevoluciónDis(LinkedList<Estudiantes_Diseño> lista_Diseño,
            LinkedList<TabletaGrafica> listaGraficas) {
        System.out.println("Ingrese el numero de cedula o serial del estudiante a devolver: ");
        String numeros = sc.next();
        boolean estan = false;

        int serialNumeros = -1;
        try {
            serialNumeros = Integer.parseInt(numeros);
        } catch (NumberFormatException e) {
        
        }

        for (Estudiantes_Diseño estudiantes_Diseño : lista_Diseño) {
            if ((serialNumeros != -1 && estudiantes_Diseño.getSerial() == serialNumeros) ||
                    estudiantes_Diseño.getCedula().equalsIgnoreCase(numeros)) {

                int serialtb = estudiantes_Diseño.getSerial();

                for (TabletaGrafica tb : listaGraficas) {
                    if (serialNumeros != -1 && tb.getSerial() == serialtb) {
                        tb.setDisponibilidad("Disponible");
                        break;
                    }
                }
            }
        }

       
        for (int i = lista_Diseño.size() - 1; i >= 0; i--) {
            Estudiantes_Diseño estudiantes_Diseño = lista_Diseño.get(i);
            if ((serialNumeros != -1 && estudiantes_Diseño.getSerial() == serialNumeros) ||
                    estudiantes_Diseño.getCedula().equalsIgnoreCase(numeros)) {
                lista_Diseño.remove(i);
                System.out.println("TABLETA REGRESADA EXITOSAMENTE\n");
                estan = true;
                break;
            }
        }

        if (!estan) {
            System.out.println("No se encontró estudiante con esa cédula o serial.");
        }

        return lista_Diseño;
    }
}
