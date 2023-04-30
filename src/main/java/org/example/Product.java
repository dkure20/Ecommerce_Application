package org.example;
import java.util.ArrayList;
import java.util.List;

public class Product implements ProductRequirements{
    private String productId;
    private String productName;
    private double productPrice;
    private int quantity;
    private String report;
    private double productLastPrice;
    private PurchaseHistory purchaseHistory;
    private OrderHistory orderHistory;
    //constructor of Product class.
    public Product(String productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.purchaseHistory = new PurchaseHistory();
        this.orderHistory = new OrderHistory();
    }
    // here are some getters, setter methods for this class.
    public String getProductName(){
        return this.productName;
    }
    public String getProductId(){
        return this.productId;
    }
    public double getProductPrice(){
        return this.productPrice;
    }
    public double purchasePrice(){
        return this.productLastPrice;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setProductId(String productId){
        this.productId = productId;
    }
    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }
    public void setOrder(String report){
        this.report =report;
    }
    public String getOrder(){
        return this.report;
    }
    // this method adds quantity and price in List.
    public void purchase(int quantity, double price) {
        this.quantity += quantity;
        this.productLastPrice = price;
        purchaseHistory.addPurchase(quantity,price);
    }
    // this method modify quantity and adds price in List.
    public void order(int quantity) {
        this.quantity -= quantity;
        orderHistory.addOrder(quantity,this.productPrice);
    }
    public int getQuantity() { return this.quantity; }
    public int getOrderQuantities(){
        return orderHistory.ordersQuantity();
    }
    public double findAveragePrice() {
        return this.purchaseHistory.getAveragePrice();
    }
    public double findProductProfit() { return orderHistory.profitFromOrders(findAveragePrice()); }
}