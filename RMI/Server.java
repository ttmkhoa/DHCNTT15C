import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            CalcImplement obj = new CalcImplement();
            System.out.println("khoi tao doi tuong calc thanh cong");

            LocateRegistry.createRegistry(7070);
            Registry reg = LocateRegistry.getRegistry(7070);
            reg.bind("Calculation", obj);
            System.out.println("da dang ky doi tuong Calculation voi registry");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
