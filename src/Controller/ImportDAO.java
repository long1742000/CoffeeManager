/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Import;
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
public class ImportDAO {
    private UtilDB utilDB;
    
    public ImportDAO() {
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    // Lấy All dữ liệu từ Import
    public ArrayList<Import> getAll(){
        ArrayList list = new ArrayList();
        try { 
            String sql = "select * from Import";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                Import imp = new Import();
                imp.setID(rs.getInt("ID"));
                imp.setEmployeeID(rs.getInt("EmployeeID"));
                imp.setDateCreate(rs.getDate("DateCreate"));
                EmployeeDAO empDAO = new EmployeeDAO();
                imp.setEmployee(empDAO.getByID(imp.getEmployeeID()));
                list.add(imp);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    // Thêm dữ liệu vào Import
    public boolean add(Import imp){
        String query="insert into Import(EmployeeID, DateCreate) values(?,?)";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(query);
            pstm.setInt(1, imp.getEmployeeID());   
            pstm.setDate(2, (java.sql.Date) imp.getDateCreate());   
            int result = pstm.executeUpdate();;
            if(result!=0){
                return true;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Import getByID(int id){
        String sql = "select * from Import where ID="+id;
        Statement stm;
        try {
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Import imp = new Import();
                imp.setID(rs.getInt("ID"));
                imp.setEmployeeID(rs.getInt("EmployeeID"));
                imp.setDateCreate(rs.getDate("DateCreate"));
                EmployeeDAO empDAO = new EmployeeDAO();
                imp.setEmployee(empDAO.getByID(imp.getEmployeeID()));
                return imp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    // Lấy cái Import mới nhất (Import vừa được tạo)
    public Import getNewImport(){
        String sql = "select top 1 * from Import order by ID desc";
        Statement stm;
        try {
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Import imp = new Import();
                imp.setID(rs.getInt("ID"));
                imp.setEmployeeID(rs.getInt("EmployeeID"));
                imp.setDateCreate(rs.getDate("DateCreate"));
                return imp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Import> getByDate(int year, int month, int day){
        ArrayList<Import> list = new ArrayList();
        String sql = " ";
        if(day==0){
            sql = "select * from Import where month(DateCreate) = "+month+" and year(DateCreate) ="+year+"order by DateCreate desc";
        }
        else{
            sql = "select * from Import where DateCreate = '"+year+"-"+month+"-"+day+"' order by DateCreate desc";
        }          
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Import imp = new Import();
                imp.setID(rs.getInt("ID"));
                imp.setEmployeeID(rs.getInt("EmployeeID"));
                imp.setDateCreate(rs.getDate("DateCreate"));
                EmployeeDAO empDAO = new EmployeeDAO();
                imp.setEmployee(empDAO.getByID(imp.getEmployeeID()));
                list.add(imp);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    // Search từ ngày này đến ngày kia
    public ArrayList<Import> getByDateBetween(int year1, int month1, int day1, int year2, int month2, int day2){
        ArrayList<Import> list = new ArrayList();
        String sql = "select * from Import where DateCreate between '"+year1+"-"+month1+"-"+day1+"' and '"+year2+"-"+month2+"-"+day2+"'";       
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Import imp = new Import();
                imp.setID(rs.getInt("ID"));
                imp.setEmployeeID(rs.getInt("EmployeeID"));
                imp.setDateCreate(rs.getDate("DateCreate"));
                EmployeeDAO empDAO = new EmployeeDAO();
                imp.setEmployee(empDAO.getByID(imp.getEmployeeID()));
                list.add(imp);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
