package Observer.TypesOfSubscribers;

import Observer.Interface.IObserver;

public class VipSubscriber implements IObserver {
    private String name;
    private String email;
    private float discountRate;

    public VipSubscriber(String name, String email, float discountRate) {
        this.name = name;
        this.email = email;
        this.discountRate = discountRate;
    }

    public void update(String productName, String status, float price) {
        sendVipEmail(productName, status, price);
    }

    public String getName() {
        return name;
    }

    private void sendVipEmail(String productName, String status, float price) {
        float vipPrice = calculateVipPrice(price);

        System.out.println("   Vip email to " + email);
        System.out.println("   Product: " + productName);
        System.out.println("   Status: " + status);
        System.out.println("   Regular: " + price);
        System.out.println("   Your Vip Price: " + formatPrice(vipPrice));
        System.out.println();
    }

    private float calculateVipPrice(float price) {
        return price * (1 - discountRate / 100);
    }

    private String formatPrice(float price) {
        return String.format("%.2f", price);
    }
}