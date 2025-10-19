package modelo;

import java.util.List;
import enumerativos.Pais;

/**
 * Representa un contenido audiovisual específico dentro de la plataforma.
 * Extiende de {@link Audiovisual} e incluye información adicional como
 * duración, múltiples pistas de video, audio y subtítulos, así como restricciones por país.
 * 
 * @author Tomas
 * @author Boris
 * @version 1.1
 */
public class Contenido extends Audiovisual {
    private int audioIndex;
    private int subtituloIndex;
    private int videoIndex;
    private int duracion;

    private Video[] videos;
    private Audio[] audios;
    private Subtitulo[] subtitulos;
    private Pais[] paisesRestringidos;

    /**
     * Constructor de la clase Contenido.
     * 
     * @param id identificador del contenido
     * @param titulo título del contenido
     * @param sinopsis breve descripción del contenido
     * @param elenco elenco principal del contenido
     * @param director director del contenido
     * @param vistas cantidad de visualizaciones registradas
     * @param genero género principal del audiovisual
     * @param resenas lista de reseñas realizadas por los usuarios
     * @param duracion duración total del contenido en minutos
     * @param audioIndex índice de la pista de audio por defecto
     * @param subtituloIndex índice del subtítulo por defecto
     * @param videoIndex índice del video por defecto
     * @param videos conjunto de videos disponibles
     * @param audios conjunto de audios disponibles
     * @param subtitulos conjunto de subtítulos disponibles
     * @param paisesRestringidos lista de países donde el contenido no está disponible
     */
    public Contenido(int id, String titulo, String sinopsis, List<String> elenco,
                     String director, int vistas, enumerativos.Genero genero, List<Resena> resenas,
                     int duracion, int audioIndex, int subtituloIndex, int videoIndex,
                     Video[] videos, Audio[] audios, Subtitulo[] subtitulos,
                     Pais[] paisesRestringidos) {
        super(id, titulo, sinopsis, elenco, director, vistas, genero, resenas);
        this.duracion = duracion;
        this.audioIndex = audioIndex;
        this.subtituloIndex = subtituloIndex;
        this.videoIndex = videoIndex;
        this.videos = videos;
        this.audios = audios;
        this.subtitulos = subtitulos;
        this.paisesRestringidos = paisesRestringidos;
    }

    // ----- Getters & Setters -----

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { 
    	this.duracion = duracion; 
    	}

    public int getAudioIndex() { return audioIndex; }
    public void setAudioIndex(int audioIndex) { 
    	this.audioIndex = audioIndex; 
    	}

    public int getSubtituloIndex() { 
    	return subtituloIndex;
    	}
    public void setSubtituloIndex(int subtituloIndex) { 
    	this.subtituloIndex = subtituloIndex; 
    	}

    public int getVideoIndex() { 
    	return videoIndex; 
    	}
    public void setVideoIndex(int videoIndex) {
    	this.videoIndex = videoIndex; 
    	}

    public Video[] getVideos() { 
    	return videos;
    	}
    public void setVideos(Video[] videos) {
    	this.videos = videos;
    	}

    public Audio[] getAudios() { 
    	return audios; 
    	}
    public void setAudios(Audio[] audios) { 
    	this.audios = audios; 
    	}

    public Subtitulo[] getSubtitulos() {
    	return subtitulos; 
    	}
    public void setSubtitulos(Subtitulo[] subtitulos) { 
    	this.subtitulos = subtitulos; 
    	}

    public Pais[] getPaisesRestringidos() { 
    	return paisesRestringidos; 
    	}
    public void setPaisesRestringidos(Pais[] paisesRestringidos) { this.paisesRestringidos = paisesRestringidos; }

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

    /**
     * Implementación del método abstracto de {@link Audiovisual}.
     * Mediante los índices seleccionados, se determina qué datos buscar en la base
     * de datos (video, audio y subtítulo) para cargarlos en el reproductor.
     */
    @Override
    public void reproducir(int videoIndex, int audioIndex, int subtituloIndex) {
        // Aquí iría la lógica real para reproducir con el reproductor
        System.out.println("Reproduciendo contenido con video " + videoIndex +
                           ", audio " + audioIndex +
                           ", subtítulo " + subtituloIndex);
        /** pusimos eso para no dejar el metodo sin implementar xque tiraba error 
         
         */
    }
}
