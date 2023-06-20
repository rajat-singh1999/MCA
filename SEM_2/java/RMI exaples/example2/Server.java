import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

interface MathService extends Remote{
    public int getSquare(int num) throws RemoteException;
    public double getSquareRoot(int num) throws RemoteException;
    public int getFact(int num) throws RemoteException;
}
class MathServiceImpl extends UnicastRemoteObject implements MathService{
    public MathServiceImpl() throws RemoteException{
        super();
    }
    public int getSquare(int num) throws RemoteException{
        return num*num;
    }
    public double getSquareRoot(int num) throws RemoteException{
        return Math.sqrt(num);
    }
    public int getFact(int num) throws RemoteException{
        int i=1;
        int f = 1;
        while(i<=num){
            f = f*i;
            i++;
        }
        return f;
    }
}
public class Server{
    public static void main(String args[]){
        try{
            MathService m = new MathServiceImpl();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("MathService", m);
            System.out.println("Math Service strated...");
        }
        catch(RemoteException e){
            e.printStackTrace();
        }
    }
}
