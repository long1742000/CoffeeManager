/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class UtilDB {
    private Connection conn;

    public UtilDB() {
    }

    public UtilDB(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public void connect(){
        if(conn==null){
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=CoffeeShopManagement;user=sa;password=123";
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn=DriverManager.getConnection(dbURL);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public void disconnect(){
        if(conn!=null){
            try{
                conn.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error disconnect: "+ex);
            }
        }
    }
}
