import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class MathServiceImpl extends UnicastRemoteObject implements MathService{
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