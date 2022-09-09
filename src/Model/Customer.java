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
public class Customer {
    private int ID;
    private int MemberTypeID;
    private String FullName;
    private String Email;
    private String PhoneNumber;
    private double Points;
    private double PointMember;
    private boolean Status;
    
    private MemberType memberType;

    public Customer() {
    }

    public Customer(int ID, int MemberTypeID, String FullName, String Email, String PhoneNumber, double Points, double PointMember, boolean Status, MemberType memberType) {
        this.ID = ID;
        this.MemberTypeID = MemberTypeID;
        this.FullName = FullName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Points = Points;
        this.PointMember = PointMember;
        this.Status = Status;
        this.memberType = memberType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMemberTypeID() {
        return MemberTypeID;
    }

    public void setMemberTypeID(int MemberTypeID) {
        this.MemberTypeID = MemberTypeID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
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

    public double getPoints() {
        return Points;
    }

    public void setPoints(double Points) {
        this.Points = Points;
    }

    public double getPointMember() {
        return PointMember;
    }

    public void setPointMember(double PointMember) {
        this.PointMember = PointMember;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

}
