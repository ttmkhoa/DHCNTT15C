import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcImplement extends UnicastRemoteObject implements CalcInterface {

    protected CalcImplement() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    public int tong(int a, int b) {
        return (a + b);
    }

    public int hieu(int a, int b) {
        return (a - b);
    }
}
