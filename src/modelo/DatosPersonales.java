package modelo;

public class DatosPersonales {
    private int id;
    private String nombres;
    private String apellido;
    private long dni;

    public DatosPersonales(String nombres, String apellido, long dni) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.dni = dni;
    }

    public DatosPersonales(int id, String nombres, String apellido, long dni) {
        this(nombres, apellido, dni);
        this.id = id;
    }

    // Getters y toString
    public int getId() { return id; }
    public String getNombres() { return nombres; }
    public String getApellido() { return apellido; }
    public long getDni() { return dni; }

    @Override
    public String toString() {
        return id + " - " + nombres + " " + apellido + " (DNI: " + dni + ")";
    }
}
