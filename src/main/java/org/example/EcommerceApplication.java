package org.example;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
This class provides implementation of main functions which were mentioned in main class, I decided to
store information in hashmap, with key String which stores productId, and value is Product Class, which
have all functionality.
 */
public class EcommerceApplication extends Product implements EccomerceInterface{
    private static Map<String, Product> products= new HashMap<>();
    public EcommerceApplication() {
        super();
    }
    // Add a new product to the catalog or modify an existing one.
    public void saveProduct(String productId, String productName, double productPrice) {
        if(products.containsKey(productId)){
            Product product = products.get(productId);
            product.setProductName(productName);
            product.setProductPrice(productPrice);
            products.put(productId, product);
            return;
        }
        Product product = new Product(productId, productName, productPrice);
        products.put(productId, product);
    }
    //Purchase a product, increasing its balance based on the specified quantity.
    public void purchaseProduct(String productId, int quantity, double price) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        product.purchase(quantity, price);
    }
    //Place an order for the product, decreasing its balance according to the specified quantity.
    public void orderProduct(String productId, int quantity) {
        Product product = products.get(productId);
        if (product.getQuantity() >= quantity) {
            product.order(quantity);
            return;
        }
        System.out.println("Product not found or not enough quantity.");
    }
    // Return the remaining quantity of a specific product.
    public int getQuantityOfProduct(String productId) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return -1;
        }
        return product.getQuantity();
    }
    //Calculate and display the average price of a specific product based on its purchase history.
    public double getAveragePrice(String productId) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return -1;
        }
        return product.findAveragePrice();
    }
    //Calculate and display the profit earned from a specific product
    //by comparing the average purchase price with the average order price.
    public double getProductProfit(String productId) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return -1;
        }
        return product.findProductProfit();
    }
    //Return the name of the product with the lowest remaining quantity.
    public String getFewestProduct() {
        if(products.isEmpty()){
            System.out.println("No products Available");
            return "";
        }
        return findFewestProduct();
    }
    // this is the helper function of getFewestProduct
    public String findFewestProduct() {
        int min = Integer.MAX_VALUE;
        String fewest = "";
        for(Product product : products.values()){
            if(product.getQuantity() < min){
                min = product.getQuantity();
                fewest = product.getProductName();
            }
        }
        return fewest;
    }
    //Return the name of the product with the highest number of orders.
    public String getMostPopularProduct() {
        if(products.isEmpty()){
            System.out.println("No products Available");
            return "";
        }
        return findPopular();
    }

    private String findPopular() {
        int max = Integer.MIN_VALUE;
        String popular = "";
        for(Product product : products.values()){
            if(product.getOrderQuantities() > max){
                max = product.getOrderQuantities();
                popular = product.getProductName();
            }
        }
        return popular;
    }
    //Generate a report of all orders, including the product ID, product name, quantity,
   // price, cost of goods sold (COGS), and selling price. Everything is stored in one string.
    public String getOrdersReport() {
        System.out.println("check");
        String res = "";
        for(String product : products.keySet()){
            Product prod = products.get(product);
            res+= "productId: " + prod.getProductId() + ",";
            res+= "productName: " + prod.getProductName() + ",";
            res+= "OrderQuantity: " + prod.getOrderQuantities() + ",";
            res+= "COGS" + prod.findAveragePrice() + ",";
            res+= "Selling Price: " + prod.getProductPrice() + ",";
            res+= "Price: " + prod.purchasePrice() + ".";
            res+= "\n";
            prod.setOrder(res);
        }
        return res;
    }
    //Export the report generated by the get_orders_report command to a CSV
    //file at the specified file path.
    public boolean getExportOrder(String path) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            List<String[]> ls = new ArrayList<>();
            for(String product : products.keySet()){
                Product prod = products.get(product);
                String report = prod.getOrder();
                String[] data = report.split(",");
                ls.add(data);
            }
            csvWriter.writeAll(ls);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}