package com.Hexaware.CMS.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.Hexaware.CMS.Model.Menu;

/**
 * MenuDb class used to connect to data base.
 * 
 * @author Dinesh Uttam Das
 */
public class MenuDb {
    private static int insert;
    private static String className = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/CMSDB";
    private static String dbUser = "root";
    private static String dbPassword = "root";

    // method to retrive all menu items present in food item table

    public static Menu[] fetchDb() {
        Menu m[] = null;
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from FOODITEM");
            ArrayList<Menu> list = new ArrayList<Menu>();
            while (rs.next()) {
                list.add(new Menu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
                m = new Menu[list.size()];
                m = list.toArray(m);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return m;
    }

    // method to add new menu item in the foodItem table

    public static int addFoodItem(Menu f) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement stmt = con
                    .prepareStatement("INSERT INTO FOODITEM(FOOD_NAME,FOOD_PRICE,VENDOR_ID) VALUES (?,?,?)");
            stmt.setString(1, f.getFoodName());
            stmt.setDouble(2, f.getFoodPrice());
            stmt.setInt(3, f.getVendorId());
            insert = stmt.executeUpdate();
            System.out.println(insert + " records inserted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
        return insert;
    }

    // method to update/edit menu items

    public static int updateMenu(Menu foodItem) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "UPDATE FOODITEM SET FOOD_NAME =?, FOOD_PRICE=? WHERE FOOD_ID =?");
            preparedStatement.setString(1, foodItem.getFoodName());
            preparedStatement.setDouble(2, foodItem.getFoodPrice());
            preparedStatement.setInt(3, foodItem.getFoodId());
            insert = preparedStatement.executeUpdate();

        } catch (Exception e) {

            System.out.println(e);

        }
        return insert;
    }

}
