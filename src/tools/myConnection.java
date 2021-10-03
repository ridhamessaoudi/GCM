/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author loulwa
 */
public class myConnection {
    static Connection cnx;
    static Statement st;
    static ResultSet rst;
    
    //initialisation of the database
    public static Connection connecterDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver oki");
            String url = "jdbc:mysql://127.0.0.1:3306/cabinetmedicaldb";
            String user = "root";
            String password = "";
            Connection cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion bien établié");
            return cnx;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(myConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //requete de login 
    static public ResultSet loadListForLogin(String database,String nom, String passowrd) {

        try {
             if(cnx==null){
                cnx = connecterDB();
            }
            st = cnx.createStatement();
            String myQuery = "select * from "+database+" where username ='" + nom + "' and pw='" + passowrd + "'";
            rst = st.executeQuery(myQuery);
        } catch (SQLException ex) {
            Logger.getLogger(myConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }
    
}
