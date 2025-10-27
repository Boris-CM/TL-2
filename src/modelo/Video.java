package modelo;

import enumerativo.Calidad;

public class Video {
	private int frame;
	private int tiempo;
	private int duracion;
	private Calidad calidad;
	
	public Video(int frame, int tiempo, int duracion, Calidad calidad) {
		super();
		this.frame = frame;
		this.tiempo = tiempo;
		this.duracion = duracion;
		this.calidad = calidad;
	}
	
	// ----- Getters & Setters -----
	
	public int getFrame() {
		return frame;
	}
	public void setFrame(int frame) {
		this.frame = frame;
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
	public Calidad getCalidad() {
		return calidad;
	}
	public void setCalidad(Calidad calidad) {
		this.calidad = calidad;
	}
}
