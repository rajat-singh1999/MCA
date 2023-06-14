import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String productId;
    private String name;
    private String category;
    private double price;

    public Product(String productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters and setters

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + name + ", Category: " + category + ", Price: " + price;
    }
}

public class OnlineShoppingPlatform {
    private List<Product> inventory;

    public OnlineShoppingPlatform() {
        inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println("The product was added successfully!");
    }

    public void removeProduct(String productId) {
        boolean removed = false;
        for (Product product : inventory) {
            if (product.getProductId().equals(productId)) {
                inventory.remove(product);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("The product was removed successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void updateProductPrice(String productId, double newPrice) {
        boolean updated = false;
        for (Product product : inventory) {
            if (product.getProductId().equals(productId)) {
                product.setPrice(newPrice);
                updated = true;
                break;
            }
        }
        if (updated) {
            System.out.println("The price was updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void showProductsInRange(double minPrice, double maxPrice) {
        System.out.println("Products within price range:");
        for (Product product : inventory) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                System.out.println("- " + product.toString());
            }
        }
    }

    public void searchProduct(String searchKey) {
        System.out.println("Search results:");
        for (Product product : inventory) {
            if (product.getProductId().equals(searchKey) || product.getName().equalsIgnoreCase(searchKey)) {
                System.out.println("- " + product.toString());
            }
        }
    }

    public static void main(String[] args) {
        OnlineShoppingPlatform platform = new OnlineShoppingPlatform();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Online Shopping Platform!");
        System.out.println("-----------------------------------------------");

        do {
            System.out.println("1. Add a new product");
            System.out.println("2. Remove a product");
            System.out.println("3. Update a product's price");
            System.out.println("4. Show all products within a price range");
            System.out.println("5. Search for a product");
            System.out.println("6. Exit");
            System.out.println("-----------------------------------------------");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    platform.addProduct(new Product(productId, name, category, price));
                    break;
                case 2:
                    System.out.print("Enter Product ID to be removed: ");
                    String removeId = scanner.nextLine();
                    platform.removeProduct(removeId);
                    break;
                case 3:
                    System.out.print("Enter Product ID for price update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    platform.updateProductPrice(updateId, newPrice);
                    break;
                case 4:
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();
                    scanner.nextLine();
                    platform.showProductsInRange(minPrice, maxPrice);
                    break;
                case 5:
                    System.out.print("Enter product ID or name to search: ");
                    String searchKey = scanner.nextLine();
                    platform.searchProduct(searchKey);
                    break;
                case 6:
                    System.out.println("Thank you for using the Online Shopping Platform!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 6);
    }
}
