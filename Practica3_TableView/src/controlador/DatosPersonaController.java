/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author margr
 */
public class DatosPersonaController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;
    
    private String newName, newSurname;
    private boolean cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cancel = true; // if user closes with 'x'
    } 
    
    public void initPersona(Persona p) {
        nameTextField.setText(p.getNombre());
        surnameTextField.setText(p.getApellidos());
    }
    
    public boolean getCancelar() {
        return cancel;
    }
    
    public String getNewName() {
        return newName;
    }
    
    public String getNewSurname() {
        return newSurname;
    }

    @FXML
    private void acceptButtonClicked(ActionEvent event) {
        cancel = false;
        newName = nameTextField.getText();
        newSurname = surnameTextField.getText();
        Stage stage = (Stage) acceptButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelButtonClicked(ActionEvent event) {
        cancel = true;
//        Stage stage = (Stage) cancelButton.getScene().getWindow();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
    
       
}
