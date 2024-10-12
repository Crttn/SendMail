package es.crttn.dad.controller;

import es.crttn.dad.alerts.Alerts;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.apache.commons.mail2.core.EmailException;
import org.apache.commons.mail2.javax.DefaultAuthenticator;
import org.apache.commons.mail2.javax.Email;
import org.apache.commons.mail2.javax.SimpleEmail;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    Alerts a = new Alerts();

    @FXML
    private Button clearButton;

    @FXML
    private Button closeButton;

    @FXML
    private TextField emailFromTextField;

    @FXML
    private TextField emailToTextField;

    @FXML
    private TextArea mesageTextArea;

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwdField;

    @FXML
    private TextField portTextField;

    @FXML
    private GridPane root;

    @FXML
    private Button sendButton;

    @FXML
    private CheckBox sslCheckBox;

    @FXML
    private TextField subjectTextField;


    public MainController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public GridPane getRoot() {
        return root;
    }

    @FXML
    void sendOnaction(ActionEvent event) {

        try {
            Email email = getEmail();
            email.send();

            a.setConfirmatioAlert(emailFromTextField.getText());

        } catch (IllegalArgumentException e) {
            a.setErroAlert();
        } catch (EmailException e) {
            a.setErroAlert();
            throw new RuntimeException(e);
        }

    }

    private Email getEmail() throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName(nameTextField.getText());
        email.setSmtpPort(Integer.parseInt(portTextField.getText()));
        email.setAuthentication(emailFromTextField.getText(), passwdField.getText());
        email.setSSLOnConnect(sslCheckBox.isSelected());
        email.setFrom(emailFromTextField.getText());
        email.setSubject(subjectTextField.getText());
        email.setMsg(mesageTextArea.getText());
        email.addTo(emailToTextField.getText());
        return email;
    }

    @FXML
    void clearOnAction(ActionEvent event) {

        nameTextField.clear();
        portTextField.clear();
        sslCheckBox.setSelected(false);
        emailToTextField.clear();
        emailFromTextField.clear();
        passwdField.clear();
        subjectTextField.clear();
        mesageTextArea.clear();
    }

    @FXML
    void closeOnAction(ActionEvent event) {
        System.exit(0);
    }

}
