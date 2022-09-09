/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MemberType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class MemberTypeDAO {
    private UtilDB utilDB;
    
    public MemberTypeDAO(){
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    public ArrayList<MemberType> getAll(){
        ArrayList<MemberType> list = new ArrayList<MemberType>();
        try{
            String query="Select * from MemberType";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                MemberType item = new MemberType();
                item.setID(rs.getInt("ID"));
                item.setName(rs.getString("Name"));
                item.setDiscount(rs.getInt("Discount"));
                list.add(item);
            }
        }
        catch(SQLException ex){
                 Logger.getLogger(MemberTypeDAO.class.getName()).log(Level.SEVERE, null, ex);   
            }
        return list;
    }
    
    public MemberType getById(int id){
        String sql = "Select * from MemberType where ID="+id;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                MemberType item = new MemberType();
                item.setID(rs.getInt("ID"));
                item.setName(rs.getString("Name"));
                item.setDiscount(rs.getInt("Discount"));
                return item;           
           }   
        }
        catch(SQLException ex){
                 Logger.getLogger(MemberTypeDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
}
