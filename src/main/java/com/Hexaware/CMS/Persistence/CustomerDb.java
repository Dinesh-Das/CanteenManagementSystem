package com.Hexaware.CMS.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Hexaware.CMS.Model.Customer;
import com.Hexaware.CMS.Model.Orders;

import java.sql.PreparedStatement;

public class CustomerDb {
    private static int i;
    private static String className = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/CMSDB";
    private static String dbUser = "root";
    private static String dbPassword = "root";

    // method to add new customer in database

    public static int addNewCustomer(String name, String phone, String email, double walletBal) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement(
                    "insert into CUSTOMER(CUSTOMER_NAME,CUSTOMER_PHONE,CUSTOMER_EMAIL,CUSTOMER_WALLET_BAL) values(?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, email);
            stmt.setDouble(4, walletBal);
            i = stmt.executeUpdate();
            // System.out.println(i + " records inserted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    // method to retrive customer information

    public static Customer customerProfileDb(int cid) {
        Customer customer = new Customer();
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM CUSTOMER Where CUSTOMER_ID = ?");
            stmt.setInt(1, cid);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                customer.setCustomerId(resultSet.getInt(1));
                customer.setCustomerName(resultSet.getString(2));
                customer.setCustomerPhone(resultSet.getString(3));
                customer.setCustomerEmail(resultSet.getString(4));
                customer.setCustomerWalletBal(resultSet.getDouble(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return customer;
    }

    // method to retrive customer specific order history

    public static Orders[] customerOderHistoryDb(int cid) {
        Orders orders[] = null;
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT O.ORDER_NO,F.FOOD_NAME,F.FOOD_PRICE,O.QUANTITY,O.ORDER_VALUE,O.ETA,O.Date_AND_TIME,O.ORDER_STATUS,O.REASON FROM ORDERDETAILS O JOIN FOODITEM F ON O.FOOD_ID = F.FOOD_ID WHERE O.CUSTOMER_ID =?");
            stmt.setInt(1, cid);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Orders> list = new ArrayList<Orders>();
            while (rs.next()) {
                list.add(new Orders(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9)));
                orders = new Orders[list.size()];
                orders = list.toArray(orders);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }

    // Method to retrive order status

    public static Orders[] getOrderStatus(int cid) {
        Orders orders[] = null;
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT O.ORDER_NO,F.FOOD_NAME,F.FOOD_PRICE,O.QUANTITY, O.ORDER_STATUS,O.ETA,O.DATE_AND_TIME,O.ORDER_VALUE,O.CUSTOMER_ID FROM ORDERDETAILS O JOIN FOODITEM F ON O.FOOD_ID=F.FOOD_ID WHERE O.CUSTOMER_ID=?");
            stmt.setInt(1, cid);
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
