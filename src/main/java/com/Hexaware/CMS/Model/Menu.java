package com.Hexaware.CMS.Model;

/**
 * Menu used to insert/retrive menu items from/to the database.
 * 
 * @author Dinesh Uttam Das 
 */
public class Menu {
    private int foodId;
    private String foodName;
    private double foodPrice;
    private int vendorId;

    public Menu() {
    }

    public Menu(int foodId, String foodName, double foodPrice, int vendorId) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.vendorId = vendorId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getFoodId() {
        return this.foodId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public double getFoodPrice() {
        return this.foodPrice;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getVendorId() {
        return this.vendorId;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%4s %25s %20s %10s", foodId, foodName, foodPrice, vendorId);
    }
}
