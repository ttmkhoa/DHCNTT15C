import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerSS {
    public static void main(String[] args) {
        ServerSocket ss;
        try {
            ss = new ServerSocket(6789);
            System.out.println("SERVER song song DA~ DUOC TAO");
            while (true) {
                Socket s = ss.accept();

                XulyLuong p = new XulyLuong(s);
                p.start();

                // ss.close();

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
