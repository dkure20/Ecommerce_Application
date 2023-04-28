package org.example;

public interface ProductRequirements {
    void purchase(int quantity,double price);
    void order(int quantity);
    int getOrderQuantities();
    double findAveragePrice();
    double findProductProfit();
}
