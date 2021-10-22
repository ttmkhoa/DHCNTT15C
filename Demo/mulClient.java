import java.net.*;
import java.util.*;

public class mulClient {
    public static int port = 7777;

    public static void main(String[] args) {
        System.setProperty("java.net.preferIIPv4Stack", "true");

        try {
            InetAddress group = InetAddress.getByName("225.6.7.8");
            MulticastSocket msocket = new MulticastSocket(port);
            msocket.joinGroup(group);

            byte[] buf = new byte[512];
            while (true) {
                DatagramPacket nhan = new DatagramPacket(buf, buf.length);
                msocket.receive(nhan);
                String str = new String(buf, 0, buf.length);
                System.out.println("nhan tu server: " + str);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
