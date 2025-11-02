package Observer;

import Observer.Interface.*;
import Observer.Product.*;
import Observer.TypesOfSubscribers.*;

public class Main {
    public static void main(String[] args) {
        Product iphone = new Product("iPhone 15 Pro", 321);
        Product ps5 = new Product("PlayStation 5", 123);
        
        subscribeCustomersToProducts(iphone, ps5);
        
        displayRestocking(iphone);
        displayPriceChange(ps5);
        displayUnsubscribe(iphone);
        displayNewSubscriber(ps5);
        displayOutOfStock(ps5);
    }
    
    private static void subscribeCustomersToProducts(Product iphone, Product ps5) {
        printSection("Customer Subscriptions");
        
        IObserver A1 = new EmailSubscriber("A1", "a1@email.com");
        IObserver B1 = new AppSubscriber("B1", "b1");
        IObserver C1 = new VipSubscriber("C1", "c1@email.com", 15);
        
        iphone.subscribe(A1);
        iphone.subscribe(B1);
        iphone.subscribe(C1);
        
        ps5.subscribe(B1);
        ps5.subscribe(C1);
    }
    
    private static void displayRestocking(Product product) {
        printSection("Scenario 1: Product Restock");
        product.restock(100);
    }
    
    private static void displayPriceChange(Product product) {
        printSection("Scenario 2: Price Change");
        product.restock(50);
        product.updatePrice(231);
    }
    
    private static void displayUnsubscribe(Product product) {
        printSection("Scenario 3: Customer Unsubscribes");
        IObserver bob = new EmailSubscriber("A1", "a1@email.com");;
        product.unsubscribe(bob);
        product.updatePrice(432);
    }
    
    private static void displayNewSubscriber(Product product) {
        printSection("Scenario 4: New Customer Subscribes");
        IObserver eve = new AppSubscriber("B1", "b1");
        product.subscribe(eve);
        product.updatePrice(234);
    }
    
    private static void displayOutOfStock(Product product) {
        printSection("Scenario 5: Product Sold Out");
        product.markOutOfStock();
    }

    private static void printSection(String title) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(title);
        System.out.println("=".repeat(50));
    }
}
