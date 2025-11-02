package Observer.Product;

import java.util.List;
import java.util.ArrayList;
import Observer.Interface.*;

public class Product implements ISubject {
    private List<IObserver> subscribers;
    private String name;
    private float price;
    private int stock;
    private boolean available;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.stock = 0;
        this.available = false;
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(IObserver observer) {
        subscribers.add(observer);
        logSubscription(observer.getName());
    }

    public void unsubscribe(IObserver observer) {
        subscribers.remove(observer);
        logUnsubscription(observer.getName());
    }

    public void notifyObservers() {
        String status = available ? "NOW AVAILABLE" : "OUT OF STOCK";
        logNotification();

        for (IObserver observer : subscribers) {
            observer.update(name, status, price);
        }
    }

    public void restock(int quantity) {
        stock += quantity;
        available = true;
        logRestock(quantity);
        notifyObservers();
    }

    public void updatePrice(float newPrice) {
        if (priceHasChanged(newPrice)) {
            price = newPrice;
            logPriceChange();
            notifyObservers();
        }
    }

    public void markOutOfStock() {
        available = false;
        stock = 0;
        logOutOfStock();
        notifyObservers();
    }

    public boolean priceHasChanged(float newPrice) {
        return newPrice != price;
    }

    public void logSubscription(String customerName) {
        System.out.println(customerName + " subscribed to " + name);
    }

    public void logUnsubscription(String customerName) {
        System.out.println(customerName + " unsubscribed from " + name);
    }

    public void logNotification() {
        System.out.println("\n Notifying " + subscribers.size() + " subscriber(s)...\n");
    }

    public void logRestock(int quantity) {
        System.out.println("\n RESTOCK: " + quantity + " units of " + name);
    }

    public void logPriceChange() {
        System.out.println("\n PRICE UPDATE: " + name + " now $" + price);
    }

    public void logOutOfStock() {
        System.out.println("\n OUT OF STOCK: " + name);
    }
}