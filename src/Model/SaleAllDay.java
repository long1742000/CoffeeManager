/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author HP
 */
public class SaleAllDay {
    private int ID;
    private int EmployeeID;
    private int Shift;
    private Date DateCreate;
    private int Cash;
    private int Momo;
    private int VNPay;
    private int Discount;
    private int Total;
    private boolean Status;
    
    private Employee employee;
    private Customer customer;

    public SaleAllDay() {
    }

    public SaleAllDay(int ID, int EmployeeID, int Shift, Date DateCreate, int Cash, int Momo, int VNPay, int Discount, int Total, boolean Status, Employee employee, Customer customer) {
        this.ID = ID;
        this.EmployeeID = EmployeeID;
        this.Shift = Shift;
        this.DateCreate = DateCreate;
        this.Cash = Cash;
        this.Momo = Momo;
        this.VNPay = VNPay;
        this.Discount = Discount;
        this.Total = Total;
        this.Status = Status;
        this.employee = employee;
        this.customer = customer;
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

    public int getShift() {
        return Shift;
    }

    public void setShift(int Shift) {
        this.Shift = Shift;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date DateCreate) {
        this.DateCreate = DateCreate;
    }

    public int getCash() {
        return Cash;
    }

    public void setCash(int Cash) {
        this.Cash = Cash;
    }

    public int getMomo() {
        return Momo;
    }

    public void setMomo(int Momo) {
        this.Momo = Momo;
    }

    public int getVNPay() {
        return VNPay;
    }

    public void setVNPay(int VNPay) {
        this.VNPay = VNPay;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
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

}
