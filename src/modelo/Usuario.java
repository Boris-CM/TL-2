package modelo;

import java.util.ArrayList;
import java.util.Objects;

import enumerativos.*;

/**
 * La clase Usuario implementa la logica que sea nesesaria para manipular todo lo correspondiente a los usuarios
 * 
 * @author Boris
 * @author  Tomas
 */
public class Usuario {

	private int id;
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private ArrayList<Genero> generosFavoritos;
	private Pais pais;
	private Idioma idioma;
	private Estado estado;
	private ArrayList<Contenido> favoritos;
	private ArrayList<Historial> historial;
	private DatosPersonales datos;
	
	//Constructor
	public Usuario() {}

	public Usuario(int id, String nombre, String apellido, String email, String contrasenia,
			ArrayList<Genero> generosFavoritos, Pais pais, Idioma idioma, Estado estado,
			ArrayList<Contenido> favoritos, ArrayList<Historial> historial, DatosPersonales datos) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
		this.generosFavoritos = generosFavoritos;
		this.pais = pais;
		this.idioma = idioma;
		this.estado = estado;
		this.favoritos = favoritos;
		this.historial = historial;
		this.datos = datos;
	}

	// ----- Getters & Setters -----
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
	public ArrayList<Genero> getGenerosFavoritos() {
		return generosFavoritos;
	}
	public void setGenerosFavoritos(ArrayList<Genero> generosFavoritos) {
		this.generosFavoritos = generosFavoritos;
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
	public ArrayList<Contenido> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(ArrayList<Contenido> favoritos) {
		this.favoritos = favoritos;
	}

	public ArrayList<Historial> getHistorial() {
		return historial;
	}

	public void setHistorial(ArrayList<Historial> historial) {
		this.historial = historial;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", contrasenia=" + contrasenia + ", generosFavoritos=" + generosFavoritos + ", pais=" + pais
				+ ", idioma=" + idioma + ", estado=" + estado + ", favoritos=" + favoritos + ", historial=" + historial
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, contrasenia, email, estado, favoritos, generosFavoritos, historial, id, idioma,
				nombre, pais);
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
				&& Objects.equals(email, other.email) && estado == other.estado
				&& Objects.equals(favoritos, other.favoritos)
				&& Objects.equals(generosFavoritos, other.generosFavoritos)
				&& Objects.equals(historial, other.historial) && id == other.id && idioma == other.idioma
				&& Objects.equals(nombre, other.nombre) && pais == other.pais;
	}

	/**
	 * Agrega el genero al final de la lista generosFavoritos, en caso de que se encuentre en la lista no lo agrega
	 * 
	 * @param elemento El genero que se desea agregar
	 * 
	 */
	public void agregarGenero(Genero elemento) {
		ArrayList<Genero> generos  = this.getGenerosFavoritos();
		if(generos.indexOf(elemento) != -1) {
			generos.add(elemento);
		}
	}
	
	/**
	 * Elimina el genero de la lista de generosFavoritos
	 * 
	 * @param elemento El genero que se desea eliminar
	 * 
	 */
	public void eliminarGenero(Genero elemento) {
		this.getGenerosFavoritos().remove(elemento);
	}
	
	/**
	 * Agrega el audiovisual al final de favoritos
	 * 
	 * @param elemento El Audiovisual que se desea agregar
	 * 
	 */
	public void agregarFavorito(Contenido elemento) {
		this.getFavoritos().add(elemento);
	}
	
	/**
	 * Elimina el audiovisual de favoritos
	 * 
	 * @param elemento El audiovisual que se desea eliminar
	 * 
	 */
	public void eliminarFavorito(Contenido elemento) {
		this.getFavoritos().remove(elemento);
	}
	
	/**
	 * Agrega el audiovisual al final del historial
	 * 
	 * @param elemento El audiovisual que se desea agregar
	 * 
	 */
	public void agregarHistorial(Historial elemento) {
		this.getHistorial().add(elemento);
	}
	
	
}