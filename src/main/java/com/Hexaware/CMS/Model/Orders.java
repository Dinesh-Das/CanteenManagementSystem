package com.Hexaware.CMS.Model;

/**
 * Orders used to insert/retrive menu items from/to the database.
 * 
 * @author Dinesh Uttam Das ----> 71628
 */
public class Orders {
    private int orderNo;
    private int customerId;
    private int vendorId;
    private int foodId;
    private int quantity;
    private String eta;
    private String dateAndTime;
    private double orderValue;
    private String foodName;
    private double foodPrice;
    private int noOfOrders;
    private int sumQuantity;
    private String orderStatus;
    private String reason;

    public Orders() {
    }

    // Place order
    public Orders(int orderNo, int customerId, int vendorId, int foodId, int quantity, String eta,
            String dateAndTime,
            double orderValue, String orderStatus) {
        this.orderNo = orderNo;
        this.customerId = customerId;
        this.vendorId = vendorId;
        this.quantity = quantity;
        this.foodId = foodId;
        this.eta = eta;
        this.dateAndTime = dateAndTime;
        this.orderValue = orderValue;
        this.orderStatus = orderStatus;
    }

    // Customer Order History
    public Orders(int orderNo, String foodName, double foodPrice, int quantity, double orderValue,
            String eta, String dateAndTime, String orderStatus, String reason) {
        this.orderNo = orderNo;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.quantity = quantity;
        this.orderValue = orderValue;
        this.eta = eta;
        this.dateAndTime = dateAndTime;
        this.orderStatus = orderStatus;
        this.reason = reason;

    }

    // Vendor Order History
    public Orders(String foodName, double foodPrice, int noOfOrders, int sumQuantity, double orderValue,
            String dateAndTime, String orderStatus) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.noOfOrders = noOfOrders;
        this.sumQuantity = sumQuantity;
        this.orderValue = orderValue;
        this.dateAndTime = dateAndTime;
        this.orderStatus = orderStatus;

    }

    // Order Status Show
    public Orders(int orderNo, String foodName, double foodPrice, int quantity, String orderStatus, String eta,
            String dateAndTime, double orderValue, int cid) {
        this.orderNo = orderNo;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.quantity = quantity;
        this.orderValue = orderValue;
        this.orderStatus = orderStatus;
        this.eta = eta;
        this.dateAndTime = dateAndTime;
        this.customerId = cid;
    }

    public void setSumQuantity(int sum) {
        this.sumQuantity = sum;
    }

    public int getSumQuantity() {
        return this.sumQuantity;
    }

    public void setFoodName(String name) {
        this.foodName = name;
    }

    public void setFoodPrice(double price) {
        this.foodPrice = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setNoOfOrders(int no) {
        this.noOfOrders = no;
    }

    public int getNoOfOrders() {
        return this.noOfOrders;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getOrderNo() {
        return this.orderNo;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getVendorId() {
        return this.vendorId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getFoodId() {
        return this.foodId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getEta() {
        return this.eta;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getDateAndTime() {
        return this.dateAndTime;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    public double getOrderValue() {
        return this.orderValue;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;

    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setReason(String reason) {
        this.reason = reason;

    }

    public String getReason() {
        return this.reason;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Order No :" + orderNo + " Customer ID:" + customerId + " Vendor ID:" + vendorId + " Food ID:" + foodId
                + " Quantity:" + quantity + " ETA:" + eta + " Date And Time :" + dateAndTime + " Order Value:"
                + orderValue + " Order Status:" + orderStatus;
    }
}
