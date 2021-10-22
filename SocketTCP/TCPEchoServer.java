import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// client('0' -> '9')  -> server
//client <- server ('0' -> '9')

public class TCPEchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6789);
            System.out.println("SERVER da duoc tao");
            while (true) {
                Socket s = ss.accept();

                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();

                int ch = 0;
                while (true) {
                    ch = is.read();
                    if (ch == -1)
                        break;
                    System.out.println((char) ch);
                    os.write(ch);
                }
                // s.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
