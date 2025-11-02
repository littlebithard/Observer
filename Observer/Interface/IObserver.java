package Observer.Interface;

public interface IObserver {
    void update(String productName, String status, float price);

    String getName();
}
