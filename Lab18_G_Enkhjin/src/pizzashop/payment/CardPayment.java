package pizzashop.payment;

public class CardPayment implements PaymentStrategy {
    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean pay(double amount) {
        String masked = "****" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("💳 Карт " + masked + " дээрээс " + amount + "₮ таталаа.");
        return true;
    }

    public String getName() { return "Банкны карт"; }
}
