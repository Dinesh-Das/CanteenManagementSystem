package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Menu;
import com.Hexaware.CMS.Model.Orders;
import com.Hexaware.CMS.Model.Vendor;
import com.Hexaware.CMS.Persistence.VendorDb;

/**
 * VendorFactory used to fetch vendor details from database.
 * 
 * @author Dinesh Uttam Das ---> 71628
 */
public class VendorFactory {
    public static Vendor vendorProfile(int vid) {
        Vendor vendor = VendorDb.vendorProfileDb(vid);
        return vendor;
    }

    public static Orders[] vendorOrderHistory(int vid) {
        Orders v[] = VendorDb.vendorOderHistoryDb(vid);
        return v;
    }

    public static Menu[] fetchMenuOfVendor(int id) {
        Menu menu[] = VendorDb.fetchMenuOfVendor(id);
        return menu;
    }

    // Retriving Vendor specific orders to accept or reject the orders
    public static Orders[] vendorOrdersAR(int id) {
        return VendorDb.VendorOrders(id);
    }

}
