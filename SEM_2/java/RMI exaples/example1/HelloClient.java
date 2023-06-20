/*import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
*/
import java.rmi.registry.*;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            HelloService helloService = (HelloService) registry.lookup("HelloService");
            String name = "Rajat";
            String response = helloService.sayHello(name);
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
