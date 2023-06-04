import java.util.Scanner;

class TelephoneIndex {
    private String[] names;
    private String[] phoneNumbers;

    public TelephoneIndex(int size) {
        names = new String[size];
        phoneNumbers = new String[size];
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter subscriber's name: ");
            names[i] = scanner.nextLine();
            System.out.print("Enter phone number: ");
            phoneNumbers[i] = scanner.nextLine();
        }
    }

    public void display() {
        System.out.println("Telephone Index:");
        for (int i = 0; i < names.length; i++) {
            System.out.println("Name: " + names[i] + ", Phone Number: " + phoneNumbers[i]);
        }
    }

    public void searchByName(String searchName) {
        boolean found = false;
        System.out.println("Search results:");
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Name: " + names[i] + ", Phone Number: " + phoneNumbers[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching names found.");
        }
    }
}

public class TelephoneIndexMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subscribers: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        TelephoneIndex telephoneIndex = new TelephoneIndex(size);

        telephoneIndex.input();

        System.out.println();

        telephoneIndex.display();

        System.out.print("\nEnter a name or the first few characters of a name to search: ");
        String searchName = scanner.nextLine();

        telephoneIndex.searchByName(searchName);

        scanner.close();
    }
}
