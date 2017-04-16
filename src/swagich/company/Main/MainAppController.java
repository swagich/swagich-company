/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Main;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class MainAppController implements Initializable {

    /**
     * Initializes the controller class.
     */
    VBox sidePane;
    @FXML
    private JFXHamburger ham;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXComboBox depCombo;
    @FXML
    private Label panel;
    TrayNotification tray;

    @FXML
    public void showDrawer(MouseEvent me) {
        if (!drawer.isShown()) {
            drawer.open();
        } else {
            drawer.isShown();
        }
    }

    @FXML
    public void hideDrawer(MouseEvent me) {
        drawer.close();
    }

    public void setNode(Node node) {
        /* AudioClip notifyMe = new AudioClip((getClass().getResource("Notify.wav")).toString());
        notifyMe.play();
         */
 /*
        tray = new TrayNotification();
        tray.setTitle("Congratulations");
        tray.setMessage("You have opened the form");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(1500));
         */
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        panel.setText("");

        try {
            sidePane = FXMLLoader.load(getClass().getResource("drawerView.fxml"));
            AnchorPane loginPane = FXMLLoader.load(getClass().getResource("Login/LoginView.fxml"));
            AnchorPane regPane = FXMLLoader.load(getClass().getResource("Registration/RegistrationView.fxml"));
            AnchorPane repPane = FXMLLoader.load(getClass().getResource("Report/ReportView.fxml"));
            AnchorPane adminLoginPane = FXMLLoader.load(getClass().getResource("Admin/Login/AdminLoginView.fxml"));
            drawer.setSidePane(sidePane);

            for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

                        switch (node.getAccessibleText()) {

                            case ("attendanceBtn"):
                                drawer.close();
                                panel.setText("LOGIN PANEL");
                                setNode(loginPane);
                                
                                break;
                            case ("adminBtn"):
                                drawer.close();
                                panel.setText("ADMIN PANEL");
                                setNode(adminLoginPane);
                                break;
                            case ("reportBtn"):
                                drawer.close();
                                panel.setText("REPORT CONCERN");
                                setNode(repPane);
                                break;
                            case ("registerBtn"):
                                drawer.close();
                                panel.setText("EMPLOYEE REGISTRATION");
                                setNode(regPane);
                                break;              
                            case ("exitBtn"):
                                System.exit(0);
                                break;

                        }
                    });
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /*  HamburgerSlideCloseTransition transition=new HamburgerSlideCloseTransition(ham);
        transition.setRate(-1);
        ham.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
         */
       

    }

}
