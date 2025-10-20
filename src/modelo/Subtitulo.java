package modelo;

import enumerativos.Idioma;

public class Subtitulo {
	private int datos;
	private int tiempo;
	private int duracion;
	private Idioma idioma;
	
	public Subtitulo(int datos, int tiempo, int duracion, Idioma idioma) {
		super();
		this.datos = datos;
		this.tiempo = tiempo;
		this.duracion = duracion;
		this.idioma = idioma;
	}
	
	// ----- Getters & Setters -----
	
	public int getDatos() {
		return datos;
	}
	public void setDatos(int datos) {
		this.datos = datos;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
}
