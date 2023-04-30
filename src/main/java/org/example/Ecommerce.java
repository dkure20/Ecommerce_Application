package org.example;
/*
The interface of ecommerceApplication. Main methods are described here, you can see implementation of each,
in ecommerceApplication java class.
 */
public interface Ecommerce {
    void saveProduct(String productId, String productName, double productPrice);
    void purchaseProduct(String productId, int quantity, double price);
    void orderProduct(String productId, int quantity);
    int getQuantityOfProduct(String productId);
    double getAveragePrice(String productId);
    double getProductProfit(String productId);
    String getFewestProduct();
    String findFewestProduct();
    String getOrdersReport();
    String getMostPopularProduct();
    boolean getExportOrder(String path);
}
