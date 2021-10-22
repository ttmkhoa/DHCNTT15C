import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class uServer {
    public static void main(String[] args) throws IOException {
        try {
            InetAddress serverAddr = InetAddress.getByName("127.0.0.1");
            int port = 7070;

            DatagramSocket ds = new DatagramSocket(port);
            System.out.println("uServer da duoc tao.!");
            byte[] buf = new byte[512];
            while (true) {
                // nhan goi tin
                DatagramPacket inpkt = new DatagramPacket(buf, buf.length);
                ds.receive(inpkt);
                // lay du lieu tu goi tin byte -> string
                String instr = new String(inpkt.getData(), 0, inpkt.getLength());
                // xu ly
                int sumArr = 0;
                String[] n = instr.split(" ");
                for (int i = 0; i < n.length; i++) {
                    int temp = Integer.parseInt(n[i]);
                    sumArr = sumArr + temp;
                }
                System.out.println("Sum of ( " + instr + " ) = " + sumArr);
                // tao goi tin goi
                String outstr = "Sum from server = " + sumArr;
                DatagramPacket outpkt = new DatagramPacket(outstr.getBytes(), outstr.getBytes().length,
                        inpkt.getAddress(), inpkt.getPort());
                ds.send(outpkt);

            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
