class LinL{
    Node head;
    
    static class Node{
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next = null;
        }
    }
    
    public void insertAtBeginning(int d){
        Node newNode = new Node(d);
        newNode.next = head;
        head = newNode;
    }
    
    public void insertAtEnd(int d){
        if(head == null){
            Node newNode = new Node(d);
            head = newNode;
        }
        else{
            Node p = head;
            while(p.next!=null){
                p = p.next;
            }
            Node newNode = new Node(d);
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
    
    public void delete(int d){
        if(head.data == d){
            head = head.next;
            return;
        }
        Node p = head.next;
        Node q = head;
        while(p!=null){
            if(p.data == d){
                q.next = p.next;
                return;
            }
            p = p.next;
            q = q.next;
        }
    }
   
   public void insertAtPos(int pos, int d){
       if(pos == 0){
           Node newNode = new Node(d);
           newNode.next = head;
           head = newNode;
           return;
       }
       
       Node p = head.next;
       Node q = head;
       int c = 1;
       while(c != pos){
           p = p.next;
           q = q.next;
           c++;
       }
       Node newNode = new Node(d);
       newNode.next = p;
       q.next = newNode;
   }
   
    public void printList(){
        Node p = head;
        System.out.print("\nLinkedList:");
        while(p!=null){
            System.out.print(p.data+"->");
            p = p.next;
        }
        System.out.println();
    }


}

public class LL{
    public static void main(String[] args){
        LinL l = new LinL();
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Insert at Beginning");
        int test_case = sc.nextInt();
        System.out.println("Values");
        
        for(int i=0;i<test_case;i++){
           int a=sc.nextInt();
            l.insertAtBeginning(a);
        }*/
        
        
        l.insertAtEnd(25);
        l.insertAtEnd(23);
        l.insertAtEnd(24);
        l.insertAtEnd(27);
        l.insertAtEnd(28);
        l.insertAtEnd(23);
        

        l.printList();
        l.delete(27);
        l.printList();
        l.delete(28);
        l.printList();
        l.insertAtPos(3, 10);
        l.printList();
        l.insertAtPos(0, 10);
        l.printList();
    }
}