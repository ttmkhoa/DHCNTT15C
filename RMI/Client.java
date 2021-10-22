import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws NotBoundException {
        Registry reg;
        try {
            reg = LocateRegistry.getRegistry(7070);
            CalcInterface cItf = (CalcInterface) reg.lookup("Calculation");

            System.out.println("5+6 = " + cItf.tong(5, 6));
            System.out.println("16-9 = " + cItf.hieu(16, 9));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
