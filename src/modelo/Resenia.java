package modelo;

public class Resenia {
    private int id;
    private int calificacion;
    private String comentario;
    private String fechaHora;
    private int idUsuario;
    private int idPelicula;
    private boolean aprobado;

    public Resenia(int id, int calificacion, String comentario, String fechaHora, int idUsuario, int idPelicula, boolean aprobado) {
        this.id = id;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaHora = fechaHora;
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
        this.aprobado = aprobado;
    }

    // ----- Getters & Setters -----
    
    public int getId() { return id; }
    public int getCalificacion() { return calificacion; }
    public String getComentario() { return comentario; }
    public String getFechaHora() { return fechaHora; }
    public int getIdUsuario() { return idUsuario; }
    public int getIdPelicula() { return idPelicula; }

    @Override
    public String toString() {
        return "ID " + id + " | Calificación: " + calificacion + " | Comentario: " + comentario + 
               " | Fecha: " + fechaHora + " | Aprobado: " + (aprobado ? "Sí" : "No");
    }
}
