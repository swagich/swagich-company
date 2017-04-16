/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Main.Admin.Login.MainView.Attendance;

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
public class AttendanceController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TableView tableView;
    @FXML
    private TableColumn Auth_code;

    @FXML
    private TableColumn Reporting_date;

    @FXML
    private TableColumn Reporting_time;
    
    
    private static Connection con;
    private static Statement stmt;
    private PreparedStatement prep;
    private ObservableList<AttendanceData> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        con=DBConnection.connect();
        data=FXCollections.observableArrayList();
        ResultSet rs=con.createStatement().executeQuery("select * from swagich_workers_form.attendance_form");
        while (rs.next()){
            data.add(new AttendanceData(rs.getString("Auth_code"),rs.getString("Reporting_date"),rs.getString("Reporting_time")));
           
        }
        Auth_code.setCellValueFactory(new PropertyValueFactory("Auth_code"));
        Reporting_date.setCellValueFactory(new PropertyValueFactory("Reporting_date"));
        Reporting_time.setCellValueFactory(new PropertyValueFactory("Reporting_time"));
        
        tableView.setItems(null);
        tableView.setItems(data);
        
        
        }catch(SQLException se){
            System.out.println("Error connecting to database !");
        }finally{
            try {
                if(con != null){
                con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    public static class AttendanceData {
        private StringProperty Auth_code;
        private StringProperty Reporting_date;
        private StringProperty Reporting_time;

        private AttendanceData(String Auth_code, String Reporting_date ,String Reporting_time ) {
            this.Auth_code=new SimpleStringProperty(Auth_code);
            this.Reporting_date=new SimpleStringProperty(Reporting_date);
            this.Reporting_time=new SimpleStringProperty(Reporting_time);
            
        }
        public StringProperty Auth_codeProperty(){
            return Auth_code;
        }
        public StringProperty Reporting_dateProperty(){
            return Reporting_date;
        }
        public StringProperty Reporting_timeProperty(){
            return Reporting_time;
        }
    }
    
}
