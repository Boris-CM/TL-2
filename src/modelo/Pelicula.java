package modelo;

import util.Genero;

public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private String resumen;
    private double duracion;
    private Genero genero;

    public Pelicula(String titulo, String director, String resumen, double duracion, String genero) {
        this.titulo = titulo;
        this.director = director;
        this.resumen = resumen;
        this.duracion = duracion;
        this.genero = Genero.valueOf(genero.toUpperCase());
    }

    public Pelicula(int id, String titulo, String director, String resumen, double duracion, String genero) {
        this(titulo, director, resumen, duracion, genero);
        this.id = id;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public Genero getGenero() { return genero; }
    public String getDirector() { return director; }
    public String getResumen() { return resumen; }
    public double getDuracion() { return duracion; }

    @Override
    public String toString() {
        return id + " - " + titulo + " (" + genero + "), Dir: " + director + ", Duración: " + duracion + " min";
    }
}
