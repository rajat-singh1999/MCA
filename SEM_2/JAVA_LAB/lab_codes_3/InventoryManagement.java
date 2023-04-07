class Category{
    private String catID, catName;
    public Category(String x, String y){
        catID = x;
        catName = y;
    }

    public String getID(){
        return catID;
    }

    public String getCategory(){
        return catName;
    }

    public void showString(){
        System.out.println("The category ID is " + catID);
        System.out.println("The category Name is " + catName);
    }
}

class Product{
    public String productID, name;
    public double price;
    public Category category;

    public Product(String prodID, String name, double price, Category ob){
        productID = prodID;
        this.name = name;
        this.price = price;
        category = new Category(ob.getID(), ob.getCategory());
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void showString(){
        System.out.println("Product ID: " + productID);
        System.out.println("Product name: " + name);
        System.out.println("Category: " + category.getCategory());
        System.out.println("Product price: " + price);
    }
}
class LL{
    Node head;
    
    static class Node{
        Product p;
        Node next;
        
        Node(String prodID, String name, double price, Category ob){
            p = new Product(prodID, name, price, ob);
            next = null;
        }
    }
    
    public void insertAtEnd(String prodID, String name, double price, Category ob){
        if(head == null){
            Node newNode = new Node(prodID, name, price, ob);
            head = newNode;
        }
        else{
            Node p = head;
            while(p.next!=null){
                p = p.next;
            }
            Node newNode = new Node(prodID, name, price, ob);
            newNode.next = null;
            p.next = newNode;
        }
    }
    
    public void deleteAtFront(){
        if(head == null)
            System.out.println("List is empty! Nothing to print!");
        else{
            head = head.next;
            }
    }
    
    public void deleteEnd(){
        if(head == null)
            System.out.println("List is empty! Nothing to print!");
        else{
            Node p = head.next;
            Node q = head;
            while(p.next!=null){
                p = p.next;
                q = q.next;
            }
            q.next = null;
            
        }
    }
    
    public void delete(String ID){
        if(head.p.productID ==  ID){
            head = head.next;
            return;
        }
        Node k = head.next;
        Node q = head;
        while(k!=null){
            if(k.p.productID ==  ID){
                q.next = k.next;
                return;
            }
            k = k.next;
            q = q.next;
        }
        System.out.println("Product with product ID: " + ID + " does not exist.");
    }
    
    public Product search(String ID){
        if(head.p.productID.compareTo(ID) == 0){
            return head.p;
        }
        Node k = head.next;
        Node q = head;
        while(k!=null){
            if(k.p.productID.compareTo(ID) == 0){
                return k.p;
            }
            k = k.next;
            q = q.next;
        }
        return null;
    }

    public Product getElementAt(int index){
        
        int i = 0;
        Node temp = head;
        while(temp!=null){
            if(i==index)
                return temp.p;
            temp = temp.next;
            i++;
        }
        return null;
        
    }

    public void printList(){
        Node temp = head;
        System.out.print("\n");
        while(temp!=null){
            temp.p.showString();
            temp = temp.next;
            System.out.println("\n");
        }
        System.out.println("\n");
    }
}

class Inventory{
    private LL pList = new LL();
    private int num;
    Inventory(int n){
        num = 0;
    }
    public int getSize(){
        return num;
    }
    public void addProduct(Product product){
        pList.insertAtEnd(product.productID, product.name, product.price, product.category);
        num++;
    }

    public void removeProduct(String productID){
        pList.delete(productID);
        num--;
    }

    public void updateProductPrice(String productID, double newPrice){
        Product temp = pList.search(productID);
        if(temp == null){
            System.out.println("The product was nnot found.");
            return;
        }
        temp.setPrice(newPrice);
        removeProduct(productID);
        addProduct(temp);
    }

    public LL searchProductByCategory(Category cat){
        LL ans = new LL();
        for(int i=0;i<num;i++){
            Product temp = pList.getElementAt(i);
            String temp_cat = temp.category.getCategory();
            if(temp_cat.compareTo(cat.getCategory()) == 0){
                ans.insertAtEnd(temp.productID, temp.name, temp.price, temp.category);
            }
        }
        return ans;
    }

    public void displayInventory(){
        System.out.println("HERE IS THE ENTIRE INVENTORY");
        pList.printList();
    }

}

public class InventoryManagement{
    public static void main(String args[]){
        Inventory I = new Inventory(10);
        Category cosmetic = new Category("cat1", "Cosmetic");
        Category junk = new Category("cat2", "Junk Food");
        I.addProduct(new Product("01", "Mama Earth Shampoo", 350, cosmetic));
        I.addProduct(new Product("02", "Baldness Palm Oil", 233, cosmetic));
        I.addProduct(new Product("03", "God's Nector Coldrink", 50, junk));
        I.addProduct(new Product("04", "Hell's Kitchen Nachos", 70, junk));
        I.addProduct(new Product("05", "Evergreen Cheese Balls", 100, junk));

        I.displayInventory();

        System.out.println("Removing cheese balls using product id and then printing the list again.");

        I.removeProduct("03");
        I.displayInventory();

        System.out.println("Adding a new product using the id of the removed product");
        I.addProduct(new Product("03", "Papa John's Fingers", 150, junk));
        I.displayInventory();

        System.out.println("Updating price of Product with id 02");
        I.updateProductPrice("02", 269);
        I.displayInventory();

        System.out.println("Showing products that are of category junk.");
        LL junkCategoryList = I.searchProductByCategory(junk);
        junkCategoryList.printList();
    }
}

