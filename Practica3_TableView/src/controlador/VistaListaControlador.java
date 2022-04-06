package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import modelo.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListCell;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VistaListaControlador implements Initializable {
	
	
    
    @FXML private TextField textFieldfxID;
    @FXML private TextField textFieldApellidofxID;

    @FXML private Button BAddfxID;
    @FXML private Button BBorrarfxID;
    @FXML
    private Button BModifyfxID;
    @FXML
    private TableView<Persona> tableView;
    @FXML
    private TableColumn<Persona, String> lastNameColumn;
    @FXML
    private TableColumn<Persona, String> firstNameColumn;
    
    private ObservableList<Persona> misPersonas;
    
    @FXML void addAccion(ActionEvent event) {
        // añade a la colección si los campos no son vacíos y no contienen únicamente blancos
//         if ((!textFieldfxID.getText().isEmpty())
//        	&& (textFieldfxID.getText().trim().length()!=0)
//        	&& (!textFieldApellidofxID.getText().isEmpty())
//        	&& (textFieldApellidofxID.getText().trim().length()!=0))
//         { 
//           misPersonas.add(new Persona(textFieldfxID.getText(),textFieldApellidofxID.getText()));
//           textFieldfxID.clear();
//           textFieldApellidofxID.clear();
//           textFieldfxID.requestFocus();  //cambio del foco al textfield.
//        	 
//         } 
    }

    @FXML void borrarAccion(ActionEvent event) {
    }
	
	

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

            // en el código de inicialización del controlador


            // TODO Auto-generated method stub
            ArrayList<Persona> misdatos = new ArrayList<Persona>();
            misdatos.add(new Persona("Pepe", "García", "path"));
            misdatos.add(new Persona("María", "Pérez", "path"));
            misPersonas = FXCollections.observableArrayList(misdatos);

            // ========= added code ========


            // inhabilitar botones al arrancar.
            BAddfxID.setDisable(true);
            BBorrarfxID.setDisable(true);
            // oyente de foco para el textfield.
            textFieldfxID.focusedProperty().addListener((ObservableValue<? extends Boolean> arg2, Boolean antiguo, Boolean nuevo) -> {
                // TODO Auto-generated method stub
                if (textFieldfxID.isFocused()) {
                    BAddfxID.setDisable(false);
                    BBorrarfxID.setDisable(true);
                }
            });

            // oyente de foco para el listView

        // =========== TableView ==========
        
        // define value which goes into the column
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Persona, String>("Apellidos"));
        
        // initialize table with data
        tableView.setItems(misPersonas);
        
        // define titles of the columns
        firstNameColumn.textProperty().set("Nombre");   
        lastNameColumn.textProperty().set("Apellidos");
    }
    // initialize ends here

    @FXML
    private void modifyAction(ActionEvent event) throws IOException {
        
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/vista/DatosPersona.fxml"));
        Parent root = myLoader.load();
        
        DatosPersonaController controladorPersona = myLoader.getController();
        
        Scene scene = new Scene(root, 400, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Ver datos persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        
    }
    
    class PersonListCell extends ListCell<Persona>
    {
        @Override
        protected void updateItem(Persona item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
            } else {
                setText(item.getNombre() + ", " + item.getApellidos());
            }
        }
    }



        
        
}
