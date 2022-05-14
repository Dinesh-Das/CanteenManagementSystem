package com.Hexaware.CMS.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.Hexaware.CMS.Model.Menu;

import java.sql.PreparedStatement;

/**
 * OrderDb class used to connect to data base.
 * 
 * @author Dinesh Uttam Das 
 */
public class OrderDb {
    private static int insert;
    private static String className = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/CMSDB";
    private static String dbUser = "root";
    private static String dbPassword = "root";

    // method to place order

    public static int placeOrder(Menu f, int fq, double foodTotal, int id, String status) {
        try {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = format.format(date);

            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO ORDERDETAILS(VENDOR_ID,CUSTOMER_ID,FOOD_ID,QUANTITY,ETA,DATE_AND_TIME,ORDER_VALUE,ORDER_STATUS,REASON) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, f.getVendorId());
            stmt.setInt(2, id);
            stmt.setInt(3, f.getFoodId());
            stmt.setInt(4, fq);
            stmt.setInt(5, (int) (Math.floor(Math.random() * 30) + 5));
            stmt.setString(6, currentDateTime);
            stmt.setDouble(7, foodTotal);
            stmt.setString(8, status);
            stmt.setString(9, " ");
            insert = stmt.executeUpdate();
            // System.out.println(i + " records inserted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
        return insert;
    }

    // method to retrive customer wallet balance

    public static double getWalletBalance(int cid) {
        double walletBal = 0;
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT CUSTOMER_WALLET_BAL FROM CUSTOMER WHERE CUSTOMER_ID =?");
            stmt.setInt(1, cid);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                walletBal = rs.getDouble(1);
                // System.out.println("balance retirved" + walletBal);
            }

        } catch (Exception e) {

            System.out.println(e);

        }
        return walletBal;
    }

    // method to set new amount balance

    public static int setWalletBalance(double walletBal, int cid) {
        insert = 0;
        if (walletBal <= 0) {
            System.out.println("Account balance can not be negative");
            return -1;
        }
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "UPDATE CUSTOMER SET CUSTOMER_WALLET_BAL =? WHERE CUSTOMER_ID =?");
            preparedStatement.setDouble(1, walletBal);
            preparedStatement.setInt(2, cid);

            insert = preparedStatement.executeUpdate();

        } catch (Exception e) {

            System.out.println(e);

        }
        return insert;
    }

    // method to deduct food total amount from customers wallet balance

    public static boolean updateWalletBalance(double foodTotal, int cid) {
        double walletBal = OrderDb.getWalletBalance(cid);
        walletBal -= foodTotal;
        if (OrderDb.setWalletBalance(walletBal, cid) == 1) {
            return true;
        }

        return false;
    }

    // Method to update order status
    public static int updateOrderStatus(String status, String reason, int orderNo) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "UPDATE ORDERDETAILS SET ORDER_STATUS =?, REASON=? WHERE ORDER_NO =?");
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, reason);
            preparedStatement.setInt(3, orderNo);
            insert = preparedStatement.executeUpdate();

        } catch (Exception e) {

            System.out.println(e);

        }
        return insert;
    }

    // Give Discount to customer if ordering for the first time
    public static boolean eligibleForDiscount(int cid) {
        int count = -1;
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT COUNT(*) FROM  ORDERDETAILS WHERE CUSTOMER_ID=?");
            stmt.setInt(1, cid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (count == -1 || count >= 1) {
            return false;
        }
        return true;
    }

}
