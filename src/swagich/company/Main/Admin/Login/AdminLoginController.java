/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Main.Admin.Login;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import swagich.company.DBConnection.DBConnection;
import swagich.company.Main.MainAppController;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class AdminLoginController implements Initializable {

    public static Connection con;
    public static Statement stmt;
    public static PreparedStatement prep;
    private MainAppController mc;
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField authField;

    @FXML
    private JFXPasswordField pwdField;

    @FXML
    private JFXButton loginBtn;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void loginCheck(ActionEvent ae) throws IOException {
        try {
            con = DBConnection.connect();
                  
            PreparedStatement ps = con.prepareStatement("select * from admins");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("Auth_code").equals(authField.getText())) {
                    if (rs.getString("Password").equals(pwdField.getText())) {
                        System.out.println("Login success!");
                        Parent root = FXMLLoader.load(AdminLoginController.class.getResource("MainView/MainAdminView.fxml"));
                        stage = new Stage();
                        Image icon = new Image(AdminLoginController.class.getResourceAsStream("company2.png"));
                        stage.getIcons().add(icon);
                        stage.setTitle("Admin Portal - Please obtain authorization before viewing this portal as admin");
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        loginBtn.getScene().getWindow().hide();
                        stage.show();
                        authField.setText(null);
                        pwdField.setText(null);

                    }
                }

            }
        } catch (SQLException ex) {
            System.out.println("SQL error! ");
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
      
    }

}
