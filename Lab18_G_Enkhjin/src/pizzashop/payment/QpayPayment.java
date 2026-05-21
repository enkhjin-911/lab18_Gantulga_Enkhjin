package pizzashop.payment;

public class QpayPayment implements PaymentStrategy {
    private String phoneNumber;

    public QpayPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean pay(double amount) {
        System.out.println("📱 QPay (" + phoneNumber + ") дээрээс " + amount + "₮ таталаа.");
        return true;
    }

    public String getName() { return "QPay"; }
}
