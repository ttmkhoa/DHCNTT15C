import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcInterface extends Remote {
    public int tong(int a, int b) throws RemoteException;

    public int hieu(int a, int b) throws RemoteException;
}
