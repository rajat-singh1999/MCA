import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {
    public static void main(String[] args) {
        try {
            HelloService helloService = new HelloServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HelloService", helloService);
            System.out.println("HelloService started...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
