package validacion;

public class ValidadorContrasenia implements Validador {

    @Override
    public boolean esValido(String valor) {
        return valor.matches("^[^\\\\s]+$");
    }

    @Override
    public String getMensajeError() {
        return "La contraseña no puede contener espacios.";
    }
}