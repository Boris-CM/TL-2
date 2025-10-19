package modelo;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String email;
    private String contrasenia;
    private DatosPersonales datos;

    public Usuario(String nombreUsuario, String email, String contrasenia, DatosPersonales datos) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.setContrasenia(contrasenia);
        this.datos = datos;
    }

    public Usuario(int id, String nombreUsuario, String email, String contrasenia, DatosPersonales datos) {
        this(nombreUsuario, email, contrasenia, datos);
        this.id = id;
    }

    public int getId() { return id; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getEmail() { return email; }
    public DatosPersonales getDatos() { return datos; }

    @Override
    public String toString() {
        return nombreUsuario + " (" + email + ") - " + datos.toString();
    }

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
