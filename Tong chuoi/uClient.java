import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class uClient {
    public static void main(String[] args) {
        try {
            InetAddress serverAddr = InetAddress.getByName("127.0.0.1");
            int port = 7070;

            DatagramSocket ds = new DatagramSocket();
            System.out.println("Client da tao socket");

            while (true) {
                // chuan bi dlieu va goi pkt
                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(in);
                String outstr = br.readLine();
                byte[] outdata = outstr.getBytes(); // str ->byte
                DatagramPacket outpkt = new DatagramPacket(outdata, outdata.length, serverAddr, port);
                ds.send(outpkt);

                // nhan va hien thi ket qua ra man hinh
                byte[] indata = new byte[512];
                DatagramPacket inpkt = new DatagramPacket(indata, indata.length);
                ds.receive(inpkt);
                String instr = new String(inpkt.getData(), 0, inpkt.getLength());
                System.out.println(instr);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
