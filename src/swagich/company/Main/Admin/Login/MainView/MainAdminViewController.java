/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Main.Admin.Login.MainView;

import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import swagich.company.Main.Admin.Login.AdminLoginController;
import swagich.company.Main.MainApp;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class MainAdminViewController implements Initializable {

    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane dynamicPane;
    @FXML
    AnchorPane repPane;
    @FXML
    Label label;
    AnchorPane employeeData, attendanceData, mainApp;
    VBox sidePane;

    @FXML
    public void showDrawer(MouseEvent me) {
        if (!drawer.isShown()) {
            drawer.open();
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            //sidePane is adminDrawer
            mainApp = FXMLLoader.load(MainApp.class.getResource("MainAppView.fxml"));
            sidePane = FXMLLoader.load(getClass().getResource("adminDrawer.fxml"));
            employeeData = FXMLLoader.load(getClass().getResource("Employees/AdminView.fxml"));
            attendanceData = FXMLLoader.load(getClass().getResource("Attendance/AttendanceView.fxml"));
            drawer.setSidePane(sidePane);
            drawer.open();

            for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {

                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            System.out.println(node.getAccessibleText());

                            switch (node.getAccessibleText()) {
                                case ("employeeRecords"):
                                    label.setText("EMPLOYEE DATA ");
                                    repPane.getChildren().clear();
                                    repPane.getChildren().add((Node) employeeData);
                                    break;
                                case ("attendanceSheet"):
                                    label.setText("ATTENDANCE SHEET");
                                    repPane.getChildren().clear();
                                    repPane.getChildren().add(attendanceData);
                                    break;
                                case ("mainApp"):
                                    Image image=new Image(AdminLoginController.class.getResourceAsStream("company2.png"));
                                    Stage mainStage = new Stage();
                                    Scene scene = new Scene(mainApp);
                                    mainStage.setScene(scene);
                                    repPane.getScene().getWindow().hide();
                                    mainStage.getIcons().add(image);
                                    mainStage.show();
                                    break;
                                case ("exit"):
                                    System.exit(0);
                                    break;

                            }
                        }
                    });
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
