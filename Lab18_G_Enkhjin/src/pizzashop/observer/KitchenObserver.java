package pizzashop.observer;

import pizzashop.Order;

public class KitchenObserver implements OrderObserver {
    public void onNewOrder(Order order) {
        System.out.println("🍳 Гал тогоо: " + order.getPizzaName() + " бэлтгэж эхэллээ.");
    }
}
