package pizzashop.payment;

public class CashPayment implements PaymentStrategy {
    public boolean pay(double amount) {
        System.out.println("💵 Бэлнээр " + amount + "₮ төлөгдлөө.");
        return true;
    }
    public String getName() { return "Бэлэн"; }
}
