import java.rmi.registry.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        
        try{
            Registry reg = LocateRegistry.getRegistry(1099);
            MathService m = (MathService) reg.lookup("MathService");
            int square = m.getSquare(n);
            double sqroot = m.getSquareRoot(n);
            int fact = m.getFact(n);
            System.out.println(square + " " + sqroot + " " + fact);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
}
