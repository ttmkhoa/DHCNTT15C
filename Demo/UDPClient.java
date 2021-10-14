import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket();
            while (true) {
                // goi
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                String str = br.readLine();
                byte[] data = str.getBytes();
                DatagramPacket pkt = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 7777);
                s.send(pkt);

                // nhan
                byte[] arr = new byte[6000];
                DatagramPacket nhan = new DatagramPacket(arr, arr.length);
                s.receive(nhan);
                String fromServer = new String(nhan.getData(), 0, nhan.getLength());
                System.out.println("server tra ve >> " + fromServer);

            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
