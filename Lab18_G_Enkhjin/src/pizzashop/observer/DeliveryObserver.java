package pizzashop.observer;

import pizzashop.Order;

public class DeliveryObserver implements OrderObserver {
    public void onNewOrder(Order order) {
        System.out.println("🚗 Хүргэлт: 30 минутын дараа очно.");
    }
}
