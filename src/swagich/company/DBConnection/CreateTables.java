/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sam
 */
public class CreateTables {

    public static void main(String[] args) {
        try {

            PreparedStatement ps0 = DBConnection.connect().prepareStatement("CREATE TABLE `admins` (\n"
                    + "  `Name` varchar(45) NOT NULL,\n"
                    + "  `Auth_code` varchar(8) NOT NULL,\n"
                    + "  `ID` varchar(10) DEFAULT NULL,\n"
                    + "  `Password` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`Auth_code`)\n"
                    + ")");
            ps0.executeUpdate();
            PreparedStatement ps1 = DBConnection.connect().prepareStatement("CREATE TABLE `attendance_form` (\n"
                    + "  `Auth_code` char(8) NOT NULL,\n"
                    + "  `Reporting_date` char(10) NOT NULL,\n"
                    + "  `Reporting_time` char(5) NOT NULL\n"
                    + ")");
            ps1.executeUpdate();
            PreparedStatement ps2 = DBConnection.connect().prepareStatement("CREATE TABLE `employee_data` (\n"
                    + "  `phone_number` int(11) NOT NULL,\n"
                    + "  `email` varchar(45) NOT NULL,\n"
                    + "  `Employee_name` varchar(50) NOT NULL,\n"
                    + "  `id_number` int(11) NOT NULL,\n"
                    + "  `Auth_code` char(8) NOT NULL,\n"
                    + "  `Signup_date` char(10) NOT NULL,\n"
                    + "  `Signup_time` char(5) NOT NULL,\n"
                    + "  `password` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`Auth_code`)\n"
                    + ")");
            ps2.executeUpdate();
            PreparedStatement ps3 = DBConnection.connect().prepareStatement("CREATE TABLE `roll_call` (\n"
                    + "  `AUTH` varchar(8) DEFAULT NULL,\n"
                    + "  `DATE` varchar(10) DEFAULT NULL,\n"
                    + "  `TIME` varchar(10) DEFAULT NULL\n"
                    + ")");
            ps3.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CreateTables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
