/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dish;
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
public class DishDAO {
    private UtilDB utilDB;
    
    public DishDAO() {
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    public ArrayList<Dish> getAllDish(){
        ArrayList listDish = new ArrayList();
        try { 
            String sql = "select * from Dish";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                Dish dish = new Dish();
                dish.setID(rs.getInt("ID"));
                dish.setCategoryID(rs.getInt("CategoryID"));
                dish.setName(rs.getString("Name"));
                dish.setDetail(rs.getString("Detail"));
                dish.setStatus(rs.getBoolean("Status"));
                listDish.add(dish);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDish;
    }
    
    public ArrayList<Dish> getByCategoryID(int id){
        ArrayList<Dish> dishCategory = new ArrayList();
        String sql = "select * from Dish where CategoryID="+id;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Dish dish = new Dish();
                dish.setID(rs.getInt("ID"));
                dish.setCategoryID(rs.getInt("CategoryID"));
                dish.setName(rs.getString("Name"));
                dish.setDetail(rs.getString("Detail"));
                dish.setStatus(rs.getBoolean("Status"));
                dishCategory.add(dish);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dishCategory;
    }
    
    public Dish getById(int id){
        String sql = "Select * from Dish where ID="+id;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Dish dish = new Dish();
                dish.setID(rs.getInt("ID"));
                dish.setCategoryID(rs.getInt("CategoryID"));
                dish.setName(rs.getString("Name"));
                dish.setDetail(rs.getString("Detail"));
                dish.setStatus(rs.getBoolean("Status"));
                return dish;           
           }   
        }
        catch(SQLException ex){
                 Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
}
