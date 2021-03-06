package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Menu;

import com.Hexaware.CMS.Persistence.OrderDb;

/**
 * OrderFactory class used to fetch and insert data to database.
 * 
 * @author Dinesh Uttam Das 
 */
public class OrderFactory {
    

    public static int OrderFood(Menu f, int fquan, int id, String status) {
        double foodTotal = fquan * f.getFoodPrice();
        int result = 0;
        if (OrderDb.updateWalletBalance(foodTotal, id)) {
            result = OrderDb.placeOrder(f, fquan, foodTotal, id, status);
        }
        return result;
    }

   

    

    public static double getWalletBalance(int cid) {
        return OrderDb.getWalletBalance(cid);
    }

    public static int setWalletBalance(double newAmt, int cid) {
        double amt = OrderDb.getWalletBalance(cid);
        return OrderDb.setWalletBalance((amt + newAmt), cid);

    }

    public static int updateOrderStatus(int no, String status, String reason) {
        return OrderDb.updateOrderStatus(status, reason, no);
    }

  

    public static boolean eligibleForDiscount(int cid) {
        return OrderDb.eligibleForDiscount(cid);
    }
}
