package pizzashop;

import pizzashop.factory.PizzaFactory;
import pizzashop.model.Pizza;
import pizzashop.decorator.*;
import pizzashop.payment.*;
import pizzashop.logger.OrderLogger;
import pizzashop.observer.*;

public class Main {
    public static void main(String[] args) {

        PizzaFactory factory = new PizzaFactory();
        OrderLogger logger = OrderLogger.getInstance();

        System.out.println("========================================");
        System.out.println("  🍕  MONGOL PIZZA — Захиалгын систем  ");
        System.out.println("========================================\n");

        // ── Хэсэг 1: Factory Method тест ──────────────────────
        System.out.println("[ Factory Method тест ]");
        Pizza f1 = factory.createPizza("margherita");
        Pizza f2 = factory.createPizza("pepperoni");
        Pizza f3 = factory.createPizza("veggie");
        Pizza f4 = factory.createPizza("bbq");
        System.out.println(f1.getName() + ": " + f1.getBasePrice() + "₮");
        System.out.println(f2.getName() + ": " + f2.getBasePrice() + "₮");
        System.out.println(f3.getName() + ": " + f3.getBasePrice() + "₮");
        System.out.println(f4.getName() + ": " + f4.getBasePrice() + "₮");

        // ── Хэсэг 2: Decorator тест ────────────────────────────
        System.out.println("\n[ Decorator тест ]");
        Pizza dec1 = new Mushroom(new ExtraCheese(factory.createPizza("margherita")));
        System.out.println(dec1.getName() + " → " + dec1.getBasePrice() + "₮");  // 18500
        Pizza dec2 = new Jalapeno(new Olives(factory.createPizza("bbq")));
        System.out.println(dec2.getName() + " → " + dec2.getBasePrice() + "₮");  // 24200

        // ── Хэсэг 4: Singleton тест ────────────────────────────
        System.out.println("\n[ Singleton тест ]");
        OrderLogger a = OrderLogger.getInstance();
        OrderLogger b = OrderLogger.getInstance();
        System.out.println("Same instance? " + (a == b));   // true
        a.log("Тест лог 1");
        b.log("Тест лог 2");
        System.out.println("History size: " + a.size());    // 2

        System.out.println("\n========================================");
        System.out.println("          ЗАХИАЛГУУД");
        System.out.println("========================================\n");

        // ── Захиалга 1: Margherita + бяслаг + мөөг, бэлэн ─────
        Pizza pz1 = new Mushroom(
                        new ExtraCheese(
                            factory.createPizza("margherita")));
        Order o1 = new Order(pz1);
        o1.setPaymentMethod(new CashPayment());
        // Observer нэмэх (Bonus)
        o1.addObserver(new KitchenObserver());
        o1.addObserver(new DeliveryObserver());
        o1.checkout();

        System.out.println("---");

        // ── Захиалга 2: BBQ + оливс + халуун чинжүү, карт ─────
        Pizza pz2 = new Jalapeno(
                        new Olives(
                            factory.createPizza("bbq")));
        Order o2 = new Order(pz2);
        o2.setPaymentMethod(new CardPayment("1234567890123456"));
        o2.addObserver(new KitchenObserver());
        o2.addObserver(new DeliveryObserver());
        o2.checkout();

        System.out.println("---");

        // ── Захиалга 3: Pepperoni + халуун чинжүү, QPay ────────
        Pizza pz3 = new Jalapeno(factory.createPizza("pepperoni"));
        Order o3 = new Order(pz3);
        o3.setPaymentMethod(new QpayPayment("99001122"));
        o3.addObserver(new KitchenObserver());
        o3.checkout();

        System.out.println("\n========================================");
        System.out.println("Нийт лог бичлэг: " + logger.size());

        // ── Bonus Adapter тест ──────────────────────────────────
        System.out.println("\n[ Adapter тест — LegacyPrinter ]");
        Printer printer = new ReceiptPrinterAdapter();
        printer.print("=== Mongol Pizza тасалбар ===");
        printer.print(pz1.getName() + "  " + pz1.getBasePrice() + "₮");
        printer.print("Баярлалаа! Дахин уулзатал!");
    }
}
