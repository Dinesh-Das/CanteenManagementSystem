package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Menu;
import com.Hexaware.CMS.Persistence.MenuDb;

/**
 * MenuFactory class used to fetch and insert data to database.
 * 
 * @author Dinesh Uttam Das 
 */
public class MenuFactory {
    static int x;
    public static Menu[] fetchMenu() {
        Menu menu[] = MenuDb.fetchDb();
        return menu;
    }
    public static void addFoodItem(Menu foodItem) {
        x = MenuDb.addFoodItem(foodItem);
        if (x == 1) {
            System.out.println("Item Added Successfully!");
        } else {
            System.out.println("Error occured while inserting item");
        }
    }

    public static void updateMenu(Menu foodItem) {
        x = MenuDb.updateMenu(foodItem);
        if (x == 1) {
            System.out.println("Item Updated Successfully!");
        } else {
            System.out.println("Error occured while updating item");
        }
    }
}
