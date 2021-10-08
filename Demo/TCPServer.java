import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket ss;
        try {
            ss = new ServerSocket(6789);
            System.out.println("SERVER DA~ DUOC TAO");
            while (true) {
                Socket s = ss.accept();

                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();

                while (true) {
                    int ch = is.read();
                    System.out.println((char) ch);
                    if (ch == -1)
                        break;
                    os.write(ch);
                }
                // ss.close();

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}