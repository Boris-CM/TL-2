package validacion;

public class ValidadorDNI implements Validador {

    @Override
    public boolean esValido(String valor) {
        return valor.matches("\\d{7,11}");
    }

    @Override
    public String getMensajeError() {
        return "El DNI debe tener entre 7 y 11 números.";
    }
}