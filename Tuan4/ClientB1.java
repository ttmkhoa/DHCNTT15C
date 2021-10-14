import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientB1 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 8888);
        System.out.println("CLIENT da ket noi");

        while (true) {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            int ch;
            try {
                System.out.println("Moi nhap so (0-9): ");
                ch = System.in.read();
                System.in.skip(2); // bo qua 2 ki tu tiep theo

                os.write(ch);

                byte b[] = new byte[1024];
                int n = is.read(b);
                String res = new String(b, 0, n);
                System.out.println("Server tra ve: " + res);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        // s.close();
    }
}
