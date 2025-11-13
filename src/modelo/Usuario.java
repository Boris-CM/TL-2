package modelo;

import java.util.ArrayList;
import java.util.Objects;

import enumerativo.*;

/**
 * La clase Usuario implementa la logica que sea nesesaria para manipular todo lo correspondiente a los usuarios
 * 
 * @author Boris
 * @author  Tomas
 */
public class Usuario {

	private int id;
	private DatosPersonales datos;
	private String nombreUsuario;
	private String email;
	private String contrasenia;
	private ArrayList<Genero> generosFavoritos;
	private Pais pais;
	private Idioma idioma;
	private Estado estado;
	private ArrayList<Contenido> favoritos;
	private ArrayList<Historial> historial;
	
	//Constructor
	public Usuario() {}
	
	public Usuario(int id, DatosPersonales datos, String nombreUsuario, String email, String contrasenia) {
		this.id = id;
		this.datos = datos;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public Usuario(int id, DatosPersonales datos, String nombreUsuario, String email, String contrasenia,
			ArrayList<Genero> generosFavoritos, Pais pais, Idioma idioma, Estado estado,
			ArrayList<Contenido> favoritos, ArrayList<Historial> historial) {
		this.id = id;
		this.datos = datos;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenia = contrasenia;
		this.generosFavoritos = generosFavoritos;
		this.pais = pais;
		this.idioma = idioma;
		this.estado = estado;
		this.favoritos = favoritos;
		this.historial = historial;
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
		return "Usuario [id=" + id + ", datos= DatosPersonales[" + datos.toString() + "], nombreUsuario=" + nombreUsuario + ", email=" + email
				+ ", contrasenia=" + contrasenia + ", generosFavoritos=" + generosFavoritos + ", pais=" + pais
				+ ", idioma=" + idioma + ", estado=" + estado + ", favoritos=" + favoritos + ", historial=" + historial
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contrasenia, datos, email, estado, favoritos, generosFavoritos, historial, id, idioma,
				nombreUsuario, pais);
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
		return Objects.equals(contrasenia, other.contrasenia) && Objects.equals(datos, other.datos)
				&& Objects.equals(email, other.email) && estado == other.estado
				&& Objects.equals(favoritos, other.favoritos)
				&& Objects.equals(generosFavoritos, other.generosFavoritos)
				&& Objects.equals(historial, other.historial) && id == other.id && idioma == other.idioma
				&& Objects.equals(nombreUsuario, other.nombreUsuario) && pais == other.pais;
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
	 * Agrega el contenido al final de favoritos
	 * 
	 * @param elemento El contenido que se desea agregar
	 * 
	 */
	public void agregarFavorito(Contenido elemento) {
		this.getFavoritos().add(elemento);
	}
	
	/**
	 * Elimina el contenido de favoritos
	 * 
	 * @param elemento El contenido que se desea eliminar
	 * 
	 */
	public void eliminarFavorito(Contenido elemento) {
		this.getFavoritos().remove(elemento);
	}
	
	/**
	 * Agrega el contenido al final del Historial
	 * 
	 * @param elemento El contenido que se desea agregar
	 * 
	 */
	public void agregarHistorial(Historial elemento) {
		this.getHistorial().add(elemento);
	}
	
}