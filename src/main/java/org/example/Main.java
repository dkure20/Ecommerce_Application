package org.example;

import java.util.Scanner;
/*
   This is the main method of console based ecommerce-application, where you can input
   commands and program acts differenty. there are All methods implemented from main application +
   bonus. You can see implementation of each method in EccomerceApplication class.
 */
public class Main{
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ecommerce ec = new EcommerceApplication();
        while (true) {
            System.out.println("Enter command:");
            String command = scanner.next();
            switch (command) {
                case "save_product":
                    ec.saveProduct(scanner.next(), scanner.next(), scanner.nextDouble());
                    break;
                case "purchase_product":
                    ec.purchaseProduct(scanner.next(), scanner.nextInt(), scanner.nextDouble());
                    break;
                case "order_product":
                    ec.orderProduct(scanner.next(), scanner.nextInt());
                    break;
                case "get_quantity_of_product":
                    System.out.println(ec.getQuantityOfProduct(scanner.next()));
                    break;
                case "get_average_price":
                    System.out.println(ec.getAveragePrice(scanner.next()));
                    break;
                case "get_product_profit":
                    System.out.println(ec.getProductProfit(scanner.next()));
                    break;
                case "get_fewest_product":
                    System.out.println(ec.getFewestProduct());
                    break;
                case "get_most_popular_product":
                    System.out.println(ec.getMostPopularProduct());
                    break;
                case "get_orders_report":
                    System.out.println(ec.getOrdersReport());
                    break;
                case "export_orders_report":
                    System.out.println(ec.getExportOrder(scanner.next()));
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
