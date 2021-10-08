import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient1 {
    public static void main(String[] args) throws InterruptedException {
        try {
            Socket s = new Socket("127.0.0.1", 6789);
            System.out.println("CLIENT DA~ DUOC TAO");

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            for (int i = 'a'; i <= 'k'; i++) {
                os.write(i);

                int ch = is.read();
                System.out.println((char) ch);

                Thread.sleep(2000);

            }

            s.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
