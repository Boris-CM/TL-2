package audiovisual;

import enumerativos.Pais;

/**
 * Representa un contenido audiovisual específico dentro de la plataforma.
 * Extiende de {@link Audiovisual} e incluye información adicional como
 * duración, múltiples pistas de video, audio y subtítulos, así como restricciones por país.
 * 
 * @author Tomas
 * @author Boris
 * @version 1.0
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
     * @param titulo del contenido
     * @param sinopsis breve descripción del contenido
     * @param elenco elenco principal del contenido
     * @param director director del contenido
     * @param vistas cantidad de visualizaciones registradas
     * @param duracion duración total del contenido en minutos
     * @param audioIndex índice de la pista de audio por defecto
     * @param subtituloIndex índice del subtítulo por defecto
     * @param videoIndex índice del video por defecto
     * @param videos conjunto de videos disponibles
     * @param audios conjunto de audios disponibles
     * @param subtitulos conjunto de subtítulos disponibles
     * @param paisesRestringidos lista de países donde el contenido no está disponible
     */
    public Contenido(int id, String titulo, String sinopsis, String[] elenco,
                     String director, int vistas, int duracion,
                     int audioIndex, int subtituloIndex, int videoIndex,
                     Video[] videos, Audio[] audios, Subtitulo[] subtitulos,
                     Pais[] paisesRestringidos) {
        super(id, titulo, sinopsis, java.util.Arrays.asList(elenco), director, vistas);
        this.duracion = duracion;
        this.audioIndex = audioIndex;
        this.subtituloIndex = subtituloIndex;
        this.videoIndex = videoIndex;
        this.videos = videos;
        this.audios = audios;
        this.subtitulos = subtitulos;
        this.paisesRestringidos = paisesRestringidos;
    }

    /** @return duración del contenido en minutos */
    public int getDuracion() { 
        return duracion; 
    }
    /** @param duracion nueva duración del contenido */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /** @return índice de audio por defecto */
    public int getAudioIndex() {
        return audioIndex; 
    }
    /** @param audioIndex nuevo índice de audio */
    public void setAudioIndex(int audioIndex) { 
        this.audioIndex = audioIndex; 
    }

    /** @return índice de subtítulo por defecto */
    public int getSubtituloIndex() {
        return subtituloIndex; 
    }
    /** @param subtituloIndex nuevo índice de subtítulo */
    public void setSubtituloIndex(int subtituloIndex) { 
        this.subtituloIndex = subtituloIndex;
    }

    /** @return índice de video por defecto */
    public int getVideoIndex() { 
        return videoIndex; 
    }
    /** @param videoIndex nuevo índice de video */
    public void setVideoIndex(int videoIndex) {
        this.videoIndex = videoIndex; 
    }

    /** @return arreglo con los videos disponibles */
    public Video[] getVideos() { 
        return videos; 
    }
    /** @param videos nuevo arreglo de videos */
    public void setVideos(Video[] videos) { 
        this.videos = videos; 
    }

    /** @return arreglo con los audios disponibles */
    public Audio[] getAudios() { 
        return audios;
    }
    /** @param audios nuevo arreglo de audios */
    public void setAudios(Audio[] audios) { 
        this.audios = audios; 
    }

    /** @return arreglo con los subtítulos disponibles */
    public Subtitulo[] getSubtitulos() { 
        return subtitulos; 
    }
    /** @param subtitulos nuevo arreglo de subtítulos */
    public void setSubtitulos(Subtitulo[] subtitulos) { 
        this.subtitulos = subtitulos; 
    }

    /** @return arreglo de países restringidos */
    public Pais[] getPaisesRestringidos() { 
        return paisesRestringidos;
    }
    /** @param paisesRestringidos nuevo arreglo de países restringidos */
    public void setPaisesRestringidos(Pais[] paisesRestringidos) { 
        this.paisesRestringidos = paisesRestringidos;
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

    /**
     * Implementación del método abstracto de {@link Audiovisual}.
     * Mediante los índices seleccionados, se determina qué datos buscar en la base
     * de datos (video, audio y subtítulo) para cargarlos en el reproductor.
     * 
     * @param videoIndex índice del video a reproducir
     * @param audioIndex índice del audio a reproducir
     * @param subtituloIndex índice del subtítulo a mostrar
     */
    @Override
    public void reproducir(int videoIndex, int audioIndex, int subtituloIndex) {
        // Lógica futura para interactuar con la base de datos
    }
}
