package usuario;

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
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private ArrayList<Genero> generosFavoritos;
	private Pais pais;
	private Idioma idioma;
	private Estado estado;
	
	//Constructor
	public Usuario() {}

	public Usuario(int id, String nombre, String apellido, String email, String contrasenia,
			ArrayList<Genero> generosFavoritos, Pais pais, Idioma idioma, Estado estado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
		this.generosFavoritos = generosFavoritos;
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
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", contrasenia=" + contrasenia + ", generosFavoritos=" + generosFavoritos + ", pais=" + pais
				+ ", idioma=" + idioma + ", estado=" + estado + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellido, contrasenia, email, estado, id, idioma, nombre, pais, generosFavoritos);
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
				&& Objects.equals(generosFavoritos, other.generosFavoritos);
	}
	
	//METODOS PARA EL JAVADOC
	
	/**
	 * Agrega el genero al final de la lista generosFavoritos, en caso de ya este en la lista no lo agrega
	 * 
	 * @param genero El genero que se desea agregar
	 * 
	 */
	public void agregarGenero(Genero genero) {
		ArrayList<Genero> generos  = this.getGenerosFavoritos();
		if(generos.indexOf(genero) != -1) {
			generos.add(genero);
		}
	}
	
	/**
	 * Elimina el genero de la lista de generosFavoritos
	 * 
	 * @param genero El genero que se desea reliminar
	 * 
	 */
	public void eliminarGenero(Genero genero) {
		ArrayList<Genero> generos  = this.getGenerosFavoritos();
		int index = generos.indexOf(genero);
		if(index != -1) {
			generos.remove(index);
		}
	}
	
	/**
	 * Agrega el genero al final de la lista generosFavoritos, en caso de ya este en la lista no lo agrega
	 * 
	 * @param genero El genero que se desea agregar
	 * 
	 */
	public void agregarAudiovisual() {}
	
	public void eliminarAudiovisual() {}
	
	
}
