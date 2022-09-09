/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import java.sql.PreparedStatement;
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
public class ProductDAO {
    private UtilDB utilDB;
    
    public ProductDAO() {
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    public ArrayList<Product> getAllDish(){
        ArrayList listProduct = new ArrayList();
        try { 
            String sql = "select * from Product";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                Product product = new Product();
                product.setID(rs.getInt("ID"));
                product.setDishID(rs.getInt("DishID"));
                product.setPrice(rs.getInt("Price"));
                product.setSizeID(rs.getInt("SizeID"));
                product.setPoints(rs.getInt("Points"));
                product.setStatus(rs.getBoolean("Status"));
                DishDAO dishDAO = new DishDAO();
                product.setDish(dishDAO.getById(product.getDishID()));
                SizeDAO sizeDAO = new SizeDAO();
                product.setSize(sizeDAO.getbyID(product.getSizeID()));
                listProduct.add(product);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    }
    
    public ArrayList<Product> getByCategoryID(int id){
        ArrayList<Product> dishCategory = new ArrayList();
        String sql = "select * from Product where CategoryID="+id;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Product product = new Product();
                product.setID(rs.getInt("ID"));
                product.setDishID(rs.getInt("DishID"));
                product.setPrice(rs.getInt("Price"));
                product.setSizeID(rs.getInt("SizeID"));
                product.setPoints(rs.getInt("Points"));
                product.setStatus(rs.getBoolean("Status"));
                DishDAO dishDAO = new DishDAO();
                product.setDish(dishDAO.getById(product.getDishID()));
                SizeDAO sizeDAO = new SizeDAO();
                product.setSize(sizeDAO.getbyID(product.getSizeID()));
                dishCategory.add(product);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dishCategory;
    }
    
    public Product getbyID(int id){
        String sql = "Select * from Product where ID ="+id;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Product product = new Product();
                product.setID(rs.getInt("ID"));
                product.setDishID(rs.getInt("DishID"));
                product.setPrice(rs.getInt("Price"));
                product.setSizeID(rs.getInt("SizeID"));
                product.setPoints(rs.getInt("Points"));
                product.setStatus(rs.getBoolean("Status"));
                DishDAO dishDAO = new DishDAO();
                product.setDish(dishDAO.getById(product.getDishID()));
                SizeDAO sizeDAO = new SizeDAO();
                product.setSize(sizeDAO.getbyID(product.getSizeID())); 
                return product;           
           }
        }
        catch(SQLException ex){
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
    
    // lấy sản phẩm theo Dish ID
    public Product getbyDishID(int id){
        String sql = "Select * from Product where DishID ="+id;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Product product = new Product();
                product.setID(rs.getInt("ID"));
                product.setDishID(rs.getInt("DishID"));
                product.setPrice(rs.getInt("Price"));
                product.setSizeID(rs.getInt("SizeID"));
                product.setPoints(rs.getInt("Points"));
                product.setStatus(rs.getBoolean("Status"));
                DishDAO dishDAO = new DishDAO();
                product.setDish(dishDAO.getById(product.getDishID()));
                SizeDAO sizeDAO = new SizeDAO();
                product.setSize(sizeDAO.getbyID(product.getSizeID())); 
                return product;           
           }
        }
        catch(SQLException ex){
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
    
    // lấy sản phẩm theo Size ID
    public Product getBySize(int id, int s){
        String sql = "Select * from Product where DishID ="+id+"and SizeID ="+s;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Product product = new Product();
                product.setID(rs.getInt("ID"));
                product.setDishID(rs.getInt("DishID"));
                product.setPrice(rs.getInt("Price"));
                product.setPoints(rs.getInt("Points"));
                product.setSizeID(rs.getInt("SizeID"));
                product.setStatus(rs.getBoolean("Status"));
                DishDAO dishDAO = new DishDAO();
                product.setDish(dishDAO.getById(product.getDishID()));
                SizeDAO sizeDAO = new SizeDAO();
                product.setSize(sizeDAO.getbyID(product.getSizeID()));
                return product;           
           }
        }
        catch(SQLException ex){
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
}
