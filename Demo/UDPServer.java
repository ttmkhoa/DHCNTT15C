import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket(7777);
            System.out.println("UDP server da dc tao");

            byte arr[] = new byte[6000];

            while (true) {
                // nhan
                DatagramPacket nhan = new DatagramPacket(arr, arr.length);
                s.receive(nhan);

                String str = new String(nhan.getData(), 0, nhan.getLength());
                System.out.println("client >> " + str);

                // xuly...
                String str1 = str.toUpperCase();
                String str2 = (new Date()).toString();

                // goi pkt
                DatagramPacket goi = new DatagramPacket(str2.getBytes(), str2.getBytes().length, nhan.getAddress(),
                        nhan.getPort());
                s.send(goi);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
