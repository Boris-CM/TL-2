package modelo;

import java.util.ArrayList;

public class PlataformaStreaming {
	private Usuario usuario;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Contenido> contenidos;
	
	PlataformaStreaming(){}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usurario) {
		this.usuario = usurario;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Contenido> getContenidos() {
		return contenidos;
	}

	public void setContenidos(ArrayList<Contenido> contenidos) {
		this.contenidos = contenidos;
	}

	public void iniciarSesion(String email, String contrasenia){
		for (int i = 0; i < this.getUsuarios().size(); i++) {
	        Usuario actual = this.getUsuarios().get(i);
	        if (actual.getEmail().compareTo(email) == 0 && actual.getContrasenia().compareTo(contrasenia) == 0) {
	            this.setUsuario(actual);
	            break;
	        }
	    }
	}
	
	public void agregarUsuario(Usuario u){
		this.getUsuarios().add(u);
	}
	
	public ArrayList<Historial> getHistorialUsuario(){
		return this.getUsuario().getHistorial();
	}
	
	public int findHistorial(ArrayList<Historial> historial, Contenido contenido){
		for (int i = 0; i < historial.size(); i++) {
			Historial actual = historial.get(i);
	        if (actual.getContenido().getTitulo().compareTo(contenido.getTitulo()) == 0) {
	            return i;
	        }
	    }
		return -1;
	}
}
