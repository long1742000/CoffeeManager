/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bill;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author HP
 */
public class BillDAO {
    private UtilDB utilDB;
    
    public BillDAO() {
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    // lấy All dữ liệu từ Bill
    public ArrayList<Bill> getAll(){                                            // đoạn này lấy tất cả từ Bill vs Status = true và sắp xếp từ mới -> cũ
        ArrayList listBill = new ArrayList();
        try { 
            String sql = "select * from Bill where Status = 1 order by DateCreate desc";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                Bill bill = new Bill();
                bill.setID(rs.getInt("ID"));
                bill.setEmployeeID(rs.getInt("EmployeeID"));
                bill.setCustomerID(rs.getInt("CustomerID"));
                bill.setPaymentByID(rs.getInt("PaymentByID"));
                bill.setSaleAllDayID(rs.getInt("SaleAllDayID"));
                bill.setVoucherID(rs.getInt("VoucherID"));
                bill.setDateCreate(rs.getDate("DateCreate"));
                bill.setCode(rs.getInt("Code"));
                bill.setAmount(rs.getInt("Amount"));
                bill.setAddress(rs.getString("Address"));
                bill.setStatus(rs.getBoolean("Status"));
                EmployeeDAO empDAO = new EmployeeDAO();
                bill.setEmployee(empDAO.getByID(bill.getEmployeeID()));
                CustomerDAO cusDAO = new CustomerDAO();            
                bill.setCustomer(cusDAO.getById(bill.getCustomerID()));
                listBill.add(bill);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBill;
    }
    
    // Thêm dữ liệu vào Bill
    public boolean add(Bill bill){
        String query="insert into Bill(EmployeeID, CustomerID, PaymentByID, VoucherID, SaleAllDayID, Code, DateCreate, Amount, Address, Status) values(?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(query);
            pstm.setInt(1, bill.getEmployeeID());
            pstm.setInt(2, bill.getCustomerID());       
            pstm.setInt(3, bill.getPaymentByID());         
            pstm.setInt(4, bill.getVoucherID());  
            pstm.setInt(5, bill.getSaleAllDayID());
            pstm.setInt(6, bill.getCode());    
            pstm.setDate(7, (java.sql.Date) bill.getDateCreate());   
            pstm.setInt(8, bill.getAmount());  
            pstm.setString(9, bill.getAddress());  
            pstm.setBoolean(10, bill.isStatus());
            int result = pstm.executeUpdate();
            if(result!=0){
                return true;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // Lấy Bill theo Code, cái này mình chỉ lấy 1 cái Bill ra nên ko cần ArrayList
    public Bill getByCode(int code){
        String sql = "Select * from Bill where Code="+code;                 // chỗ này mình sẽ truyền code zô
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Bill bill = new Bill();
                bill.setID(rs.getInt("ID"));
                bill.setEmployeeID(rs.getInt("EmployeeID"));
                bill.setCustomerID(rs.getInt("CustomerID"));
                bill.setPaymentByID(rs.getInt("PaymentByID"));
                bill.setSaleAllDayID(rs.getInt("SaleAllDayID"));
                bill.setVoucherID(rs.getInt("VoucherID"));
                bill.setDateCreate(rs.getDate("DateCreate"));
                bill.setCode(rs.getInt("Code"));
                bill.setAmount(rs.getInt("Amount"));
                bill.setAddress(rs.getString("Address"));
                bill.setStatus(rs.getBoolean("Status"));
                EmployeeDAO empDAO = new EmployeeDAO();
                bill.setEmployee(empDAO.getByID(bill.getEmployeeID()));
                CustomerDAO cusDAO = new CustomerDAO();            
                bill.setCustomer(cusDAO.getById(bill.getCustomerID()));
                return bill;           
           }   
        }
        catch(SQLException ex){
                 Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
    
    public ArrayList<Bill> getBySaleAllDayID(int id){
        ArrayList listbill = new ArrayList();
        try { 
            String sql = "select * from Bill where SaleAllDayID="+id;
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                Bill bill = new Bill();
                bill.setID(rs.getInt("ID"));
                bill.setEmployeeID(rs.getInt("EmployeeID"));
                bill.setCustomerID(rs.getInt("CustomerID"));
                bill.setPaymentByID(rs.getInt("PaymentByID"));
                bill.setSaleAllDayID(rs.getInt("SaleAllDayID"));
                bill.setVoucherID(rs.getInt("VoucherID"));
                bill.setDateCreate(rs.getDate("DateCreate"));
                bill.setCode(rs.getInt("Code"));
                bill.setAmount(rs.getInt("Amount"));
                bill.setAddress(rs.getString("Address"));
                bill.setStatus(rs.getBoolean("Status"));
                EmployeeDAO empDAO = new EmployeeDAO();
                bill.setEmployee(empDAO.getByID(bill.getEmployeeID()));
                CustomerDAO cusDAO = new CustomerDAO();            
                bill.setCustomer(cusDAO.getById(bill.getCustomerID()));
                listbill.add(bill);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listbill;
    }
    
    // Search theo ngày tháng năm
    public ArrayList<Bill> getByDate(int year, int month, int day){
        ArrayList<Bill> list = new ArrayList();
        String sql = " ";
        if(day==0){
            sql = "select * from Bill where month(DateCreate) = "+month+" and year(DateCreate) ="+year+"order by DateCreate desc";
        }
        else{
            sql = "select * from Bill where DateCreate = '"+year+"-"+month+"-"+day+"' order by DateCreate desc";
        }          
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Bill bill = new Bill();
                bill.setID(rs.getInt("ID"));
                bill.setEmployeeID(rs.getInt("EmployeeID"));
                bill.setCustomerID(rs.getInt("CustomerID"));
                bill.setPaymentByID(rs.getInt("PaymentByID"));
                bill.setSaleAllDayID(rs.getInt("SaleAllDayID"));
                bill.setVoucherID(rs.getInt("VoucherID"));
                bill.setDateCreate(rs.getDate("DateCreate"));
                bill.setAmount(rs.getInt("Amount"));
                bill.setCode(rs.getInt("Code"));
                bill.setAddress(rs.getString("Address"));
                bill.setStatus(rs.getBoolean("Status"));
                EmployeeDAO empDAO = new EmployeeDAO();
                bill.setEmployee(empDAO.getByID(bill.getEmployeeID()));
                CustomerDAO cusDAO = new CustomerDAO();            
                bill.setCustomer(cusDAO.getById(bill.getCustomerID()));
                list.add(bill);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean negative(int billID){
        String sql="update Bill set Status=0 where ID=?";               
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(sql);
            pstm.setInt(1, billID);
            int rs = pstm.executeUpdate();
            if(rs!=0){
                return true;         
            }  
        }
        catch(SQLException ex){
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return false;  
    }
    
    // Search từ ngày này đến ngày kia
    public ArrayList<Bill> getByDateBetween(int year1, int month1, int day1, int year2, int month2, int day2){
        ArrayList<Bill> list = new ArrayList();
        String sql = "select * from Bill where DateCreate between '"+year1+"-"+month1+"-"+day1+"' and '"+year2+"-"+month2+"-"+day2+"'";       
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Bill bill = new Bill();
                bill.setID(rs.getInt("ID"));
                bill.setEmployeeID(rs.getInt("EmployeeID"));
                bill.setCustomerID(rs.getInt("CustomerID"));
                bill.setPaymentByID(rs.getInt("PaymentByID"));
                bill.setSaleAllDayID(rs.getInt("SaleAllDayID"));
                bill.setVoucherID(rs.getInt("VoucherID"));
                bill.setDateCreate(rs.getDate("DateCreate"));
                bill.setAmount(rs.getInt("Amount"));
                bill.setCode(rs.getInt("Code"));
                bill.setAddress(rs.getString("Address"));
                bill.setStatus(rs.getBoolean("Status"));
                EmployeeDAO empDAO = new EmployeeDAO();
                bill.setEmployee(empDAO.getByID(bill.getEmployeeID()));
                CustomerDAO cusDAO = new CustomerDAO();            
                bill.setCustomer(cusDAO.getById(bill.getCustomerID()));
                list.add(bill);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Bill> getStatus(){
        ArrayList listBill = new ArrayList();
        try { 
            String sql = "select * from Bill where Status = 0 and ID != 43 order by DateCreate desc";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                Bill bill = new Bill();
                bill.setID(rs.getInt("ID"));
                bill.setEmployeeID(rs.getInt("EmployeeID"));
                bill.setCustomerID(rs.getInt("CustomerID"));
                bill.setPaymentByID(rs.getInt("PaymentByID"));
                bill.setSaleAllDayID(rs.getInt("SaleAllDayID"));
                bill.setVoucherID(rs.getInt("VoucherID"));
                bill.setDateCreate(rs.getDate("DateCreate"));
                bill.setCode(rs.getInt("Code"));
                bill.setAmount(rs.getInt("Amount"));
                bill.setAddress(rs.getString("Address"));
                bill.setStatus(rs.getBoolean("Status"));
                EmployeeDAO empDAO = new EmployeeDAO();
                bill.setEmployee(empDAO.getByID(bill.getEmployeeID()));             // đoạn này mình sẽ lôi cái Employee lên theo cái EmployeeID trong Bill
                CustomerDAO cusDAO = new CustomerDAO();            
                bill.setCustomer(cusDAO.getById(bill.getCustomerID()));
                listBill.add(bill);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBill;
    }
    
    public boolean lockShift(int SaleAllDayID){
        String sql="update Bill set SaleAllDayID=? where SaleAllDayID=6";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(sql);
            pstm.setInt(1, SaleAllDayID);
            int rs = pstm.executeUpdate();
            if(rs!=0){
                return true;         
            }  
        }
        catch(SQLException ex){
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return false;  
    }
}
