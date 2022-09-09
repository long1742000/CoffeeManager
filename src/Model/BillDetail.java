/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author HP
 */
public class BillDetail {
    private int ID;
    private int BillID;
    private int ProductID;
    private int Quantity;
    private boolean Status;
    
    private Bill bill;
    private Product product;
    private Voucher voucher;

    public BillDetail() {
    }

    public BillDetail(int ID, int BillID, int ProductID, int Quantity, boolean Status, Bill bill, Product product, Voucher voucher) {
        this.ID = ID;
        this.BillID = BillID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.Status = Status;
        this.bill = bill;
        this.product = product;
        this.voucher = voucher;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBillID() {
        return BillID;
    }

    public void setBillID(int BillID) {
        this.BillID = BillID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

}
