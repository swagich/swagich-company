/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Main.Admin.Login.MainView.Employees;

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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import swagich.company.DBConnection.DBConnection;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class AdminController implements Initializable {

    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement prep;
    private static ObservableList<EmployeeData> data;
    
    @FXML
    private TableView table;
    @FXML
    TableColumn namec;

    @FXML
    private TableColumn phonec;

    @FXML
    private TableColumn idc;

    @FXML
    private TableColumn authc;

    @FXML
    private TableColumn datec;

    @FXML
    private TableColumn timec;

    @FXML
    private TableColumn emailc;
    
    //AdminView is the table view containing the employee details
    //admin controller populates the table view AdminView

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            con = DBConnection.connect();
            data = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("select * from swagich_workers_form.employee_data");
            while (rs.next()) {
                data.add(new EmployeeData(rs.getString("Employee_name"), rs.getString("phone_number"), rs.getString("Auth_code"),
                        rs.getString("id_number"), rs.getString("email"), rs.getString("Signup_date"), rs.getString("Signup_time")));
            }
            namec.setCellValueFactory(new PropertyValueFactory("Employee_name"));
            phonec.setCellValueFactory(new PropertyValueFactory("phone_number"));
            idc.setCellValueFactory(new PropertyValueFactory("id_number"));
            authc.setCellValueFactory(new PropertyValueFactory("Auth_code"));
            datec.setCellValueFactory(new PropertyValueFactory("Signup_date"));
            timec.setCellValueFactory(new PropertyValueFactory("Signup_time"));
            emailc.setCellValueFactory(new PropertyValueFactory("email"));
            
            table.setItems(null);
            table.setItems(data);

        } catch (SQLException se) {
            System.out.println("Connection not established");
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static class EmployeeData {

        private StringProperty Employee_name;
        private StringProperty phone_number;
        private StringProperty Auth_code;
        private StringProperty id_number;
        private StringProperty email;
        private StringProperty Signup_date;
        private StringProperty Signup_time;

        private EmployeeData(String Employee_name, String phone_number, String Auth_code,
                String id_number, String email, String Signup_date, String Signup_time) {
            this.Employee_name = new SimpleStringProperty(Employee_name);
            this.phone_number = new SimpleStringProperty(phone_number);
            this.Auth_code = new SimpleStringProperty(Auth_code);
            this.id_number = new SimpleStringProperty(id_number);
            this.email = new SimpleStringProperty(email);
            this.Signup_date = new SimpleStringProperty(Signup_date);
            this.Signup_time = new SimpleStringProperty(Signup_time);
        }

        public StringProperty Employee_nameProperty() {
            return Employee_name;
        }

        public StringProperty phone_numberProperty() {
            return phone_number;
        }

        public StringProperty Auth_codeProperty() {
            return Auth_code;
        }

        public StringProperty id_numberProperty() {
            return id_number;
        }

        public StringProperty emailProperty() {
            return email;
        }

        public StringProperty Signup_dateProperty() {
            return Signup_date;
        }

        public StringProperty Signup_timeProperty() {
            return Signup_time;
        }

    }

}
