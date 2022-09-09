/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
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
public class CustomerDAO {
    private UtilDB utilDB;
    
    public CustomerDAO() {
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    public ArrayList<Customer> getAll(){
        ArrayList listCustomer = new ArrayList();
        try { 
            String sql = "select * from Customer";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                Customer cus = new Customer();
                cus.setID(rs.getInt("ID"));
                cus.setMemberTypeID(rs.getInt("MemberTypeID"));
                cus.setFullName(rs.getString("FullName"));
                cus.setEmail(rs.getString("Email"));
                cus.setPhoneNumber(rs.getString("PhoneNumber"));
                cus.setStatus(rs.getBoolean("Status"));
                cus.setPoints(rs.getInt("Points"));
                cus.setPointMember(rs.getDouble("PointMember"));
                MemberTypeDAO member = new MemberTypeDAO();
                cus.setMemberType(member.getById(cus.getMemberTypeID()));
                listCustomer.add(cus);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCustomer;
    }
    
    public ArrayList<Customer> getAllMember(){
        ArrayList listCustomer = new ArrayList();
        try { 
            String sql = "select * from Customer where Status=1";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                Customer cus = new Customer();
                cus.setID(rs.getInt("ID"));
                cus.setMemberTypeID(rs.getInt("MemberTypeID"));
                cus.setFullName(rs.getString("FullName"));
                cus.setEmail(rs.getString("Email"));
                cus.setPhoneNumber(rs.getString("PhoneNumber"));
                cus.setStatus(rs.getBoolean("Status"));
                cus.setPoints(rs.getInt("Points"));
                cus.setPointMember(rs.getDouble("PointMember"));
                MemberTypeDAO member = new MemberTypeDAO();
                cus.setMemberType(member.getById(cus.getMemberTypeID()));
                listCustomer.add(cus);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCustomer;
    }
    
    // lấy dữ liệu Customer theo Phone number
    public ArrayList<Customer> getByPhone(String p){
        ArrayList<Customer> phone = new ArrayList();
        String sql = "select * from Customer where PhoneNumber="+p;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Customer cus = new Customer();
                cus.setID(rs.getInt("ID"));
                cus.setMemberTypeID(rs.getInt("MemberTypeID"));
                cus.setFullName(rs.getString("FullName"));
                cus.setEmail(rs.getString("Email"));
                cus.setPhoneNumber(rs.getString("PhoneNumber"));
                cus.setStatus(rs.getBoolean("Status"));
                cus.setPoints(rs.getInt("Points"));
                cus.setPointMember(rs.getDouble("PointMember"));
                MemberTypeDAO member = new MemberTypeDAO();
                cus.setMemberType(member.getById(cus.getMemberTypeID()));
                phone.add(cus);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phone;
    }
    
    public Customer getById(int id){
        String sql = "Select * from Customer where ID="+id;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Customer cus = new Customer();
                cus.setID(rs.getInt("ID"));
                cus.setMemberTypeID(rs.getInt("MemberTypeID"));
                cus.setFullName(rs.getString("FullName"));
                cus.setEmail(rs.getString("Email"));
                cus.setPhoneNumber(rs.getString("PhoneNumber"));
                cus.setStatus(rs.getBoolean("Status"));
                cus.setPoints(rs.getInt("Points"));
                cus.setPointMember(rs.getDouble("PointMember"));
                MemberTypeDAO member = new MemberTypeDAO();
                cus.setMemberType(member.getById(cus.getMemberTypeID()));
                return cus;           
           }   
        }
        catch(SQLException ex){
                 Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
    
    // thêm dữ liệu vào customer
    public boolean add(Customer customer){
        String query="insert into Customer(MemberTypeID, FullName, Email, PhoneNumber, Points, PointMember, Status) values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(query);
            pstm.setInt(1, customer.getMemberTypeID());
            pstm.setString(2, customer.getFullName());         
            pstm.setString(3, customer.getEmail());
            pstm.setString(4, customer.getPhoneNumber());
            pstm.setDouble(5, customer.getPoints());
            pstm.setDouble(6, customer.getPointMember());
            pstm.setBoolean(7, customer.isStatus());
            int result = pstm.executeUpdate();;
            if(result!=0){
                return true;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // thay đổi dữ liệu cột Points vs PointMember
    public boolean addPointMember(double point, int id){
        String sql="update Customer set PointMember=? where ID=?";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(sql);
            pstm.setDouble(1, point);
            pstm.setInt(2, id);
            int rs = pstm.executeUpdate();
            if(rs!=0){
                return true;         
            }  
        }
        catch(SQLException ex){
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return false;  
    }
    
    public boolean addPoints(double point, int id){
        String sql="update Customer set Points=? where ID=?";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(sql);
            pstm.setDouble(1, point);
            pstm.setInt(2, id);
            int rs = pstm.executeUpdate();
            if(rs!=0){
                return true;         
            }  
        }
        catch(SQLException ex){
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return false;  
    }
    
    // thay đổi dữ liệu cột Type
    public boolean addType(double point, int id, int type){
        String sql="update Customer set MemberTypeID=? where ID=? and PointMember=?";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(sql);
            pstm.setInt(1, type);
            pstm.setInt(2, id);
            pstm.setDouble(3, point);
            int rs = pstm.executeUpdate();
            if(rs!=0){
                return true;         
            }  
        }
        catch(SQLException ex){
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return false;  
    }
}
