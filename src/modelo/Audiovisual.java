package modelo;

import java.util.ArrayList;

import enumerativo.*;

/**
 * Representa un contenido audiovisual específico dentro de la plataforma.
 * Extiende de {@link Contenido} e incluye información adicional como
 * duración, múltiples pistas de video, audio y subtítulos, así como restricciones por país.
 * 
 * @author Tomas
 * @author Boris
 * @version 1.1
 */
public class Audiovisual extends Contenido {
	private double duracion;
    private String pathDoblaje;
    private String pathSubtitulo;
    private String pathVideo;
    

    private Video[] videosDisponibles;
    private Audio[] doblajesDisponibles;
    private Subtitulo[] subtitulosDisponibles;
    private TipoContenido tipo;
    
    public Audiovisual(int id, String titulo, String sinopsis, String director, Genero genero, double duracion, TipoContenido tipo) {
		super(id, titulo, sinopsis, director, genero);
		this.duracion = duracion;
		this.tipo = tipo;
	}

    /**
     * Constructor de la clase Contenido.
     * 
     * @param titulo título del contenido
     * @param sinopsis breve descripción del contenido
     * @param elenco elenco principal del contenido
     * @param director director del contenido
     * @param vistas cantidad de visualizaciones registradas
     * @param genero género principal del audiovisual
     * @param resenas lista de reseñas realizadas por los usuarios
     * @param duracion duración total del contenido en minutos
     * @param pathDoblaje path de la pista de audio
     * @param pathSubtitulo path del subtítulo
     * @param pathVideo path del video
     * @param videosDisponibles conjunto de videos disponibles
     * @param doblajesDisponibles conjunto de audios disponibles
     * @param subtitulosDisponibles conjunto de subtítulos disponibles
     * @param tipo tipo del contenido que representa el audiovisual
     */
    
    public Audiovisual(int id, String titulo, String sinopsis, ArrayList<String> elenco, String director, int vistas,
			Genero genero, ArrayList<Resenia> resenias, Trailer trailer, double duracion, String pathDoblaje,
			String pathSubtitulo, String pathVideo, Video[] videosDisponibles, Audio[] doblajesDisponibles,
			Subtitulo[] subtitulosDisponibles, Pais[] paisesRestringidos, TipoContenido tipo) {
		super(id, titulo, sinopsis, elenco, director, vistas, genero, resenias, trailer, paisesRestringidos);
		this.duracion = duracion;
		this.pathDoblaje = pathDoblaje;
		this.pathSubtitulo = pathSubtitulo;
		this.pathVideo = pathVideo;
		this.videosDisponibles = videosDisponibles;
		this.doblajesDisponibles = doblajesDisponibles;
		this.subtitulosDisponibles = subtitulosDisponibles;
		this.tipo = tipo;
	}

	// ----- Getters & Setters -----

    public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getPathDoblaje() {
		return pathDoblaje;
	}

	public void setPathDoblaje(String pathDoblaje) {
		this.pathDoblaje = pathDoblaje;
	}

	public String getPathSubtitulo() {
		return pathSubtitulo;
	}

	public void setPathSubtitulo(String pathSubtitulo) {
		this.pathSubtitulo = pathSubtitulo;
	}

	public String getPathVideo() {
		return pathVideo;
	}

	public void setPathVideo(String pathVideo) {
		this.pathVideo = pathVideo;
	}

	public Video[] getVideosDisponibles() {
		return videosDisponibles;
	}

	public void setVideosDisponibles(Video[] videosDisponibles) {
		this.videosDisponibles = videosDisponibles;
	}

	public Audio[] getDoblajesDisponibles() {
		return doblajesDisponibles;
	}

	public void setDoblajesDisponibles(Audio[] doblajesDisponibles) {
		this.doblajesDisponibles = doblajesDisponibles;
	}

	public Subtitulo[] getSubtitulosDisponibles() {
		return subtitulosDisponibles;
	}

	public void setSubtitulosDisponibles(Subtitulo[] subtitulosDisponibles) {
		this.subtitulosDisponibles = subtitulosDisponibles;
	}

	public TipoContenido getTipo() {
		return tipo;
	}

	public void setTipo(TipoContenido tipo) {
		this.tipo = tipo;
	}

}
