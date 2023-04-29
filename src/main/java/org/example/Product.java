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
    private List<Double> purchasePrices;
    private List<Integer> purchaseQuantities;
    private List<Double> orderPrices;
    private List<Integer> orderQuantities;
    //constructor of Product class.
    public Product(String productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.purchasePrices = new ArrayList<>();
        this.purchaseQuantities = new ArrayList<>();
        this.orderPrices = new ArrayList<>();
        this.orderQuantities = new ArrayList<>();
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
        this.purchasePrices.add(price);
        this.purchaseQuantities.add(quantity);
        this.productLastPrice = price;
    }
    // this method modify quantity and adds price in List.
    public void order(int quantity) {
        this.quantity -= quantity;
        this.orderPrices.add(this.productPrice);
        this.orderQuantities.add(quantity);
    }
    public int getOrderQuantities(){
        int sum = 0;
        for(int value : orderQuantities){
            sum+=value;
        }
        return sum;
    }
    int getQuantity() {
        return this.quantity;
    }
    public double findAveragePrice() {
        double purchaseSum = 0;
        double purchaseQuantity = 0;
        if(!purchasePrices.isEmpty() && !purchaseQuantities.isEmpty()){
            for(int i=0; i< purchasePrices.size(); i++){
                purchaseSum+=this.purchasePrices.get(i) * this.purchaseQuantities.get(i);
                purchaseQuantity+=purchaseQuantities.get(i);
            }
        }
        return purchaseSum  / purchaseQuantity;
    }
    public double findProductProfit() {
        double averagePurchasePrice = findAveragePrice();
        double revenueOrder = 0;
        double revenueQuantity = 0;
        if(!orderPrices.isEmpty() && !orderQuantities.isEmpty()){
            for(int i=0; i< orderPrices.size(); i++){
                revenueOrder+=this.orderPrices.get(i) * this.orderQuantities.get(i);
                revenueQuantity+=orderQuantities.get(i);
            }
        }
        double averageOrderPrice = revenueOrder/revenueQuantity;
        double profitPerUnit = averageOrderPrice - averagePurchasePrice;
        return profitPerUnit * revenueQuantity;
    }
}