package com.Hexaware.CMS.Model;

/**
 * Vendor used to insert/retrive menu items from/to the database.
 * 
 * @author Dinesh Uttam Das ----> 71628
 */
public class Vendor {
    private int vendorId;
    private String vendorName;
    private String vendorPhone;
    private String vendorEmail;
    private String vendorSpecs;

    public Vendor() {
    }

    public Vendor(int id, String name, String phone, String email, String specs) {
        this.vendorId = id;
        this.vendorName = name;
        this.vendorPhone = phone;
        this.vendorEmail = email;
        this.vendorSpecs = specs;
    }

    public void setVendorId(int id) {
        this.vendorId = id;
    }

    public void setVendorName(String name) {
        this.vendorName = name;
    }

    public void setVendorPhone(String phone) {
        this.vendorPhone = phone;
    }

    public void setVendorSpecs(String specs) {
        this.vendorSpecs = specs;
    }

    public void setVendorEmail(String email) {
        this.vendorEmail = email;
    }

    public int getVendorId() {
        return this.vendorId;
    }

    public String getVendorName() {
        return this.vendorName;
    }

    public String getVendorPhone() {
        return this.vendorPhone;
    }

    public String getVendorSpecs() {
        return this.vendorSpecs;
    }

    public String getVendorEmail() {
        return this.vendorEmail;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Vendor Id : " + vendorId + " Vendor Name: " + vendorName + " Vendor Phone: "
                + vendorPhone + " Vendor Email: " + vendorEmail + " Vendor Specs:" + vendorSpecs;
    }

}
