package pizzashop;

import pizzashop.model.Pizza;
import pizzashop.payment.PaymentStrategy;
import pizzashop.logger.OrderLogger;
import pizzashop.observer.OrderObserver;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Pizza pizza;
    private PaymentStrategy payment;
    private List<OrderObserver> observers = new ArrayList<>();

    public Order(Pizza pizza) {
        this.pizza = pizza;
    }

    // Strategy: run-time-д төлбөрийн арга солих
    public void setPaymentMethod(PaymentStrategy p) {
        this.payment = p;
    }

    // Observer: дагаач нэмэх
    public void addObserver(OrderObserver o) {
        observers.add(o);
    }

    // Observer-уудыг дуудах
    private void notifyObservers() {
        for (OrderObserver o : observers) {
            o.onNewOrder(this);
        }
    }

    public String getPizzaName() {
        return pizza.getName();
    }

    public void checkout() {
        OrderLogger logger = OrderLogger.getInstance();
        double total = pizza.getBasePrice();

        logger.log("Шинэ захиалга: " + pizza.getName());
        System.out.println("Захиалга: " + pizza.getName());
        System.out.println("Найрлага: " + pizza.getIngredients());
        System.out.println("Үнэ: " + total + "₮");

        if (payment == null)
            throw new IllegalStateException("Төлбөрийн арга сонгоогүй!");

        boolean success = payment.pay(total);

        if (success) {
            logger.log("Төлбөр: " + payment.getName() + " — " + total + "₮");
            logger.log("Захиалга амжилттай боллоо");
            notifyObservers();
        }
    }
}
