/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.SaleAllDay;
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
public class SaleAllDayDAO {
    private UtilDB utilDB;
    
    public SaleAllDayDAO() {
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    public ArrayList<SaleAllDay> getAll(){
        ArrayList listBill = new ArrayList();
        try { 
            String sql = "select * from SaleAllDay where Status=1 order by DateCreate desc";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                SaleAllDay sale = new SaleAllDay();
                sale.setID(rs.getInt("ID"));
                sale.setEmployeeID(rs.getInt("EmployeeID"));
                sale.setShift(rs.getInt("Shift"));
                sale.setDateCreate(rs.getDate("DateCreate"));
                sale.setCash(rs.getInt("Cash"));
                sale.setMomo(rs.getInt("Momo"));
                sale.setVNPay(rs.getInt("VNPay"));
                sale.setDiscount(rs.getInt("Discount"));
                sale.setTotal(rs.getInt("Total"));
                sale.setStatus(rs.getBoolean("Status"));
                EmployeeDAO employeeDAO = new EmployeeDAO();
                sale.setEmployee(employeeDAO.getByID(sale.getEmployeeID()));
                listBill.add(sale);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(SaleAllDayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBill;
    }
    
    public SaleAllDay getByID(int id){
        String sql = "Select * from SaleAllDay where ID="+id;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                SaleAllDay sale = new SaleAllDay();
                sale.setID(rs.getInt("ID"));
                sale.setEmployeeID(rs.getInt("EmployeeID"));
                sale.setShift(rs.getInt("Shift"));
                sale.setDateCreate(rs.getDate("DateCreate"));
                sale.setCash(rs.getInt("Cash"));
                sale.setMomo(rs.getInt("Momo"));
                sale.setVNPay(rs.getInt("VNPay"));
                sale.setDiscount(rs.getInt("Discount"));
                sale.setTotal(rs.getInt("Total"));
                sale.setStatus(rs.getBoolean("Status"));
                EmployeeDAO employeeDAO = new EmployeeDAO();
                sale.setEmployee(employeeDAO.getByID(sale.getEmployeeID()));
                return sale;           
           }   
        }
        catch(SQLException ex){
                 Logger.getLogger(SaleAllDayDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
    
    public SaleAllDay getNew(){
        String sql = "select * from SaleAllDay order by ID desc";
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                SaleAllDay sale = new SaleAllDay();
                sale.setID(rs.getInt("ID"));
                sale.setEmployeeID(rs.getInt("EmployeeID"));
                sale.setShift(rs.getInt("Shift"));
                sale.setDateCreate(rs.getDate("DateCreate"));
                sale.setCash(rs.getInt("Cash"));
                sale.setMomo(rs.getInt("Momo"));
                sale.setVNPay(rs.getInt("VNPay"));
                sale.setDiscount(rs.getInt("Discount"));
                sale.setTotal(rs.getInt("Total"));
                sale.setStatus(rs.getBoolean("Status"));
                EmployeeDAO employeeDAO = new EmployeeDAO();
                sale.setEmployee(employeeDAO.getByID(sale.getEmployeeID()));
                return sale;           
           }   
        }
        catch(SQLException ex){
                 Logger.getLogger(SaleAllDayDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
    
    // thêm dữ liệu vào bảng SaleAllDay
    public boolean print(SaleAllDay sale){
        String query="insert into SaleAllDay(EmployeeID, Shift, DateCreate, Cash, Momo, VNPay, Discount, Total, Status) values(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(query);
            pstm.setInt(1, sale.getEmployeeID());
            pstm.setInt(2, sale.getShift());      
            pstm.setDate(3, (java.sql.Date) sale.getDateCreate());  
            pstm.setInt(4, sale.getCash());         
            pstm.setInt(5, sale.getMomo());    
            pstm.setInt(6, sale.getVNPay());    
            pstm.setInt(7, sale.getDiscount());  
            pstm.setInt(8, sale.getTotal());  
            pstm.setBoolean(9, sale.isStatus());
            int result = pstm.executeUpdate();;
            if(result!=0){
                return true;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(SaleAllDayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
