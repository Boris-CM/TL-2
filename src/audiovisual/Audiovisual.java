package audiovisual;

import java.util.List;
import enumerativos.Genero;

/**
 * Clase abstracta que representa un contenido audiovisual genérico.
 * Contiene información básica como título, sinopsis, elenco, director, vistas,
 * género y reseñas asociadas por parte de los usuarios.
 * 
 * Esta clase debe ser extendida por tipos concretos de contenido
 * (por ejemplo {@link Contenido}), que deben implementar el método {@link #reproducir(int, int, int)}.
 * 
 * @author Tomas
 * @author Boris
 * @version 1.2
 */
public abstract class Audiovisual {
    private int id;
    private String titulo;
    private String sinopsis;
    private List<String> elenco;
    private String director;
    private int vistas;
    private Genero genero;
    private List<Resena> resenas;

    /**
     * Constructor de la clase Audiovisual.
     * 
     * @param id identificador único del audiovisual
     * @param titulo título de la obra
     * @param sinopsis breve descripción del contenido
     * @param elenco lista de actores o participantes
     * @param director director del contenido
     * @param vistas cantidad de visualizaciones registradas
     * @param genero género principal del audiovisual
     * @param resenas lista de reseñas realizadas por los usuarios
     */
    public Audiovisual(int id, String titulo, String sinopsis, List<String> elenco,
                       String director, int vistas, Genero genero, List<Resena> resenas) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.elenco = elenco;
        this.director = director;
        this.vistas = vistas;
        this.genero = genero;
        this.resenas = resenas;
    }


    public int getId() { return id; }
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

    public List<String> getElenco() {
    	return elenco;
    	}
    public void setElenco(List<String> elenco) {
    	this.elenco = elenco; 
    	}

    public String getDirector() {
    	return director; 
    	}
    public void setDirector(String director) 
    { this.director = director;
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

    public List<Resena> getResenas() { 
    	return resenas; 
    	}
    public void setResenas(List<Resena> resenas) {
    	this.resenas = resenas; 
    	}

    /**
     * Método abstracto que obliga a las subclases a definir cómo se reproducirá
     * el contenido audiovisual según los índices de video, audio y subtítulos.
     * 
     * @param videoIndex índice del video a reproducir
     * @param audioIndex índice del audio a reproducir
     * @param subtituloIndex índice del subtítulo a mostrar
     */
    public abstract void reproducir(int videoIndex, int audioIndex, int subtituloIndex);
}
