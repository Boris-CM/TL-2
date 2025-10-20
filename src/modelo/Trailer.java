package modelo;

public class Trailer {
	private int tiempo;
	private int duracion;
	private int datos;
	private String path;
	
	public Trailer(int tiempo, int duracion, int datos, String path) {
		super();
		this.tiempo = tiempo;
		this.duracion = duracion;
		this.datos = datos;
		this.path = path;
	}
	
	// ----- Getters & Setters -----
	
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
	public int getDatos() {
		return datos;
	}
	public void setDatos(int datos) {
		this.datos = datos;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
