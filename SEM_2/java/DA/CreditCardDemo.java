class Card {
    protected String cardNo;
    protected String custName;
    protected String bankName;

    public Card(String cardNo, String custName, String bankName) {
        this.cardNo = cardNo;
        this.custName = custName;
        this.bankName = bankName;
    }
}

class CreditCard extends Card {
    private double limit;

    public CreditCard(String cardNo, String custName, String bankName, double limit) {
        super(cardNo, custName, bankName);
        this.limit = limit;
    }

    public void display() {
        System.out.println("Credit Card Details:");
        System.out.println("Card Number: " + cardNo);
        System.out.println("Customer Name: " + custName);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Limit: " + limit);
    }

    public void use(double amount) {
        if (amount <= limit) {
            limit -= amount;
            System.out.println("Amount used: " + amount);
            System.out.println("Remaining Limit: " + limit);
        } else {
            System.out.println("Insufficient limit. Transaction cannot be completed.");
        }
    }
}

public class CreditCardDemo {
    public static void main(String[] args) {
        CreditCard card1 = new CreditCard("123456789", "John Doe", "ABC Bank", 5000.0);
        CreditCard card2 = new CreditCard("987654321", "Jane Smith", "XYZ Bank", 10000.0);

        card1.display();
        System.out.println();

        card2.display();
        System.out.println();

        card1.use(2000.0);
        System.out.println();

        card2.use(15000.0);
        System.out.println();

        card2.use(5000.0);
    }
}
