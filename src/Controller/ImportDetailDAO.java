/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ImportDetail;
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
public class ImportDetailDAO {
    private UtilDB utilDB;
    
    public ImportDetailDAO() {
        utilDB = new UtilDB();
        utilDB.connect();
    }
    
    // Lấy All dữ liệu từ ImportDetail
    public ArrayList<ImportDetail> getAll(){
        ArrayList list = new ArrayList();
        try { 
            String sql = "select * from ImportDetail";
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                ImportDetail imp = new ImportDetail();
                imp.setID(rs.getInt("ID"));
                imp.setImportID(rs.getInt("ImportID"));
                imp.setName(rs.getString("Name"));
                imp.setQuantity(rs.getInt("Quantity"));
                list.add(imp);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(ImportDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<ImportDetail> getByImportID(int id){
        ArrayList list = new ArrayList();
        try { 
            String sql = "select * from ImportDetail where ImportID="+id;
            Statement stm = utilDB.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                ImportDetail imp = new ImportDetail();
                imp.setID(rs.getInt("ID"));
                imp.setImportID(rs.getInt("ImportID"));
                imp.setName(rs.getString("Name"));
                imp.setQuantity(rs.getInt("Quantity"));
                list.add(imp);
            }         
        } catch (SQLException ex) {
            Logger.getLogger(ImportDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    // Thêm dữ liệu vào ImportDetail
    public boolean add(int impID, String name, int quan){
        String query="insert into ImportDetail(ImportID, Name, Quantity) values(?,?,?)";
        try{
            PreparedStatement pstm=utilDB.getConn().prepareStatement(query);
            pstm.setInt(1, impID);   
            pstm.setString(2, name);   
            pstm.setInt(3, quan);
            int result = pstm.executeUpdate();;
            if(result!=0){
                return true;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ImportDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
