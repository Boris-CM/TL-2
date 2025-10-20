package modelo;

public class Historial {
	private int tiempo;
	private Usuario usuario;
	private Contenido contenido;

	public Historial(int tiempo, Usuario usuario, Contenido contenido) {
		this.tiempo = tiempo;
		this.usuario = usuario;
		this.contenido = contenido;
	}

	// ----- Getters & Setters -----
	
	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Contenido getContenido() {
		return contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}
}
