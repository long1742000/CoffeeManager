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
public class Employee {
    private int ID;
    private String FullName;
    private String Username;
    private String Password;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private String IndentityCard;
    private boolean IsAdmin;
    private boolean Status;

    public Employee() {
    }

    public Employee(int ID, String FullName, String Username, String Password, String Email, String PhoneNumber, String Address, String IndentityCard, boolean IsAdmin, boolean Status) {
        this.ID = ID;
        this.FullName = FullName;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.IndentityCard = IndentityCard;
        this.IsAdmin = IsAdmin;
        this.Status = Status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getIndentityCard() {
        return IndentityCard;
    }

    public void setIndentityCard(String IndentityCard) {
        this.IndentityCard = IndentityCard;
    }

    public boolean isIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
}
