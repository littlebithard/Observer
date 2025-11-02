package Observer.TypesOfSubscribers;

import Observer.Interface.IObserver;

public class EmailSubscriber implements IObserver {
    private String name;
    private String email;

    public EmailSubscriber(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void update(String productName, String status, float price) {
        sendEmail(productName, status, price);
    }

    public String getName() {
        return name;
    }

    private void sendEmail(String productName, String status, float price) {
        System.out.println(" Email to " + email);
        System.out.println(" Product: " + productName);
        System.out.println(" Status: " + status);
        System.out.println(" Price: " + price);
        System.out.println();
    }
}