public class TabletaGrafica {
    private int serial;
    private String marca;
    private float tamaño;
    private float precio;
    private String almanenamiento;
    private float peso;
    private String disponibilidad;

    public TabletaGrafica(int serial, String marca, float tamaño, float precio, String almanenamiento, float peso,
            String disponibilidad) {
        this.serial = serial;
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
        this.almanenamiento = almanenamiento;
        this.peso = peso;
        this.disponibilidad = disponibilidad;
    }

    public TabletaGrafica() {
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getTamaño() {
        return tamaño;
    }

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getAlmanenamiento() {
        return almanenamiento;
    }

    public void setAlmanenamiento(String almanenamiento) {
        this.almanenamiento = almanenamiento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
}
