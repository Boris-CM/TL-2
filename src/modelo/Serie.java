package modelo;

import java.util.ArrayList;

import enumerativos.Genero;
import enumerativos.Pais;

public class Serie extends Contenido  {
	private int cantTemporadas;
	private ArrayList<Temporada> temporadas;
	
	/**
     * Constructor de la clase Serie.
     * 
     * @param titulo título de la serie
     * @param sinopsis breve descripción de la serie
     * @param elenco elenco principal de la serie
     * @param director director de la serie
     * @param vistas cantidad de visualizaciones registradas
     * @param genero género principal de la serie
     * @param resenias lista de reseñas realizadas por los usuarios
     * @param trailer trailer de la serie
     */
    

    public Serie(
    	String titulo, String sinopsis, ArrayList<String> elenco, String director, int vistas,
		Genero genero, ArrayList<Resenia> resenias, Trailer trailer, Pais[] paisesRestringidos,
		int cantTemporadas, ArrayList<Temporada> temporadas
	) {
		super(titulo, sinopsis, elenco, director, vistas, genero, resenias, trailer, paisesRestringidos);
		this.cantTemporadas = cantTemporadas;
		this.temporadas = temporadas;
	}

    // ----- Getters & Setters -----
    
    public int getCantTemporadas() {
		return cantTemporadas;
	}

	public void setTemporadas(int cantTemporadas) {
		this.cantTemporadas = cantTemporadas;
	}
	
	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(ArrayList<Temporada> temporadas) {
		this.temporadas = temporadas;
	}
	
	public void agregarTemporada(Temporada temporada) {
		this.temporadas.add(temporada);
	}
	
	public void eliminarTemporada(Temporada temporada) {
		int num = temporada.getNumTemporada();
		this.getTemporadas().removeIf(obj -> obj.getNumTemporada() == num);
	}
	
}
