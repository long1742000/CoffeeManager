/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Bill {
    private int ID;
    private int EmployeeID;
    private int CustomerID;
    private int PaymentByID;
    private int SaleAllDayID;
    private int VoucherID;
    private int Code;
    private Date DateCreate;
    private int Amount;
    private String Address;
    private boolean Status;
    
    private Employee employee;
    private Customer customer;
    private PaymentBy paymentBy;
    
    private ArrayList<BillDetail> listBillDetail;

    public Bill() {
    }

    public Bill(int ID, int EmployeeID, int CustomerID, int PaymentByID, int SaleAllDayID, int VoucherID, int Code, Date DateCreate, int Amount, String Address, boolean Status, Employee employee, Customer customer, PaymentBy paymentBy, ArrayList<BillDetail> listBillDetail) {
        this.ID = ID;
        this.EmployeeID = EmployeeID;
        this.CustomerID = CustomerID;
        this.PaymentByID = PaymentByID;
        this.SaleAllDayID = SaleAllDayID;
        this.VoucherID = VoucherID;
        this.Code = Code;
        this.DateCreate = DateCreate;
        this.Amount = Amount;
        this.Address = Address;
        this.Status = Status;
        this.employee = employee;
        this.customer = customer;
        this.paymentBy = paymentBy;
        this.listBillDetail = listBillDetail;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getPaymentByID() {
        return PaymentByID;
    }

    public void setPaymentByID(int PaymentByID) {
        this.PaymentByID = PaymentByID;
    }

    public int getSaleAllDayID() {
        return SaleAllDayID;
    }

    public void setSaleAllDayID(int SaleAllDayID) {
        this.SaleAllDayID = SaleAllDayID;
    }

    public int getVoucherID() {
        return VoucherID;
    }

    public void setVoucherID(int VoucherID) {
        this.VoucherID = VoucherID;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date DateCreate) {
        this.DateCreate = DateCreate;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentBy getPaymentBy() {
        return paymentBy;
    }

    public void setPaymentBy(PaymentBy paymentBy) {
        this.paymentBy = paymentBy;
    }

    public ArrayList<BillDetail> getListBillDetail() {
        return listBillDetail;
    }

    public void setListBillDetail(ArrayList<BillDetail> listBillDetail) {
        this.listBillDetail = listBillDetail;
    }

}
