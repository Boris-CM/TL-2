package validacion;

public interface Validador {
	boolean esValido(String valor);
    String getMensajeError();
}
