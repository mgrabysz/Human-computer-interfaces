/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class FXMLDocumentController implements Initializable {
    private Label labelMessage;
    @FXML
    private TextField screenTextField;
    @FXML
    private Button num7button;
    @FXML
    private Button divisionButton;
    @FXML
    private Button multiplicationButton;
    @FXML
    private Button num9button;
    @FXML
    private Button num8button;
    @FXML
    private Button additionButton;
    @FXML
    private Button cButton;
    @FXML
    private Button num4button;
    @FXML
    private Button num5button;
    @FXML
    private Button num6cbutton;
    @FXML
    private Button num1button;
    @FXML
    private Button num2button;
    @FXML
    private Button num3button;
    @FXML
    private Button num0button;
    @FXML
    private Button dotButton;
    @FXML
    private Button equalsButton;
    
    private double inMemory;   
    private String operation;
     
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void appendTextField(String symbol) {
        
        String oldText = screenTextField.getText();
        
        // if textField displays "0" it should be substituded, not appended
        if (oldText.equals("0")) {
            oldText = "";
        }
        screenTextField.setText(oldText + symbol);
    }
    
    private double storeTextField() {
        String text = screenTextField.getText(); 
        screenTextField.setText("0");
        return Double.valueOf(text);    
    }
    
    @FXML
    private void num0clicked(ActionEvent event) {
        appendTextField("0");
    }
    
    @FXML
    private void num1clicked(ActionEvent event) {
        appendTextField("1");
    }

    @FXML
    private void num2clicked(ActionEvent event) {
        appendTextField("2");
    }

    @FXML
    private void num3clicked(ActionEvent event) {
        appendTextField("3");
    }
    
    @FXML
    private void num4clicked(ActionEvent event) {
        appendTextField("4");
    }

    @FXML
    private void num5clicked(ActionEvent event) {
        appendTextField("5");
    }

    @FXML
    private void num6clicked(ActionEvent event) {
        appendTextField("6");
    }

    @FXML
    private void num7clicked(ActionEvent event) {
        appendTextField("7");
    }
    
    @FXML
    private void num8clicked(ActionEvent event) {
        appendTextField("8");
    }

    @FXML
    private void num9clicked(ActionEvent event) {
        appendTextField("9");
    }
    
    @FXML
    private void dotClicked(ActionEvent event) {
        String oldText = screenTextField.getText();
        screenTextField.setText(oldText + ".");
    }

    @FXML
    private void subtractionClicked(ActionEvent event) {
        operation = "subtract";
        inMemory = storeTextField();
    }

    @FXML
    private void divisionClicked(ActionEvent event) {
        operation = "divide";
        inMemory = storeTextField();
    }

    @FXML
    private void multiplicationClicked(ActionEvent event) {
        operation = "multiply";
        inMemory = storeTextField();
    }

    @FXML
    private void additionClicked(ActionEvent event) {
        operation = "add";
        inMemory = storeTextField();
    }

    @FXML
    private void cClicked(ActionEvent event) {
        inMemory = 0;
        screenTextField.setText("0");
        operation = "";
    }

    @FXML
    private void equalsClicked(ActionEvent event) {
        
        double temp = storeTextField();
        
        switch(operation) {
            case "subtract":
                inMemory = inMemory - temp;
                break;
            case "divide":
                inMemory = inMemory / temp;
                break;
            case "multiply":
                inMemory = inMemory * temp;
                break;
            case "add":
                inMemory = inMemory + temp;
                break;
            default:
                inMemory = 0;
        }
        
        screenTextField.setText(Double.toString(inMemory));
        operation = "";
    }
    
}
