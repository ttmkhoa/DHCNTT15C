import java.io.*;
import java.net.*;
import java.util.*;

public class mulServer {
    final static String host = "225.6.7.8";
    final static int port = 7777;

    public static void main(String[] args) throws IOException, InterruptedException, UnknownHostException {
        System.setProperty("java.net.preferIPv4Stack", "true");
        try {
            InetAddress group = InetAddress.getByName(host);
            System.out.println("groupIP: " + group);
            // System.out.println("multicastServer da duoc tao tai dia chi: " +
            // InetAddress.getLocalHost());

            MulticastSocket msocket = new MulticastSocket();

            // DatagramSocket ds = new DatagramSocket();
            for (int i = 0; i < 100; i++) {
                String msg = "Message number " + i;
                byte[] data = msg.getBytes();

                DatagramPacket pkt = new DatagramPacket(data, data.length, group, port);
                msocket.send(pkt);

                System.out.println("sent: " + msg);
                Thread.sleep(700);

            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
