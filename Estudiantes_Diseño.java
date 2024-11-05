public class Estudiantes_Diseño {
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String modalidad;
    private int asignaturas;
    private int serial;


    public Estudiantes_Diseño(String cedula, String nombre, String apellido, String telefono, String modalidad,
            int asignaturas, int serial) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.modalidad = modalidad;
        this.asignaturas = asignaturas;
        this.serial = serial;
        
    }

    public Estudiantes_Diseño() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(int asignaturas) {
        this.asignaturas = asignaturas;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String toString() {
        return "\nEstudiante de Diseño:" +  "\nCédula: "  + cedula + "\n Nombre: " + nombre + "\nApellido: " 
        + apellido + "\nTeléfono: " + telefono + "\nModalida: " + modalidad + "\nAsignaturas: " +asignaturas ;
    }

   
}
