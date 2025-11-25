package validacion;

public class ValidadorNombre implements Validador {

    @Override
    public boolean esValido(String valor) {
        return valor != null && valor.matches("[a-zA-ZáéíóúÁÉÍÓÚ]+( [a-zA-ZáéíóúÁÉÍÓÚ]+)*");
    }

    @Override
    public String getMensajeError() {
        return "El nombre no debe contener números ni símbolos.";
    }
}