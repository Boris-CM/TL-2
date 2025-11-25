package validacion;

public class ValidadorEmail implements Validador {

    @Override
    public boolean esValido(String valor) {
        return valor != null && valor.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    @Override
    public String getMensajeError() {
        return "Formato de email inválido.";
    }
}