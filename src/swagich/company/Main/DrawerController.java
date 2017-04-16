/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Main;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class DrawerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXButton exit;

    @FXML
    private JFXButton admin;

    @FXML
    private JFXButton register;

    @FXML
    private JFXButton attendance;

    @FXML
    private JFXButton report;

    @FXML
    public void close(ActionEvent ae) {
        System.exit(0);
    }
    
    

   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
