/*
import java.rmi.RemoteException;
*/
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    public HelloServiceImpl() throws RemoteException {
        super();
    }

    public String sayHello(String name) throws RemoteException {
        String str = "Hello " + name;
        return str;
    }
}
