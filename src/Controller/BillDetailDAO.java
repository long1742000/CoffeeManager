/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BillDetail;
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
public class BillDetailDAO {
    private UtilDB utilDB;
    
    public BillDetailDAO() {
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    // lấy All dữ liệu Bill detail
    public ArrayList<BillDetail> getAll(){
        ArrayList listProduct = new ArrayList();
        try { 
            String sql = "select * from BillDetail";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                BillDetail billdetail = new BillDetail();
                billdetail.setID(rs.getInt("ID"));
                billdetail.setProductID(rs.getInt("ProductID"));
                billdetail.setBillID(rs.getInt("BillID"));
                billdetail.setQuantity(rs.getInt("Quantity"));
                billdetail.setStatus(rs.getBoolean("Status"));
                ProductDAO productDAO = new ProductDAO();
                billdetail.setProduct(productDAO.getbyID(billdetail.getProductID()));
                listProduct.add(billdetail);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    }
    
    // lấy theo BillID
    public ArrayList<BillDetail> getByBillID(int id){
        ArrayList listProduct = new ArrayList();
        try { 
            String sql = "select * from BillDetail where BillID="+id;
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                BillDetail billdetail = new BillDetail();
                billdetail.setID(rs.getInt("ID"));
                billdetail.setProductID(rs.getInt("ProductID"));
                billdetail.setBillID(rs.getInt("BillID"));
                billdetail.setQuantity(rs.getInt("Quantity"));
                billdetail.setStatus(rs.getBoolean("Status"));
                ProductDAO productDAO = new ProductDAO();
                billdetail.setProduct(productDAO.getbyID(billdetail.getProductID()));
                listProduct.add(billdetail);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    }
    
    // thêm dữ liệu vào Bill detail
    public boolean add(int billID, int productID,int quantity, boolean status){
        String query="insert into BillDetail(BillID, ProductID, Quantity, Status) values(?,?,?,?)";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(query);
            pstm.setInt(1, billID);
            pstm.setInt(2, productID); 
            pstm.setInt(3, quantity);
            pstm.setBoolean(4, status);
            int result = pstm.executeUpdate();
            if(result!=0){
                return true;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // Chuyển các Product nằm trong Bill rác (Bill có ID=43 trong database) vào Bill mới
    public boolean saveBill(int billID){
        String sql="update BillDetail set BillID=? where BillID=43";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(sql);
            pstm.setInt(1, billID);
            int rs = pstm.executeUpdate();
            if(rs!=0){
                return true;         
            }  
        }
        catch(SQLException ex){
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return false;  
    }
}
