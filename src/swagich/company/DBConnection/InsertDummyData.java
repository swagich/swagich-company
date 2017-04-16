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
 * Right click on this file > Run file 
 * Make sure you have already created a database connection for your mysql and provided
 * a valid url on DBConnection.java file and you have already created tables by running 
 * the CreateTables.java
 * After entering your data successfully you can run the program 
 */
public class InsertDummyData {

    public static void main(String[] args) {
        try {
            PreparedStatement ps0 = DBConnection.connect().prepareStatement("INSERT INTO `admins`\n"
                    + "(`Name`,\n"
                    + "`Auth_code`,\n"
                    + "`ID`,\n"
                    + "`Password`)\n"
                    + "VALUES\n"
                    + "(\"Sam Gichuru\",\n"
                    + "\"AUTH3945\",\n"
                    + "31532656,\n"
                    + "\"admins4423\")");
            ps0.execute();
            PreparedStatement ps1 = DBConnection.connect().prepareStatement("INSERT INTO `attendance_form`\n"
                    + "(`Auth_code`,\n"
                    + "`Reporting_date`,\n"
                    + "`Reporting_time`)\n"
                    + "VALUES\n"
                    + "(?,\n"
                    + "?,\n"
                    + "?);");

            ps1.setString(1, "AUTH4423");
            ps1.setString(2, "12/06/2016");
            ps1.setString(3, "22:51");
            ps1.execute();
            ps1.setString(1, "AUTH3945");
            ps1.setString(2, "12/06/2016");
            ps1.setString(3, "22:51");
            ps1.execute();
            ps1.setString(1, "AUTH3945");
            ps1.setString(2, "12/06/2016");
            ps1.setString(3, "22:51");
            ps1.execute();
            ps1.setString(1, "AUTH3945");
            ps1.setString(2, "12/06/2016");
            ps1.setString(3, "22:51");
            ps1.execute();
            ps1.setString(1, "AUTH3945");
            ps1.setString(2, "12/06/2016");
            ps1.setString(3, "22:51");
            ps1.execute();
            ps1.setString(1, "AUTH3945");
            ps1.setString(2, "12/06/2016");
            ps1.setString(3, "22:51");
            ps1.execute();
            ps1.setString(1, "AUTH3945");
            ps1.setString(2, "12/06/2016");
            ps1.setString(3, "22:51");
            ps1.execute();
            ps1.setString(1, "AUTH3945");
            ps1.setString(2, "12/06/2016");
            ps1.setString(3, "22:51");
            ps1.execute();
            ps1.setString(1, "AUTH4423");
            ps1.setString(2, "12/06/2016");
            ps1.setString(3, "22:51");
            ps1.execute();
            ps1.setString(1, "AUTH4423");
            ps1.setString(2, "12/06/2016");
            ps1.setString(3, "22:51");
            ps1.execute();

            PreparedStatement ps2 = DBConnection.connect().prepareStatement("INSERT INTO `employee_data`\n"
                    + "(`phone_number`,\n"
                    + "`email`,\n"
                    + "`Employee_name`,\n"
                    + "`id_number`,\n"
                    + "`Auth_code`,\n"
                    + "`Signup_date`,\n"
                    + "`Signup_time`,\n"
                    + "`password`)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?,?)");

            ps2.setInt(1, 71450124);
            ps2.setString(2, "samwani");
            ps2.setString(3, "sami@gmail.com");
            ps2.setInt(4, 315245156);
            ps2.setString(5, "AUTH1444");
            ps2.setString(6, "17/07/2016");
            ps2.setString(7, "18:30");
            ps2.setString(8, "sam");
            ps2.execute();

            ps2.setInt(1, 720450307);
            ps2.setString(2, "alice@email.com");
            ps2.setString(3, "Alice  Wainaina");
            ps2.setInt(4, 7328911);
            ps2.setString(5, "AUTH1961");
            ps2.setString(6, "21/07/2016");
            ps2.setString(7, "20:31");
            ps2.setString(8, "sam123");
            ps2.execute();

            ps2.setInt(1, 706523472);
            ps2.setString(2, "austin@gmail.com");
            ps2.setString(3, "Austin Ogutu");
            ps2.setInt(4, 31317743);
            ps2.setString(5, "AUTH2256");
            ps2.setString(6, "13/09/2016");
            ps2.setString(7, "13:17");
            ps2.setString(8, "sam123");
            ps2.execute();

            PreparedStatement ps3 = DBConnection.connect().prepareStatement("INSERT INTO `roll_call`\n" +
"(`AUTH`,\n" +
"`DATE`,\n" +
"`TIME`)\n" +
"VALUES\n" +
"(?,?,?);");
            ps3.setString(1,"AUTH3945");
            ps3.setString(2, "12:42");
            ps3.setString(3, "23/07/2016");
            ps3.execute();
            
            ps3.setString(1,"AUTH3945");
            ps3.setString(2, "12:42");
            ps3.setString(3, "23/07/2016");
            ps3.execute();

            
            
            

        } catch (SQLException ex) {
            Logger.getLogger(InsertDummyData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
