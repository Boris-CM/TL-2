package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import enumerativo.Genero;
import enumerativo.Pais;

/**
 * Clase abstracta que representa un contenido audiovisual genérico.
 * Contiene información básica como título, sinopsis, elenco, director, vistas,
 * género y reseñas asociadas por parte de los usuarios.
 * 
 * Esta clase debe ser extendida por tipos concretos de contenido
 * (por ejemplo {@link Audiovisual}), que deben implementar el método {@link #reproducir(int, int, int)}.
 * 
 * @author Tomas
 * @author Boris
 * @version 1.2
 */
public abstract class Contenido {
	
	private int id;
    private String titulo;
    private String sinopsis;
    private ArrayList<String> elenco;
    private String director;
    private int vistas;
    private Genero genero;
    private ArrayList<Resenia> resenias;
    private Trailer trailer;
    private Pais[] paisesRestringidos;

    public Contenido(int id, String titulo, String sinopsis, String director, Genero genero) {
    	this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.director = director;
        this.genero = genero;
    }
    
    /**
     * Constructor de la clase Audiovisual.
     * 
     * @param titulo Título de la obra
     * @param sinopsis Breve descripción del contenido
     * @param elenco Lista de actores o participantes
     * @param director Director del contenido
     * @param vistas Cantidad de visualizaciones registradas
     * @param genero Género principal del contenido
     * @param resenias Lista de reseñas realizadas por los usuarios
     * @param trailer Trailer del contenido
     * @param paisesRestringidos Lista de los paises en donde es restringido
     */
    public Contenido(
    		int id, String titulo, String sinopsis, ArrayList<String> elenco,
            String director, int vistas, Genero genero, ArrayList<Resenia> resenias,
            Trailer trailer, Pais[] paisesRestringidos) {
    	this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.elenco = elenco;
        this.director = director;
        this.vistas = vistas;
        this.genero = genero;
        this.resenias = resenias;
        this.trailer = trailer;
        this.paisesRestringidos = paisesRestringidos;
    }

    // ----- Getters & Setters -----
    
    public int getId() { 
    	return id; 
    }

	public void setId(int id) {
    	this.id = id;
    }
    
	public String getTitulo() { 
    	return titulo; 
    }

	public void setTitulo(String titulo) {
    	this.titulo = titulo;
    }

    public String getSinopsis() { 
    	return sinopsis;
    }
    public void setSinopsis(String sinopsis) { 
    	this.sinopsis = sinopsis; 
    }

    public ArrayList<String> getElenco() {
    	return elenco;
    }
    public void setElenco(ArrayList<String> elenco) {
    	this.elenco = elenco; 
    }

    public String getDirector() {
    	return director; 
    }
    public void setDirector(String director) { 
    	this.director = director;
    }

    public int getVistas() { 
    	return vistas; 
    }
    public void setVistas(int vistas) { 
    	this.vistas = vistas; 
    }

    public Genero getGenero() {
    	return genero; 
    }
    public void setGenero(Genero genero) { 
    	this.genero = genero;
    }

    public Trailer getTrailer() {
		return trailer;
	}
	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	public ArrayList<Resenia> getResenias() { 
    	return resenias; 
    }
    public void setResenias(ArrayList<Resenia> resenias) {
    	this.resenias = resenias; 
    }
    
    public Pais[] getPaisesRestringidos() {
		return paisesRestringidos;
	}

	public void setPaisesRestringidos(Pais[] paisesRestringidos) {
		this.paisesRestringidos = paisesRestringidos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hash(director, elenco, genero, resenias, sinopsis, titulo, vistas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contenido other = (Contenido) obj;
		return Objects.equals(director, other.director) && Objects.equals(elenco, other.elenco)
				&& genero == other.genero && Arrays.equals(paisesRestringidos, other.paisesRestringidos)
				&& Objects.equals(resenias, other.resenias) && Objects.equals(sinopsis, other.sinopsis)
				&& Objects.equals(titulo, other.titulo) && vistas == other.vistas;
	}
    
    /**
     * Verifica si un contenido está restringido en un país específico.
     * 
     * @param p país a comprobar
     * @return true si el contenido está restringido en ese país, false en caso contrario
     */
    public boolean esRestringido(Pais p) {
        if (paisesRestringidos != null) {
            for (Pais restr : paisesRestringidos) {
                if (restr == p) {
                    return true;
                }
            }
        }
        return false;
    }

}
