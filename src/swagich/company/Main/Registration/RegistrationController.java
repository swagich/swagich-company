/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Main.Registration;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
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
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class RegistrationController implements Initializable {

    @FXML
    private JFXTextField fName;
    @FXML
    private JFXTextField lName;
    @FXML
    private JFXTextField idNo;
    @FXML
    private JFXTextField pNumber;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField pwd1;
    @FXML
    private JFXPasswordField pwd2;
    @FXML
    private JFXButton registerBtn;

    public static Connection con;
    public static Statement stmt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swagich_workers_form?zeroDateTimeBehavior=convertToNull&useSSL=false", "root", "mySQL");
        }catch(SQLException ex){
            System.out.println("DB connect error !");
        }finally{
           
        }
    }

    @FXML
    private void registerEmployee(ActionEvent event) {
        if(fName.getText().length()==0||lName.getText().length()==0||idNo.getText().length()==0|| pNumber.getText().length()==0||
            email.getText().length()==0|| pwd1.getText().length()==0|| pwd2.getText().length()==0){
        
                Alert missingFields = new Alert(AlertType.ERROR);
                missingFields.setTitle("Missing fields error");
                missingFields.setHeaderText(null);
                missingFields.setContentText("Please ensure that you have provided all information in the available fields");
                missingFields.initModality(Modality.APPLICATION_MODAL);
                missingFields.showAndWait();
                return;
                
            } 
        if (pwd1.getText().equals(pwd2.getText())) {
                try {
                    DecimalFormat dc = new DecimalFormat("####.####");
                    DecimalFormat dc2 = new DecimalFormat("####");
                    dc.setRoundingMode(RoundingMode.DOWN);
                    dc2.setRoundingMode(RoundingMode.DOWN);

                    double sq1 = Math.sqrt(Integer.parseInt(idNo.getText()));
                  
                    String sq1String = dc.format(sq1);
                    String sq1String2 = dc2.format(sq1);
                    double sq1Decimal = Double.parseDouble(sq1String);
                    double sq1whole = Double.parseDouble(sq1String2);
                    System.out.println(sq1Decimal+" "+sq1whole);
                    double diff = (sq1Decimal - sq1whole) * 10000;

                    String Auth = "AUTH" + dc2.format(diff);

                    PreparedStatement ps = con.prepareStatement("insert into employee_data(phone_number,email,Employee_name,id_number,Auth_code,Signup_date,Signup_time,password)"
                            + "values(?,?,?,?,?,?,?,?)");
                    ps.setInt(1, Integer.parseInt(pNumber.getText()));
                    ps.setString(2, email.getText());
                    ps.setString(3, fName.getText() + " " + lName.getText());
                    ps.setInt(4, Integer.parseInt(idNo.getText()));
                    System.out.println(Auth);
                    ps.setString(5, Auth);
                    Date date = new Date();
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    DateFormat cf = new SimpleDateFormat("HH:mm");
                    ps.setString(6, df.format(date));
                    ps.setString(7, cf.format(date));
                    ps.setString(8, pwd1.getText());
                    ps.execute();
                    System.out.println("Record added to database !");
                    fName.setText("");
                    lName.setText("");
                    email.setText("");
                    idNo.setText("");
                    pwd1.setText("");
                    pwd2.setText("");
                    pNumber.setText("");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                
            } else {
             Alert PwdError = new Alert(AlertType.ERROR);
                PwdError.setTitle("Mismatch password error");
                PwdError.setHeaderText(null);
                PwdError.setContentText("Please use the same password in the password fields");
                PwdError.initModality(Modality.APPLICATION_MODAL);
                PwdError.showAndWait();

            }

        }

    }

