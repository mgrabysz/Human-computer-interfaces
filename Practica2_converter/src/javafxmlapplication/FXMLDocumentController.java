/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
    private Label labelMessage;
    @FXML
    private Label valueLabel;
    @FXML
    private TextField inputTextField;
    @FXML
    private TextField outputTextField;
    @FXML
    private CheckBox automaticConversionCheckBox;
    @FXML
    private Slider slider;
    
    private ChangeListener<String> inputListener = this::listenerOfInput;
    private ChangeListener<Number> sliderListener = this::listenerOfSlider;
    @FXML
    private Button convertButton;
    @FXML
    private Button clearButton;
       
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        valueLabel.textProperty().bind(Bindings.format("%.2f", slider.valueProperty()));
    }    

    @FXML
    private void automaticConversionClicked(ActionEvent event) {
        
        if (automaticConversionCheckBox.isSelected()) {
            inputTextField.textProperty().addListener(inputListener);
            slider.valueProperty().addListener(sliderListener);
        } else {
            inputTextField.textProperty().removeListener(inputListener);
            slider.valueProperty().removeListener(sliderListener);
        }
    }
    
    private void listenerOfInput(ObservableValue<? extends String> obs, String oldValue, String newValue) {
        
        if (newValue.equals("")) {
            outputTextField.setText("0,00");
        } else {
            double output = Double.valueOf(newValue) * slider.getValue();
            outputTextField.setText(String.format("%.2f", output));
        }
    }
    
    private void listenerOfSlider(ObservableValue<? extends Number> obs, Number oldValue, Number newValue) {
        double output = Double.parseDouble(inputTextField.getText()) * slider.getValue();
        outputTextField.setText(String.format("%.2f", output));
    }
    
}
