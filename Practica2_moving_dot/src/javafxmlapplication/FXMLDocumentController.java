/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import static java.lang.Math.max;
import static java.lang.Math.min;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import static javafxmlapplication.Utils.*;


public class FXMLDocumentController implements Initializable {
    @FXML
    private Circle mainCircle;
    @FXML
    private GridPane boardGridPane;
    
    @FXML
    private ToggleButton toggleButton;
    @FXML
    private Slider sizeSlider;
    @FXML
    private ColorPicker colorPicker;
    
    private double initialX, initialY;
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void keyPressed(KeyEvent event) {
        
        KeyCode key = event.getCode();
        int currentRow = boardGridPane.getRowIndex(mainCircle);
        int currentColumn = boardGridPane.getColumnIndex(mainCircle);
        
        switch(key) {
            case UP: 
                moveUp(currentRow, currentColumn);
                break;
            case W:
                moveUp(currentRow, currentColumn);
                break;
            case RIGHT:
                moveRight(currentRow, currentColumn);
                break;
            case D:
                moveRight(currentRow, currentColumn);
                break;
            case DOWN:
                moveDown(currentRow, currentColumn);
                break;
            case S:
                moveDown(currentRow, currentColumn);
                break;
            case LEFT:
                moveLeft(currentRow, currentColumn);
                break;
            case A:
                moveLeft(currentRow, currentColumn);
                break;
        }
    }
    
    public void moveUp(int currentRow, int currentColumn) {
        int newRow = rowNorm(boardGridPane, currentRow - 1);
        boardGridPane.setRowIndex(mainCircle, newRow);
    }
    public void moveRight(int currentRow, int currentColumn) {
        int newColumn = columnNorm(boardGridPane, currentColumn + 1);
        boardGridPane.setColumnIndex(mainCircle, newColumn);
    }
    public void moveDown(int currentRow, int currentColumn) {
        int newRow = rowNorm(boardGridPane, currentRow + 1);
        boardGridPane.setRowIndex(mainCircle, newRow);
    }
    public void moveLeft(int currentRow, int currentColumn) {
        int newColumn = columnNorm(boardGridPane, currentColumn - 1);
        boardGridPane.setColumnIndex(mainCircle, newColumn);

    }

    @FXML
    private void mouseClicked(MouseEvent event) {
        
        double x = event.getSceneX();
        double y = event.getSceneY();
        
        int newRow = rowCalc(boardGridPane, y);
        int newColumn = columnCalc(boardGridPane, x);
        
        if (newRow >= boardGridPane.getRowCount()) {
            newRow = boardGridPane.getRowCount() - 1;
        }
        if (newColumn >= boardGridPane.getColumnCount()) {
            newColumn = boardGridPane.getColumnCount() - 1;
        }
        
        boardGridPane.setConstraints(mainCircle, newColumn, newRow);
    }

    @FXML
    private void mousePressed(MouseEvent event) {
        initialX = event.getSceneX();
        initialY = event.getSceneY();
    }
    
    @FXML
    private void mouseDragged(MouseEvent event) {
        mainCircle.setTranslateX(event.getSceneX() - initialX);
        mainCircle.setTranslateY(event.getSceneY() - initialY);
    }
    @FXML
    private void mouseReleased(MouseEvent event) {
        mainCircle.setTranslateX(0);
        mainCircle.setTranslateY(0);
        event.consume();
    }

    @FXML
    private void toggleButtonPressed(ActionEvent event) {
        
        actualizeColors();
    }

    @FXML
    private void sliderMouseDragged(MouseEvent event) {
        double value = sizeSlider.getValue();
        mainCircle.setRadius(value);
        mainCircle.requestFocus();
    }

    @FXML
    private void sliderMouseClicked(MouseEvent event) {
        double value = sizeSlider.getValue();
        mainCircle.setRadius(value);
        mainCircle.requestFocus();
    }

    @FXML
    private void sliderScolled(ScrollEvent event) {
        
        double mouseScroll = event.getDeltaY();
        double value = sizeSlider.getValue();
        
        if (mouseScroll > 0) {
            sizeSlider.setValue(min(value + 5, 25));
            mainCircle.setRadius(min(value + 5, 25));
        } else {
            sizeSlider.setValue(max(value - 5, 5));
            mainCircle.setRadius(max(value - 5, 5));
        }
    }

    @FXML
    private void colorSelected(ActionEvent event) {
        actualizeColors();
    }
    
    private void actualizeColors() {
        if (toggleButton.isSelected()) {
            mainCircle.setFill(Color.TRANSPARENT);
            mainCircle.setStroke(colorPicker.getValue());
        } else {
            mainCircle.setFill(colorPicker.getValue());
            mainCircle.setStroke(Color.BLACK);
        }
    }

    

    
}
