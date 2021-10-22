import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class u2Client {
    public static DatagramSocket udpSocket;
    public static InetAddress serverAddr;
    public static int port;
    public static Scanner scanner;

    public u2Client(String destAddrr, int port) throws UnknownHostException, SocketException {
        u2Client.serverAddr = InetAddress.getByName(destAddrr);
        u2Client.port = port;
        u2Client.udpSocket = new DatagramSocket(u2Client.port);
        u2Client.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        try {
            u2Client sender = new u2Client(args[0], Integer.parseInt(args[1]));
            System.out.println("Client da tao socket tai dia chi: " + InetAddress.getLocalHost());

            while (true) {
                // chuan bi dlieu va goi pkt
                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(in);
                String outstr = br.readLine();
                byte[] outdata = outstr.getBytes(); // str ->byte
                DatagramPacket outpkt = new DatagramPacket(outdata, outdata.length, serverAddr, port);
                udpSocket.send(outpkt);

                // nhan va hien thi ket qua ra man hinh
                byte[] indata = new byte[512];
                DatagramPacket inpkt = new DatagramPacket(indata, indata.length);
                udpSocket.receive(inpkt);
                String instr = new String(inpkt.getData(), 0, inpkt.getLength());
                System.out.println(instr);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
