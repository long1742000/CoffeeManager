/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Size;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class SizeDAO {
    private UtilDB utilDB;
    
    public SizeDAO() {
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    public Size getbyID(int id){
        String sql = "Select * from Size where ID ="+id;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Size size = new Size();
                size.setID(rs.getInt("ID"));
                size.setName(rs.getString("Name"));
                size.setStatus(rs.getBoolean("Status"));
                return size;           
           }
        }
        catch(SQLException ex){
            Logger.getLogger(SizeDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
}
