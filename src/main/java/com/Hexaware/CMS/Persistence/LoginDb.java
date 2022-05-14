package com.Hexaware.CMS.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * LoginDb class used to connect to data base.
 * 
 * @author Dinesh Uttam Das
 */
public class LoginDb {
    private static int insert;
    private static int primaryKeyId;
    private static int type;
    private static String className = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/CMSDB";
    private static String dbUser = "root";
    private static String dbPassword = "root";

    // method to create a new user (vendor or customer ) in login table

    public static int signupDb(int loginType, String email, String password) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO LOGIN VALUES(?,?,?)");

            stmt.setInt(1, loginType);
            stmt.setString(2, email);
            stmt.setString(3, password);
            insert = stmt.executeUpdate();
            System.out.println(insert + " records inserted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
        return insert;
    }

    // method to check login details are present in login table

    public static int checkCredential(String email, String password) {

        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM LOGIN WHERE EMAIL = ? AND PASSWORD = ?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                type = resultSet.getInt(1);
                System.out.println("Logged-In Successfully...!");
            } else {
                System.out.println("Error occured while loging");
                return -1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return type;

    }

    // method to retrive vendor_id/customer_id by the login type

    public static int getIdByType(String email) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            if (type == 1) {
                PreparedStatement stm = con.prepareStatement("SELECT CUSTOMER_ID FROM CUSTOMER WHERE CUSTOMER_EMAIL=?");
                stm.setString(1, email);
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    primaryKeyId = rs.getInt(1);
                } else {
                    primaryKeyId = 0;
                }
            } else if (type == 2) {
                PreparedStatement st = con.prepareStatement("SELECT VENDOR_ID FROM VENDOR WHERE VENDOR_EMAIL=?");
                st.setString(1, email);
                ResultSet r = st.executeQuery();
                if (r.next()) {
                    primaryKeyId = r.getInt(1);
                } else {
                    primaryKeyId = 0;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return primaryKeyId;
    }

    // Method to retrive email
    public static boolean checkEmail(String email) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM LOGIN WHERE EMAIL = ?");
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // Method to reset password
    public static int resetPassword(String email, String password) {
        insert = 0;
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "UPDATE LOGIN SET PASSWORD =? WHERE EMAIL =?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, email);
            insert = preparedStatement.executeUpdate();

        } catch (Exception e) {

            System.out.println(e);

        }
        return insert;
    }
}
