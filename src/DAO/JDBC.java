/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author gurum
 */
public abstract class JDBC {
    // Create connectors to communicate with the database
    protected Connection myconn;
    protected Statement mystm = null;
    protected PreparedStatement myprestm = null;
    protected ResultSet myres = null;
    
    // Connect with the database
    protected JDBC() throws SQLException{
        //prepare DB properties
        String url = "jdbc:mysql://localhost/storehouse?useLegacyDatetimeCode=false&serverTimezone=Asia/Bangkok";
        String user = "root";
        String pass = "css225";

        //connnect to DB
        myconn = DriverManager.getConnection(url, user, pass);
    }
}
