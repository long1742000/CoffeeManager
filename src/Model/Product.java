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
public class Product {
    private int ID;
    private int DishID;
    private int SizeID;
    private int Price;
    private int Points;
    private boolean Status;
    
    private Dish dish;
    private Size size;

    public Product() {
    }

    public Product(int ID, int DishID, int SizeID, int Price, int Points, boolean Status, Dish dish, Size size) {
        this.ID = ID;
        this.DishID = DishID;
        this.SizeID = SizeID;
        this.Price = Price;
        this.Points = Points;
        this.Status = Status;
        this.dish = dish;
        this.size = size;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDishID() {
        return DishID;
    }

    public void setDishID(int DishID) {
        this.DishID = DishID;
    }

    public int getSizeID() {
        return SizeID;
    }

    public void setSizeID(int SizeID) {
        this.SizeID = SizeID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

}
