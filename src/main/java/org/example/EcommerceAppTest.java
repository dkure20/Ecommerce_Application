package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EcommerceAppTest {
    private EcommerceApplication eccApp;

    @BeforeEach
    public void setUp(){
        eccApp = new EcommerceApplication();
    }
    @Test
    public void testSaveProduct(){
        eccApp.saveProduct("prod001","iphone", 2700);
        assertNotNull(eccApp.getProduct("prod001"));
        assertEquals(eccApp.getProduct("prod001").getProductName(), "iphone");
        assertEquals(eccApp.getProduct("prod001").getProductPrice(), 2700);
        eccApp.saveProduct("prod002","samsung", 1500);
        assertNotNull(eccApp.getProduct("prod002"));
        assertEquals(eccApp.getProduct("prod002").getProductName(), "samsung");
        assertEquals(eccApp.getProduct("prod002").getProductPrice(), 1500);
    }
    @Test
    public void testPurchaseProduct(){
        eccApp.saveProduct("prod001","iphone",2800);
        assertNotNull(eccApp.getProduct("prod001"));
        eccApp.purchaseProduct("prod001", 10,2500);
        assertEquals(10,eccApp.getProduct("prod001").getQuantity());
        eccApp.saveProduct("prod002","samsung",2000);
        eccApp.purchaseProduct("prod002", 20,3000);
        assertEquals(20,eccApp.getProduct("prod002").getQuantity());
    }
    @Test
    public void testOrderProduct(){
        eccApp.saveProduct("111","iphone",2800);
        assertNotNull(eccApp.getProduct("111"));
        eccApp.purchaseProduct("111", 10,2500);
        eccApp.orderProduct("111", 6);
        assertEquals(4,eccApp.getProduct("111").getQuantity());
        assertEquals(6,eccApp.getProduct("111").getOrderQuantities());
        assertEquals(2500,eccApp.getProduct("111").findAveragePrice());
    }
    @Test
    public void testWholeScenario(){
        eccApp.saveProduct("1","iphone",3500);
        assertNotNull(eccApp.getProduct("1"));
        eccApp.purchaseProduct("1", 10,2000);
        eccApp.purchaseProduct("1", 30,3000);
        assertEquals(40,eccApp.getProduct("1").getQuantity());
        assertEquals(2750,eccApp.getProduct("1").findAveragePrice());
        eccApp.orderProduct("1",5);
        eccApp.saveProduct("1","iphone",3800);
        assertEquals(35,eccApp.getProduct("1").getQuantity());
        eccApp.orderProduct("1",10);
        eccApp.saveProduct("1","iphone",4000);
        eccApp.orderProduct("1",15);
        assertEquals(10,eccApp.getProduct("1").getQuantity());
        assertEquals(33000,eccApp.getProduct("1").findProductProfit());
        assertEquals("iphone",eccApp.getFewestProduct());
        assertEquals("iphone",eccApp.getMostPopularProduct());
        eccApp.saveProduct("2","samsung",3500);
        eccApp.purchaseProduct("2", 5,2000);
        assertEquals("iphone",eccApp.getMostPopularProduct());
    }
    @Test
    public void testLowestAndPopular(){
        eccApp.saveProduct("3","xiaomi",3500);
        eccApp.purchaseProduct("3", 10,2000);
        eccApp.saveProduct("4","googlePixel",100);
        eccApp.purchaseProduct("4", 5,2000);
        assertEquals(10,eccApp.getQuantityOfProduct("3"));
        assertEquals(5,eccApp.getQuantityOfProduct("4"));
        assertEquals("googlePixel",eccApp.getFewestProduct());
        assertEquals("xiaomi",eccApp.getMostPopularProduct());
        eccApp.orderProduct("3", 7);
        eccApp.orderProduct("4",4);
        assertEquals("xiaomi",eccApp.getMostPopularProduct());
        assertEquals("googlePixel",eccApp.getFewestProduct());
    }
    @Test
    public void testAveragePrices(){
        assertEquals("",eccApp.getOrdersReport());
        eccApp.saveProduct("1", "macBook",5000);
        eccApp.purchaseProduct("1",25,4800);
        eccApp.purchaseProduct("1",15,5300);
        assertEquals(4987.5,eccApp.getAveragePrice("1"));
        eccApp.saveProduct("2", "iphone14",3200);
        eccApp.purchaseProduct("2",20,400);
        eccApp.purchaseProduct("2",10,200);
        eccApp.purchaseProduct("2",5,100);
        assertEquals(300,eccApp.getAveragePrice("2"));
    }
    @Test
    public void testOrdersReport(){
        eccApp.saveProduct("2", "iphone14",3200);
        eccApp.purchaseProduct("2",20,400);
        eccApp.purchaseProduct("2",10,200);
        eccApp.purchaseProduct("2",5,100);
        assertEquals("2",eccApp.getProduct("2").getProductId());
        assertEquals("iphone14",eccApp.getProduct("2").getProductName());
        assertEquals(100,eccApp.getProduct("2").purchasePrice());
        assertEquals(35,eccApp.getProduct("2").getQuantity());
        assertEquals(300,eccApp.getProduct("2").findAveragePrice());
        assertEquals(3200,eccApp.getProduct("2").getProductPrice());
    }
}
