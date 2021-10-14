import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class mulServer {
    final static String host = "224.0.0.2";
    final static int port = 7777;

    public static void main(String[] args) throws IOException, InterruptedException, UnknownHostException {

        try {
            InetAddress addr = InetAddress.getByName(host);
            DatagramSocket ds = new DatagramSocket();
            for (int i = 0; i < 100; i++) {
                String msg = "Message number " + i;
                byte[] data = msg.getBytes();

                DatagramPacket pkt = new DatagramPacket(data, data.length, addr, port);
                ds.send(pkt);

                System.out.println("sent: " + msg);
                Thread.sleep(700);

            }
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
