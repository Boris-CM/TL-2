package usuario;

import java.util.ArrayList;
import java.util.Objects;

import enumerativos.*;

public class Usuario {

	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private ArrayList<Genero> preferenciaDeGeneros;
	private Pais pais;
	private Idioma idioma;
	private Estado estado;
	
	//Constructor
	public Usuario() {}

	public Usuario(int id, String nombre, String apellido, String email, String contrasenia,
			ArrayList<Genero> preferenciaDeGeneros, Pais pais, Idioma idioma, Estado estado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
		this.preferenciaDeGeneros = preferenciaDeGeneros;
		this.pais = pais;
		this.idioma = idioma;
		this.estado = estado;
	}

	//Getters y Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public ArrayList<Genero> getPreferenciaDeGeneros() {
		return preferenciaDeGeneros;
	}
	public void setPreferenciaDeGeneros(ArrayList<Genero> preferenciaDeGeneros) {
		this.preferenciaDeGeneros = preferenciaDeGeneros;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", contrasenia=" + contrasenia + ", preferenciaDeGeneros=" + preferenciaDeGeneros + ", pais=" + pais
				+ ", idioma=" + idioma + ", estado=" + estado + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellido, contrasenia, email, estado, id, idioma, nombre, pais, preferenciaDeGeneros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(contrasenia, other.contrasenia)
				&& Objects.equals(email, other.email) && estado == other.estado && id == other.id
				&& idioma == other.idioma && Objects.equals(nombre, other.nombre) && pais == other.pais
				&& Objects.equals(preferenciaDeGeneros, other.preferenciaDeGeneros);
	}
	
	//METODOS PARA EL JAVADOC
	public void agregarGenero(Genero genero) {
		ArrayList<Genero> generos  = this.getPreferenciaDeGeneros();
		if(generos.indexOf(genero) != -1) {
			generos.add(genero);
		}
	}
	
	public void eliminarGenero(Genero genero) {
		ArrayList<Genero> generos  = this.getPreferenciaDeGeneros();
		int index = generos.indexOf(genero);
		if(index != -1) {
			generos.remove(index);
		}
	}
	
	public void agregarAudiovisual() {}
	
	public void eliminarAudiovisual() {}
	
	
}
