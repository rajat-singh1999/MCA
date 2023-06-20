import java.rmi.*;

public interface MathService extends Remote{
    public int getSquare(int num) throws RemoteException;
    public double getSquareRoot(int num) throws RemoteException;
    public int getFact(int num) throws RemoteException;
}
