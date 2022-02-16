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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import static javafxmlapplication.Utils.*;

/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
    private Label labelMessage;
    @FXML
    private Circle mainCircle;
    @FXML
    private GridPane boardGridPane;
    
    //=========================================================
    // event handler, fired when button is clicked or 
    //                      when the button has the focus and enter is pressed
    private void handleButtonAction(ActionEvent event) {
        labelMessage.setText("Hello, this is your first JavaFX project - IPC");
    }
    
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
            case RIGHT:
                moveRight(currentRow, currentColumn);
                break;
            case DOWN:
                moveDown(currentRow, currentColumn);
                break;
            case LEFT:
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
        
        boardGridPane.setConstraints(mainCircle, newColumn, newRow);
    }
}
