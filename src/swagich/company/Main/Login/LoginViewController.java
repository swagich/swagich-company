/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Main.Login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import swagich.company.DBConnection.DBConnection;
import swagich.company.Main.MainApp;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class LoginViewController implements Initializable {

    @FXML
    private JFXTextField authField;
    @FXML
    private JFXPasswordField pwdField;

    /**
     * Initializes the controller class.
     */
    public static Connection con;
    public static Statement stmt;
    public static String auth_code, pass, Auth_codeField, passField;
    public static ResultSet rs;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat cf = new SimpleDateFormat("HH:mm");

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void updateRecord() {
        try {
            
            
            con = DBConnection.connect();
            Date date = new Date();
            PreparedStatement ps2 = con.prepareStatement("insert into attendance_form(Auth_code,Reporting_date,Reporting_time)"
                    + "values(?,?,?)");

            System.out.println(authField.getText());
            ps2.setString(1, authField.getText());
            ps2.setString(2, df.format(date));
            ps2.setString(3, cf.format(date));

            ps2.execute();
            System.out.println("done");

            TrayNotification tray = new TrayNotification();
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.setTitle("Login success");
            tray.setMessage("Thank you signing in.You may now proceed to your respective duty");
            tray.setAnimationType(AnimationType.SLIDE);
            tray.showAndDismiss(Duration.millis(1500));
            AudioClip au = new AudioClip(MainApp.class.getResource("Audio/Notify.wav").toString());
            au.play();

        } catch (SQLException ex) {
            System.out.println("Record not updated");
        }finally{
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @FXML
    private void checkin(ActionEvent event) {
        Date date = new Date();

        try {
            con = DBConnection.connect();
            PreparedStatement ps = con.prepareStatement("select * from employee_data where Auth_code = ? and password = ?");
            System.out.println(authField.getText() + pwdField.getText());
            ps.setString(1, authField.getText());
            ps.setString(2, pwdField.getText());
            ResultSet result = ps.executeQuery();

            if (result.next()) {

                updateRecord();

            } else {
                Alert nm = new Alert(AlertType.ERROR);

                nm.setHeaderText(null);
                nm.setTitle("Authentification error");
                nm.setHeaderText(null);
                nm.setContentText("The authentification code or password you entered do not match any in the database."
                        + "Please ensure that you have registered on the employee registration section.Please visit the admin if this warning is persistent.");

                nm.initStyle(StageStyle.UTILITY);
                nm.initModality(Modality.APPLICATION_MODAL);
                nm.showAndWait();

            }

        } catch (SQLException se) {
            se.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
