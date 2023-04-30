package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Integer> quantities;
    private List<Double> prices;
    public OrderHistory() {
        this.quantities = new ArrayList<>();
        this.prices = new ArrayList<>();
    }
    public void addOrder(int quantity,double price){
        this.quantities.add(quantity);
        this.prices.add(price);
    }
    public int ordersQuantity(){
        int sum = 0;
        for(int value : quantities){
            sum+=value;
        }
        return sum;
    }
    public double profitFromOrders(double avgPrice){
        double revenueOrder = 0;
        double revenueQuantity = 0;
        if(!prices.isEmpty() && !quantities.isEmpty()){
            for(int i=0; i< prices.size(); i++){
                revenueOrder+=this.prices.get(i) * this.quantities.get(i);
                revenueQuantity+=quantities.get(i);
            }
        }
        double averageOrderPrice = revenueOrder/revenueQuantity;
        double profitPerUnit = averageOrderPrice - avgPrice;
        return profitPerUnit * revenueQuantity;
    }
}
