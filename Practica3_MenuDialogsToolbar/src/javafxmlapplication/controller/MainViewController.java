/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author sovacu
 */
public class MainViewController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private CheckMenuItem optionAmazonItem;
    @FXML
    private CheckMenuItem optionEbayItem;
    @FXML
    private Label estadoLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estadoLabel.setText("Hola");
    }    

    @FXML
    private void optionAmazonClicked(ActionEvent event) {
    }

    @FXML
    private void optionEbayClicked(ActionEvent event) {
    }

    @FXML
    private void amazonButtonClicked(ActionEvent event) {
        if (optionAmazonItem.isSelected()) {
            WebView webView = new WebView();
            webView.getEngine().load("http://www.amazon.es");
            borderPane.setCenter(webView);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error en la selección");
            alert.setHeaderText("No puede comprar en Amazon.");
            alert.setContentText("Por favor, cambie la selección actual en el menú Opciones.");
            alert.showAndWait();
        }
    }

    @FXML
    private void ebayButtonClicked(ActionEvent event) {
        if (optionEbayItem.isSelected()) {
            WebView webView = new WebView();
            webView.getEngine().load("http://www.ebay.es");
            borderPane.setCenter(webView);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error en la selección");
            alert.setHeaderText("No puede comprar en Ebay.");
            alert.setContentText("Por favor, cambie la selección actual en el menú Opciones.");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void bingButtonClicked(ActionEvent event) {
        
        List<String> choices = new ArrayList<>();
        choices.add("El blog de Athos");
        choices.add("El blog de Porthos");
        choices.add("El blog de Aramis");
        
        ChoiceDialog<String> dialog = new ChoiceDialog<>("El blog de Athos", choices);
        dialog.setTitle("Selecciona un blog");
        dialog.setHeaderText("¿Qué blog quieres visitar?");
        dialog.setContentText("Elige:");
        
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            estadoLabel.setText("Visitando " + result.get());
        }
        
    }

    @FXML
    private void facebookButtonClicked(ActionEvent event) {
        
        TextInputDialog dialog = new TextInputDialog("Pepe");
        dialog.setTitle("Introduce tu nombre");
        dialog.setHeaderText("¿Con qué usuario quieres escribir en Facebook?");
        dialog.setContentText("Introduce tu nombre:");
        
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            estadoLabel.setText("Mensaje eviado como " + result.get());
        }
    }

    @FXML
    private void googleButtonClicked(ActionEvent event) {
    }

    
}
