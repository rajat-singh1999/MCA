import java.util.Scanner;

class ElectricityBill {
    private int consumerNo;
    private String consumerName;
    private double previousMonthReading;
    private double currentMonthReading;
    private String connectionType;

    public ElectricityBill(int consumerNo, String consumerName, double previousMonthReading, double currentMonthReading, String connectionType) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.previousMonthReading = previousMonthReading;
        this.currentMonthReading = currentMonthReading;
        this.connectionType = connectionType;
    }

    public double calculateBillAmount() {
        double unitsConsumed = currentMonthReading - previousMonthReading;
        double billAmount = 0.0;

        if (connectionType.equalsIgnoreCase("domestic")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 1.0;
            } else if (unitsConsumed <= 200) {
                billAmount = 100 * 1.0 + (unitsConsumed - 100) * 2.5;
            } else if (unitsConsumed <= 500) {
                billAmount = 100 * 1.0 + 100 * 2.5 + (unitsConsumed - 200) * 4.0;
            } else {
                billAmount = 100 * 1.0 + 100 * 2.5 + 300 * 4.0 + (unitsConsumed - 500) * 6.0;
            }
        } else if (connectionType.equalsIgnoreCase("commercial")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 2.0;
            } else if (unitsConsumed <= 200) {
                billAmount = 100 * 2.0 + (unitsConsumed - 100) * 4.5;
            } else if (unitsConsumed <= 500) {
                billAmount = 100 * 2.0 + 100 * 4.5 + (unitsConsumed - 200) * 6.0;
            } else {
                billAmount = 100 * 2.0 + 100 * 4.5 + 300 * 6.0 + (unitsConsumed - 500) * 7.0;
            }
        }

        return billAmount;
    }

    public void displayBill() {
        System.out.println("Electricity Bill");
        System.out.println("Consumer No.: " + consumerNo);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Previous Month Reading: " + previousMonthReading);
        System.out.println("Current Month Reading: " + currentMonthReading);
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Bill Amount: " + calculateBillAmount());
    }
}

public class ElectricBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Consumer No.: ");
        int consumerNo = scanner.nextInt();

        System.out.print("Enter Consumer Name: ");
        String consumerName = scanner.next();

        System.out.print("Enter Previous Month Reading: ");
        double previousMonthReading = scanner.nextDouble();

        System.out.print("Enter Current Month Reading: ");
        double currentMonthReading = scanner.nextDouble();

        System.out.print("Enter Connection Type (domestic or commercial): ");
        String connectionType = scanner.next();

        ElectricityBill bill = new ElectricityBill(consumerNo, consumerName, previousMonthReading, currentMonthReading, connectionType);
        bill.displayBill();

        scanner.close();
    }
}

