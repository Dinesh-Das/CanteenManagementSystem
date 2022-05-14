package com.Hexaware.CMS.Model;

/**
 * Customer used to insert/retrive menu items from/to the database.
 * 
 * @author Dinesh Uttam Das ----> 71628
 */
public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerCoupon;
    private double customerWalletBal;

    public Customer() {
    }

    public Customer(int id, String name, String email, String phone, String coupon, double walletBal) {
        this.customerId = id;
        this.customerName = name;
        this.customerEmail = email;
        this.customerPhone = phone;
        this.customerCoupon = coupon;
        this.customerWalletBal = walletBal;
    }

    public void setCustomerId(int id) {
        this.customerId = id;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerEmail(String email) {
        this.customerEmail = email;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerPhone(String phone) {
        this.customerPhone = phone;
    }

    public String getCustomerPhone() {
        return this.customerPhone;
    }

    public void setCustomerCupon(String coupon) {
        this.customerCoupon = coupon;
    }

    public String getCustomerCupon() {
        return this.customerCoupon;
    }

    public void setCustomerWalletBal(double walletBal) {
        this.customerWalletBal = walletBal;
    }

    public double getCustomerWalletBal() {
        return this.customerWalletBal;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "CustomerId :" + customerId + " CustomerName :" + customerName + " CustomerEmail :"
                + customerEmail + " CustomerPhone :" + customerPhone + " CustomerCoupon :"
                + customerCoupon + " CustomerWalletBal :" + customerWalletBal;
    }

}
