/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Voucher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class VoucherDAO {
    private UtilDB utilDB;
    
    public VoucherDAO() {
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    public Voucher getByID(int id){
        String sql = "Select * from Voucher where ID ="+id;
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Voucher voucher = new Voucher();
                voucher.setID(rs.getInt("ID"));
                voucher.setVoucherCode(rs.getString("VoucherCode"));
                voucher.setDiscount(rs.getInt("Discount"));
                voucher.setStatus(rs.getBoolean("Status"));
                return voucher;           
           }
        }
        catch(SQLException ex){
            Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
    
    // lấy dữ liệu theo VoucherCode
    public Voucher getbyCode(String code){
        String sql = "Select * from Voucher where VoucherCode = '"+code+"'";
        Statement stm;
        try{
            stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                Voucher voucher = new Voucher();
                voucher.setID(rs.getInt("ID"));
                voucher.setVoucherCode(rs.getString("VoucherCode"));
                voucher.setDiscount(rs.getInt("Discount"));
                voucher.setStatus(rs.getBoolean("Status"));
                return voucher;           
           }
        }
        catch(SQLException ex){
            Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;  
    }
    
    // sau khi sử đụng Voucher, chuyển Status = false để voucher đó ko được sử dụng nữa
    public boolean useVoucher(Voucher voucher){
        String sql="update Voucher set Status='false' where ID=?";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(sql);
            pstm.setInt(1, voucher.getID());
            int rs = pstm.executeUpdate();
            if(rs!=0){
                return true;         
            }  
        }
        catch(SQLException ex){
            Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return false;  
    }
}
