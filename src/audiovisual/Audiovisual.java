package audiovisual;

import java.util.List;

/**
 * Clase abstracta que representa un contenido audiovisual genérico.
 * Contiene información básica como título, sinopsis, elenco, director y cantidad de vistas.
 * 
 * Esta clase debe ser extendida por tipos concretos de contenido 
 * (por ejemplo {@link Contenido}), que deben implementar el método {@link #reproducir(int, int, int)}.
 * 
 * @author Tomas
 * @author Boris
 * @version 1.0
 */
public abstract class Audiovisual {
    private int id;
    private String titulo;
    private String sinopsis;
    private List<String> elenco;
    private String director;
    private int vistas;

    /**
     * Constructor de la clase Audiovisual.
     * 
     * @param id identificador único del audiovisual
     * @param titulo título de la obra
     * @param sinopsis breve descripción del contenido
     * @param elenco lista de actores o participantes
     * @param director director del contenido
     * @param vistas cantidad de visualizaciones registradas
     */
    public Audiovisual(int id, String titulo, String sinopsis, List<String> elenco, String director, int vistas) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.elenco = elenco;
        this.director = director;
        this.vistas = vistas;
    }

    /** @return identificador único del audiovisual */
    public int getId() { 
        return id;
    }
    /** @param id nuevo identificador del audiovisual */
    public void setId(int id) {
        this.id = id;
    }

    /** @return título del audiovisual */
    public String getTitulo() { 
        return titulo; 
    }
    /** @param titulo nuevo título del audiovisual */
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }

    /** @return sinopsis del audiovisual */
    public String getSinopsis() { 
        return sinopsis; 
    }
    /** @param sinopsis nueva descripción del audiovisual */
    public void setSinopsis(String sinopsis) { 
        this.sinopsis = sinopsis; 
    }

    /** @return elenco del audiovisual */
    public List<String> getElenco() { 
        return elenco; 
    }
    /** @param elenco nueva lista de actores/participantes */
    public void setElenco(List<String> elenco) { 
        this.elenco = elenco;
    }

    /** @return nombre del director */
    public String getDirector() {
        return director; 
    }
    /** @param director nuevo director del audiovisual */
    public void setDirector(String director) {
        this.director = director; 
    }

    /** @return cantidad de vistas del audiovisual */
    public int getVistas() { 
        return vistas; 
    }
    /** @param vistas nueva cantidad de visualizaciones */
    public void setVistas(int vistas) { 
        this.vistas = vistas;
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
