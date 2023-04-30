package org.example;
import java.util.ArrayList;
import java.util.List;
public class PurchaseHistory {
    private List<Integer> quantities;
    private List<Double> prices;

    public PurchaseHistory() {
        this.quantities = new ArrayList<>();
        this.prices = new ArrayList<>();
    }
    public void addPurchase(int quantity, double price) {
        this.quantities.add(quantity);
        this.prices.add(price);
    }
    public double getAveragePrice(){
        double purchaseSum = 0;
        double purchaseQuantity = 0;
        if(!prices.isEmpty() && !quantities.isEmpty()){
            for(int i=0; i< prices.size(); i++){
                purchaseSum+=this.prices.get(i) * this.quantities.get(i);
                purchaseQuantity+=quantities.get(i);
            }
        }
        return purchaseSum  / purchaseQuantity;
    }
}