package com.Hexaware.CMS.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Hexaware.CMS.Model.Menu;
import com.Hexaware.CMS.Model.Orders;
import com.Hexaware.CMS.Model.Vendor;

import java.sql.PreparedStatement;

/**
 * Vendor class used to connect to data base.
 * 
 * @author Dinesh Uttam Das 
 */
public class VendorDb {
    private static int i;
    private static String className = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/CMSDB";
    private static String dbUser = "root";
    private static String dbPassword = "root";

    // method to add new vendor in the databse

    public static int addNewVendor(String name, String phone, String specs, String email) {

        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con
                    .prepareStatement(
                            "insert into VENDOR (VENDOR_NAME,VENDOR_PHONE,VENDOR_EMAIL,VENDOR_SPECS) values(?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, email);
            stmt.setString(4, specs);
            i = stmt.executeUpdate();
            // System.out.println(i + " records inserted successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    // method to retrive vendor specific menu

    public static Menu[] fetchMenuOfVendor(int id) {
        Menu m[] = null;
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM FOODITEM WHERE VENDOR_ID=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Menu> list = new ArrayList<Menu>();
            while (rs.next()) {
                list.add(new Menu(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
                m = new Menu[list.size()];
                m = list.toArray(m);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return m;

    }

    // method to retrive vendor information

    public static Vendor vendorProfileDb(int vid) {
        Vendor vendor = new Vendor();
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM VENDOR Where VENDOR_ID = ?");
            stmt.setInt(1, vid);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                vendor.setVendorId(resultSet.getInt(1));
                vendor.setVendorName(resultSet.getString(2));
                vendor.setVendorPhone(resultSet.getString(3));
                vendor.setVendorEmail(resultSet.getString(4));
                vendor.setvendorSpecification(resultSet.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return vendor;
    }

    // method to retrive vendor specific order history

    public static Orders[] vendorOderHistoryDb(int vid) {
        Orders orders[] = null;
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT F.FOOD_NAME,F.FOOD_PRICE,(COUNT(*)),SUM(O.QUANTITY),SUM(O.ORDER_VALUE),O.DATE_AND_TIME,O.ORDER_STATUS FROM  ORDERDETAILS O JOIN FOODITEM F ON O.FOOD_ID = F.FOOD_ID WHERE O.VENDOR_ID = ? GROUP BY F.FOOD_NAME");
            stmt.setInt(1, vid);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Orders> list = new ArrayList<Orders>();
            while (rs.next()) {
                list.add(new Orders(rs.getString(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7)));
                orders = new Orders[list.size()];
                orders = list.toArray(orders);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }
    // Retrive vendor accept/reject

    public static Orders[] VendorOrders(int vid) {
        Orders orders[] = null;
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT O.ORDER_NO,F.FOOD_NAME,F.FOOD_PRICE,O.QUANTITY, O.ORDER_STATUS,O.ETA,O.DATE_AND_TIME,O.ORDER_VALUE,O.CUSTOMER_ID FROM ORDERDETAILS O JOIN FOODITEM F ON O.FOOD_ID=F.FOOD_ID WHERE O.VENDOR_ID=?");
            stmt.setInt(1, vid);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Orders> list = new ArrayList<Orders>();
            while (rs.next()) {
                list.add(new Orders(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9)));
                orders = new Orders[list.size()];
                orders = list.toArray(orders);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }
}
