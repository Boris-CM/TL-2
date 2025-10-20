package modelo;

public class Reproductor {
	private int velocidad;
	private int latencia;
	private int buffer;
	private Historial ultContenido;
	
	public Reproductor(int velocidad, int latencia, int buffer, Historial ultContenido) {
		super();
		this.velocidad = velocidad;
		this.latencia = latencia;
		this.buffer = buffer;
		this.ultContenido = ultContenido;
	}
	
	// ----- Getters & Setters -----
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getLatencia() {
		return latencia;
	}
	public void setLatencia(int latencia) {
		this.latencia = latencia;
	}
	public int getBuffer() {
		return buffer;
	}
	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}
	public Historial getUltContenido() {
		return ultContenido;
	}
	public void setUltContenido(Historial ultContenido) {
		this.ultContenido = ultContenido;
	}
	
	public void adaptar() {}
	
	public void play() {}
	
	public void pausar() {}
	
	public void adelantar() {}
	
	public void retroceder() {}


}
