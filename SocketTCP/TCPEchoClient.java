import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPEchoClient {
    public InetAddress serverAddr;
    public int port = 6789;
    public String clientName;
    public static Socket socket;

    public TCPEchoClient(String serverIP, int port, String clName) throws IOException {
        this.serverAddr = InetAddress.getByName(serverIP);
        this.port = port;
        this.clientName = clName;
        this.socket = new Socket(serverIP, port);
    }

    public static void main(String[] args) {
        try {
            // Socket s = new Socket("localhost", 6789);
            TCPEchoClient client = new TCPEchoClient(args[0], Integer.parseInt(args[1]), args[2]);

            System.out.println("CLIENT da duoc tao");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            for (int i = '0'; i <= '9'; i++) {
                os.write(i);

                int ch = is.read();
                System.out.println((char) ch);

                Thread.sleep(2000);
            }

            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
