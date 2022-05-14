package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Customer;
import com.Hexaware.CMS.Model.Orders;
import com.Hexaware.CMS.Persistence.CustomerDb;

/**
 * CustomerFactory used to fetch customer data from database.
 * 
 * @author Dinesh Uttam Das 
 */
public class CustomerFactory {

    public static Customer customerProfile(int cid) {
        Customer customer = CustomerDb.customerProfileDb(cid);
        return customer;
    }

    public static Orders[] customerOrderHistory(int cid) {

        Orders orders[] = CustomerDb.customerOderHistoryDb(cid);
        return orders;
    }

    public static Orders[] getOrderStatus(int cid) {
        return CustomerDb.getOrderStatus(cid);
    }
}
