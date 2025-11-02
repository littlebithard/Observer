package Observer.TypesOfSubscribers;

import Observer.Interface.IObserver;

public class AppSubscriber implements IObserver {
    private String name;
    private String deviceId;

    public AppSubscriber(String name, String deviceId) {
        this.name = name;
        this.deviceId = deviceId;
    }

    public void update(String productName, String status, float price) {
        sendPushNotification(productName, status, price);
    }

    public String getName() {
        return name;
    }

    private void sendPushNotification(String productName, String status, float price) {
        System.out.println(" Push to device " + deviceId);
        System.out.println("\n" + productName + " - " + status + " (" + price + ")");
        System.out.println();
    }
}
