class ProductData {
    public String productName;
    public double costPrice;
    public double sellingPrice;

    public ProductData(String productName, double costPrice, double sellingPrice) {
        this.productName = productName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
    }

    public void printProduct() {
        System.out.println("Product Name: " + productName);
        System.out.println("Cost Price: " + costPrice);
        System.out.println("Selling Price: " + sellingPrice);
    }
}

class ProfitLossCalculation extends ProductData {
    public ProfitLossCalculation(String productName, double costPrice, double sellingPrice) {
        super(productName, costPrice, sellingPrice);
    }

    public void calculate() {
        double profitLoss = sellingPrice - costPrice;
        String result = (profitLoss > 0) ? "Profit" : "Loss";
        System.out.println("Profit/Loss: " + result);
        System.out.println("Amount: " + Math.abs(profitLoss));
    }
}

public class ProfitLoss {
    public static void main(String[] args) {
        // Create product instances
        ProductData product1 = new ProductData("Product 1", 100.0, 120.0);
        ProductData product2 = new ProductData("Product 2", 50.0, 40.0);
        ProductData product3 = new ProductData("Product 3", 200.0, 180.0);

        // Print product information
        product1.printProduct();
        System.out.println();

        product2.printProduct();
        System.out.println();

        product3.printProduct();
        System.out.println();

        // Calculate profit/loss for each product
        ProfitLossCalculation p1 = new ProfitLossCalculation("Product 1", 100.0, 120.0);
        p1.calculate();
        System.out.println();

        ProfitLossCalculation p2 = new ProfitLossCalculation("Product 2", 50.0, 40.0);
        p2.calculate();
        System.out.println();

        ProfitLossCalculation p3 = new ProfitLossCalculation("Product 3", 200.0, 180.0);
        p3.calculate();
    }
}
