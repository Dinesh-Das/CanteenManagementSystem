package com.Hexaware.CMS.Cli;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.Hexaware.CMS.Factory.CustomerFactory;
import com.Hexaware.CMS.Factory.LoginFacotry;
import com.Hexaware.CMS.Factory.MenuFactory;
import com.Hexaware.CMS.Factory.OrderFactory;
import com.Hexaware.CMS.Factory.VendorFactory;
import com.Hexaware.CMS.Model.Customer;
import com.Hexaware.CMS.Model.Menu;
import com.Hexaware.CMS.Model.Orders;
import com.Hexaware.CMS.Model.Vendor;
import com.Hexaware.CMS.Persistence.CustomerDb;
import com.Hexaware.CMS.Persistence.VendorDb;

/**
 * CliMain used as Client interface for java coading.
 * 
 * @author Dinesh Uttam Das 
 */
public class CliMain {

    static Scanner scan = new Scanner(System.in);
    private static String email;
    private static String password;
    private static int loginType;
    private static int primaryKeyId;
    private static String zero = "0000";
    private static String dash = "-----------------------------------------------------------------------";
    private static int choice;

    /**
     * main method used to display the option we had in the application.
     */
    public static void main(String[] args) {

        loginMenu();
        System.out.println("Thank You For Using Our Services :)");
        System.exit(0);

    }

    private static void vendorMenu() {
        do {
            System.out.println(dash);
            System.out.println("Canteen Management System");
            System.out.println(dash);
            System.out.println("VENDOR ID: VEN" + zero + "" + primaryKeyId);
            System.out.println(dash);
            System.out.println("Enter your choice... ");
            System.out.println("1. ADD FOOD ITEMS");
            System.out.println("2. UPDATE FOOD ITEMS");
            System.out.println("3. VIEW ITEMS");
            System.out.println("4. ACCEPT ORDERS");
            System.out.println("5. VIEW PERSONAL DETAILS");
            System.out.println("6. ORDER HISTORY");
            System.out.println("7. Previous Menu");
            System.out.println(dash);
            try {
                choice = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (Incorrect input: an integer is required)");
                choice = 10;
                scan.nextLine();

            }
            switch (choice) {
                case 1:
                    try {
                        addFoodItems();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }

                    break;
                case 2:
                    try {
                        updateMenu();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }

                    break;
                case 3:
                    try {
                        menuListOfVendor();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }

                    break;
                case 4:
                    try {
                        acceptRejectOrder();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }

                    break;
                case 5:
                    try {
                        vendorProfile();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }

                    break;
                case 6:
                    try {
                        VendorOderHistory();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }

                    break;
                case 7:
                    loginMenu();
                    break;
                default:
                    System.out.println("Invalid Choice!!!");
            }
        } while (choice != 0);
    }

    private static void customerMenu() {
        do {
            System.out.println(dash);
            System.out.println("Canteen Management System");
            System.out.println(dash);
            System.out.println("CUSTOMER ID: CUS" + zero + "" + primaryKeyId);
            System.out.println(dash);
            System.out.println("Enter your choice... ");
            System.out.println("1. SHOW MENU LIST");
            System.out.println("2. ORDER FOOD");
            System.out.println("3. ORDER HISTORY");
            System.out.println("4. VIEW PROFILE");
            System.out.println("5. VIEW WALLET BALANCE");
            System.out.println("6. CHECK ORDER STATUS");
            System.out.println("7. Previous Menu");
            System.out.println(dash);

            try {
                choice = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (Incorrect input: an integer is required)");
                choice = 10;
                scan.nextLine();

            }

            switch (choice) {
                case 1:
                    try {
                        menuList();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Inputs Please try again");
                        scan.nextLine();
                    }
                    break;
                case 2:
                    try {
                        placeOrder();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }

                    break;
                case 3:
                    try {
                        customerOrderHistory();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }

                    break;
                case 4:
                    try {
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }
                    customerProfile();
                    break;
                case 5:
                    try {
                        getWalletBalance();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }

                    break;
                case 6:
                    try {
                        checkOrderStatus();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input Please Try Again");
                        scan.nextLine();
                    }

                    break;
                case 7:
                    loginMenu();
                    break;
                default:
                    System.out.println("Invalid Choice!!!");
            }
        } while (choice != 0);
    }

    // Login menu
    private static void loginMenu() {
        do {
            System.out.println(dash);
            System.out.println("Canteen Management System");
            System.out.println(dash);
            System.out.println("Enter your choice... ");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Reset Password");
            System.out.println("4. Exit");
            System.out.println(dash);

            try {
                choice = scan.nextInt();

            } catch (InputMismatchException ex) {
                System.out.println("Try again. (Incorrect input: an integer is required)");
                choice = 5;
                scan.nextLine();
            }

            if (choice == 1) {
                choice = login();
            } else if (choice == 2) {
                choice = signup();
            } else if (choice == 3) {
                choice = resetPassword();
            } else if (choice == 4) {
                Runtime.getRuntime().halt(0);
            } else {
                System.out.println("Invalid Choice");
            }

        } while (choice != 0);

        primaryKeyId = LoginFacotry.getIdByType(email);
        if (loginType == 1) {
            customerMenu();
        } else if (loginType == 2) {
            vendorMenu();
        }
    }

    // Method to reset password
    private static int resetPassword() {
        scan.nextLine();
        System.out.println("Enter Email :");
        email = scan.nextLine();
        if (LoginFacotry.checkEmail(email)) {
            System.out.println("Enter Password :");
            password = scan.nextLine();
            System.out.println("Confirm Password :");
            String confirm = scan.nextLine();
            if (password.equals(confirm)) {
                System.out.println("Password Reset Successfully");
                return LoginFacotry.resetPassword(email, password);
            } else {
                System.out.println("Password Does Not Match!!! Try Again :)");
                return -1;
            }
        } else {
            System.out.println("There is no user with email");
            return -1;
        }
    }

    /**
     * this method is used Get Wallet Balance and add amount in wallet.
     */
    public static void getWalletBalance() {
        do {
            double balance = OrderFactory.getWalletBalance(primaryKeyId);
            System.out.println("Your Wallet Balance");
            System.out.println("Customer Id  Wallet Balance");
            System.out.println("CUS0000" + primaryKeyId + "       " + balance);
            System.out.println("1. Add Amount");
            System.out.println("2. Cancel");
            choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("Enter amount to add:");
                double newAmt = scan.nextDouble();
                if (OrderFactory.setWalletBalance(newAmt, primaryKeyId) == 1) {
                    System.out.println("Amount Added Successfully.... :)");
                    System.out.println();
                }
            }
        } while (choice != 2);
    }

    /**
     * this method is used to verify login credentials.
     */
    public static int login() {
        scan.nextLine();
        System.out.println("Enter email :");
        email = scan.nextLine();
        System.out.println("Enter password : ");
        password = scan.nextLine();
        loginType = LoginFacotry.checkCredential(email, password);
        if (loginType == -1) {
            return 1;
        }
        return 0;
    }

    /**
     * this method is to Create a Customer in Login table.
     */
    public static int signup() {
        do {
            System.out.println("Enter Login ID (1.Customer,2.Vendor)");
            loginType = scan.nextInt();
            if (loginType == 1 || loginType == 2) {
                break;
            } else {
                System.out.println("Invalid Choice Please Select Valid ID");
            }
        } while (true);
        scan.nextLine();
        System.out.println("Enter email :");
        email = scan.nextLine();
        System.out.println("Enter password : ");
        password = scan.nextLine();
        if (loginType == 1) {
            addCustomer();
        } else {
            addVendor();
        }
        System.out.println("Signed-In Successfully...!");
        return LoginFacotry.signupDb(loginType, email, password);
    }

    /**
     * this method is to add Customers.
     */
    public static void addCustomer() {
        System.out.println();
        System.out.println("Enter Name:");
        String name = scan.nextLine();
        System.out.println("Enter Phone");
        String phone = scan.nextLine();
        System.out.println("Enter Wallet Balance");
        double walletBal = scan.nextDouble();
        CustomerDb.addNewCustomer(name, phone, email, walletBal);
    }

    /**
     * this method is to add Vendors.
     */
    public static void addVendor() {
        System.out.println();
        System.out.println("Enter name");
        String name = scan.nextLine();
        System.out.println("Enter Phone");
        String phone = scan.nextLine();
        System.out.println("Enter Specifications");
        String specs = scan.nextLine();
        VendorDb.addNewVendor(name, phone, specs, email);
    }

    /**
     * this method is to add food items.
     */
    public static void addFoodItems() {
        scan.nextLine();
        Menu foodItem = new Menu();
        System.out.println("Please provide Food Item details!");
        System.out.println("Enter Name :");
        foodItem.setFoodName(scan.nextLine());
        System.out.println("Enter Price :");
        foodItem.setFoodPrice(scan.nextDouble());
        foodItem.setVendorId(primaryKeyId);
        MenuFactory.addFoodItem(foodItem);
    }

    /**
     * this method is to update food items.
     */
    public static void updateMenu() {
        Menu f = new Menu();
        menuListOfVendor();
        System.out.println();
        System.out.println("Enter Food ID To Update Menu Item: ");
        f.setFoodId(scan.nextInt());
        scan.nextLine();
        System.out.println("Updated Food Name: ");
        f.setFoodName(scan.nextLine());
        System.out.println("Updated Food Price:");
        f.setFoodPrice(scan.nextDouble());
        MenuFactory.updateMenu(f);
    }

    /**
     * this method is to place food order.
     */
    public static void placeOrder() {
        menuList();
        Menu menu[] = MenuFactory.fetchMenu();
        boolean isEligible = OrderFactory.eligibleForDiscount(primaryKeyId);
        double discount = 0;
        double discountedPrice = 0;
        if (menu != null && OrderFactory.getWalletBalance(primaryKeyId) != 0) {
            double orderValue = 0;
            ArrayList<Menu> menuList = new ArrayList<>();
            int choice = 0;
            System.out.println(
                    "Your Current Balance Before Placing Order :" + OrderFactory.getWalletBalance(primaryKeyId));
            do {
                System.out.println("Enter the Food id");
                int fid = scan.nextInt();
                System.out.println("Enter the Food Quantity");
                int fquan = scan.nextInt();
                Customer customer = CustomerFactory.customerProfile(primaryKeyId);

                Menu foodItem = new Menu();
                foodItem.setFoodId(fid);
                foodItem.setFoodName(menu[fid - 1].getFoodName());
                foodItem.setFoodPrice(menu[fid - 1].getFoodPrice());
                foodItem.setVendorId(menu[fid - 1].getVendorId());
                orderValue += foodItem.getFoodPrice() * fquan;
                if (customer.getCustomerWalletBalance() < orderValue) {
                    System.out.println("Insufficient Funds....!");

                } else {
                    OrderFactory.OrderFood(foodItem, fquan, primaryKeyId, "PLACED");

                }
                menuList.add(foodItem);
                System.out.println("1. Do you want to order anything else?");
                System.out.println("2. Confirm Order");
                choice = scan.nextInt();
            } while (choice != 2);
            System.out.println("The items in your order...");
            System.out.println(" Food Id" + "                Food Name" + "          Food Price" + "      Vendor Id");
            for (Menu val : menuList) {

                System.out.println(val);
            }
            System.out.println(dash);
            System.out.println("Total Amount :" + orderValue);
            if (isEligible) {
                discount = Math.abs(((int) (Math.random() * (1 - 75))) + 1);
                System.out.println("Congrats!!! You got a discount coupon of " + discount + "% on first order");
                discountedPrice = orderValue * (discount / 100);
                System.out.println("Discounted Price :" + discountedPrice);
                System.out.println("Discounted Order Value :" + (orderValue - discountedPrice));
                OrderFactory.setWalletBalance(discountedPrice, primaryKeyId);
            }

            System.out.println(
                    "Your Current Balance After Placing Order :" + OrderFactory.getWalletBalance(primaryKeyId));
            System.out.println("Order Placed");
        } else {
            System.out.println("No record found Or Insufficient Balance");
        }
    }

    /**
     * this method is to fetch Menu list.
     */
    public static void menuList() {
        Menu m[] = MenuFactory.fetchMenu();
        if (m != null) {
            System.out.println(dash);
            System.out.println(" Food Id" + "                Food Name" + "          Food Price" + "      Vendor Id");
            for (int i = 0; i < m.length; i++) {

                System.out.println(String.format("%4s %25s %20s %10s", m[i].getFoodId(), m[i].getFoodName(),
                        m[i].getFoodPrice(), m[i].getVendorId()));
            }
            System.out.println(dash);
        } else {
            System.out.println("No record found");
        }

    }

    /**
     * this method is used to view vendor specific menu list.
     */
    public static void menuListOfVendor() {

        Menu m[] = VendorFactory.fetchMenuOfVendor(primaryKeyId);
        if (m != null) {
            System.out.println(dash);
            System.out.println(" Food Id" + "                Food Name" + "          Food Price" + "      Vendor Id");
            for (int i = 0; i < m.length; i++) {

                System.out.println(String.format("%4s %25s %20s %10s", m[i].getFoodId(), m[i].getFoodName(),
                        m[i].getFoodPrice(), m[i].getVendorId()));
            }
            System.out.println(dash);
        } else {
            System.out.println("No record found");
        }
    }

    /**
     * this method is to acceptRejectOrder.
     */
    public static void acceptRejectOrder() {
        Orders[] o = VendorFactory.vendorOrdersAR(primaryKeyId);
        if (o != null) {
            int choice = 0, orderNo = 0;
            String reason;
            do {

                System.out.println(dash);
                System.out.println("CUSTOMER ID: CUS" + zero + primaryKeyId);
                System.out.println("SR NO" + "    " + "Order Id" + "    " + "Food Name" + "    " + "     Food Price"
                        + "    "
                        + "Quantity  "
                        + "Order Value  " + "    " + "ETA  " + "    " + "     Order Time  " + "    " + "     STATUS  ");
                for (int i = 0; i < o.length; i++) {
                    System.out.println(
                            String.format("%5s %5s %20s %10s %10s %13s %14s %23s %10s", i + 1, o[i].getOrderNo(),
                                    o[i].getFoodName(), o[i].getFoodPrice(), o[i].getQuantity(), o[i].getOrderValue(),
                                    o[i].getEta(), o[i].getDateAndTime(), o[i].getOrderStatus()));
                }
                System.out.println(dash);

                System.out.println("1. Accept Order");
                System.out.println("2. Reject Order ");
                System.out.println("3. Previous");
                choice = scan.nextInt();
                if (choice == 1) {
                    System.out.println("Enter SR No:");
                    orderNo = scan.nextInt();
                    if (o[orderNo - 1].getOrderStatus().equals("ACCEPTED")
                            || o[orderNo - 1].getOrderStatus().equals("DENIED")) {
                        System.out.println("The order is already accepted or rejected");
                        continue;
                    }
                    scan.nextLine();
                    System.out.println("Enter Reason:");
                    reason = scan.nextLine();
                    OrderFactory.updateOrderStatus(o[orderNo - 1].getOrderNo(), "ACCEPTED", reason);
                    System.out.println("The Order Accepted Successfully!!!");
                } else if (choice == 2) {
                    System.out.println("Enter SR No:");
                    orderNo = scan.nextInt();
                    if (o[orderNo - 1].getOrderStatus().equals("ACCEPTED")
                            || o[orderNo - 1].getOrderStatus().equals("DENIED")) {
                        System.out.println("The order is already accepted or rejected");
                        continue;
                    }
                    scan.nextLine();
                    System.out.println("Enter Reason:");
                    reason = scan.nextLine();
                    System.out.println(o[orderNo - 1].getOrderValue() + "   " +
                            o[orderNo - 1].getCustomerId());
                    if (OrderFactory.setWalletBalance(o[orderNo - 1].getOrderValue(),
                            o[orderNo - 1].getCustomerId()) == 1) {
                        System.out.println("Order Amount Credited Successfully!!!");
                        if (OrderFactory.updateOrderStatus(o[orderNo - 1].getOrderNo(), "DENIED", reason) == 1) {
                            System.out.println("The Order Rejected Successfully!!!");
                        }
                    }

                }
            } while (choice != 3);
        } else {
            System.out.println("No record found");
        }

    }

    /**
     * this method is for customerProfile.
     */
    public static void customerProfile() {
        Customer c = CustomerFactory.customerProfile(primaryKeyId);
        System.out.println("Customer Details");
        System.out.println("ID             :" + "CUS" + zero + "" + c.getCustomerId());
        System.out.println("Name           :" + c.getCustomerName());
        System.out.println("Phone          :" + c.getCustomerPhone());
        System.out.println("Email          :" + c.getCustomerEmail());
        System.out.println("Coupons        :" + c.getCustomerCupon());
        System.out.println("Wallet Balance :" + c.getCustomerWalletBalance());
    }

    /**
     * this method is for VendorProfile.
     */
    public static void vendorProfile() {
        Vendor v = VendorFactory.vendorProfile(primaryKeyId);
        System.out.println("Vendor Details");
        System.out.println("ID             :" + v.getVendorId());
        System.out.println("Name           :" + v.getVendorName());
        System.out.println("Phone          :" + v.getVendorPhone());
        System.out.println("Email          :" + v.getVendorEmail());
        System.out.println("Specialization :" + v.getvendorSpecification());
    }

    /**
     * this method is for VendorOderHistory.
     */
    public static void VendorOderHistory() {
        Orders v[] = VendorFactory.vendorOrderHistory(primaryKeyId);
        if (v != null) {
            System.out.println(dash);
            System.out.println("VENDOR ID: VEN" + zero + primaryKeyId);
            System.out.println("   Food Name   " + " Food Price   " + "   No of Orders"
                    + "   Sum Quantity" + "    Order Value" + "     Order Time       " + "    " + "STATUS  ");
            for (int i = 0; i < v.length; i++) {
                System.out.println(String.format("%15s %8s %15s %15s %15s %23s %10s", v[i].getFoodName(),
                        v[i].getFoodPrice(), v[i].getNoOfOrders(), v[i].getSumQuantity(), v[i].getOrderValue(),
                        v[i].getDateAndTime(), v[i].getOrderStatus()));
            }
            System.out.println(dash);
        } else {
            System.out.println("No record found");
        }

    }

    /**
     * this method is for CustomerOrderHistory.
     */
    public static void customerOrderHistory() {

        Orders o[] = CustomerFactory.customerOrderHistory(primaryKeyId);
        if (o != null) {
            System.out.println(dash);
            System.out.println("CUSTOMER ID: CUS" + zero + primaryKeyId);
            System.out.println("Order Id   " + "    Food Name    " + " Food Price " + "    Quantity  "
                    + "  Order Value  " + "   ETA   " + "       Order Time        " + "    " + "STATUS  "
                    + "     REASON");
            for (int i = 0; i < o.length; i++) {
                System.out.println(String.format("%5s %20s %8s %12s %15s %13s %22s %10s %20s", o[i].getOrderNo(),
                        o[i].getFoodName(), o[i].getFoodPrice(), o[i].getQuantity(), o[i].getOrderValue(),
                        o[i].getEta(), o[i].getDateAndTime(), o[i].getOrderStatus(), o[i].getReason()));
            }
            System.out.println(dash);
        } else {
            System.out.println("No record found");
        }

    }

    /**
     * this method is for checking order status and cancel if not accepted.
     */
    public static void checkOrderStatus() {
        int choice = 0, orderNo = 0;
        String reason;
        do {
            Orders[] o = CustomerFactory.getOrderStatus(primaryKeyId);
            if (o != null) {
                System.out.println(dash);
                System.out.println("CUSTOMER ID: CUS" + zero + primaryKeyId);
                System.out.println("SR NO" + "    " + "Order NO" + "    " + "Food Name" + "    " + "     Food Price"
                        + "    "
                        + "Quantity  "
                        + "Order Value  " + "    " + "ETA  " + "    " + "     Order Time  " + "    " + "     STATUS  ");
                for (int i = 0; i < o.length; i++) {
                    System.out.println(
                            String.format("%5s %5s %20s %10s %10s %13s %14s %23s %15s", i + 1, o[i].getOrderNo(),
                                    o[i].getFoodName(), o[i].getFoodPrice(), o[i].getQuantity(), o[i].getOrderValue(),
                                    o[i].getEta(), o[i].getDateAndTime(), o[i].getOrderStatus()));
                }
                System.out.println(dash);

                System.out.println("1. Cancel Order?");
                System.out.println("2. Previous ");
                choice = scan.nextInt();
                if (choice == 1) {
                    System.out.println("Enter SR No:");
                    orderNo = scan.nextInt();
                    if (o[orderNo - 1].getOrderStatus().equals("ACCEPTED")
                            || o[orderNo - 1].getOrderStatus().equals("DENIED")) {
                        System.out.println("The Order is already accepted/rejected");
                        continue;
                    }

                    scan.nextLine();
                    System.out.println("Enter Reason:");
                    reason = scan.nextLine();
                    if (OrderFactory.setWalletBalance(o[orderNo - 1].getOrderValue(),
                            o[orderNo - 1].getCustomerId()) == 1) {

                        OrderFactory.updateOrderStatus(o[orderNo - 1].getOrderNo(), "CANCELLED", reason);
                        System.out.println("The Order Cancelled Successfully!!!");

                    }
                }
            } else {
                System.out.println("No record found");
                choice = 2;
            }

        } while (choice != 2);
    }

}
