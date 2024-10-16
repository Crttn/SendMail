package es.crttn.dad.alerts;

import javafx.scene.control.Alert;

public class Alerts {

    private final Alert confirmatioAlert = new Alert(Alert.AlertType.CONFIRMATION);
    private final Alert erroAlert = new Alert(Alert.AlertType.ERROR);

    public void setConfirmatioAlert(String email) {

        confirmatioAlert.setTitle("");
        confirmatioAlert.setHeaderText("Envio con exito");
        confirmatioAlert.setContentText("Mensaje enviado con exito a '" + email + "'");
        confirmatioAlert.showAndWait();
    }

    public void setErroAlert() {

        erroAlert.setTitle("");
        erroAlert.setHeaderText("Error al enviar el email");
        erroAlert.setContentText("Ha habido un error al enviar el email, comprueba los campos.");
        erroAlert.showAndWait();
    }
}
