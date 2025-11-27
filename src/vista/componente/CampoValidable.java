package vista.componente;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import validacion.Validador;

public class CampoValidable {

    private final JTextField input;
    private final JLabel errorLabel;
    private final Validador validador;
    private final Color colorError;

    public CampoValidable(JTextField input, JLabel errorLabel, Validador validador, Color colorError) {
        this.input = input;
        this.errorLabel = errorLabel;
        this.validador = validador;
        this.colorError = colorError;
        
        configurar();
    }

    private void configurar() {
        errorLabel.setForeground(colorError);
        errorLabel.setText("");

        input.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { validar(); }
            @Override
            public void removeUpdate(DocumentEvent e) { validar(); }
            @Override
            public void changedUpdate(DocumentEvent e) { validar(); }
        });
    }

    private void validar() {
        String texto = input.getText();

        if (validador.esValido(texto) || texto.length() == 0) {
            errorLabel.setText("");
            input.setBorder(UIManager.getBorder("TextField.border"));
        } else {
            errorLabel.setText(validador.getMensajeError());
            input.setBorder(BorderFactory.createLineBorder(colorError, 2));
        }
    }
}