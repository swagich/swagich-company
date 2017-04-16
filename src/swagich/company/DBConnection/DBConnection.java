/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sam
 */

public class DBConnection {
  public static Connection con;
  
  public static Connection connect(){
      try {
          
          //Change connection settings as per your mysql configuration
          //Then after changing the connection settings you can run the InsertDummyData.java
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swagich_test?zeroDateTimeBehavior=convertToNull","root","mySQL");
      } catch (SQLException ex) {
          System.out.println("Error connecting to database");
      }
      return con;
    
}
    
    
}
