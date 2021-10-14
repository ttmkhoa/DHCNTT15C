import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerB1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("SERVER B1 is running....");
        while (true) {
            Socket s;
            try {
                s = ss.accept();
                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();

                while (true) {
                    int ch = is.read();
                    String res = "";
                    switch (ch) {
                        case '0':
                            res = "Khong";
                            break;
                        case '1':
                            res = "Mot";
                            break;
                        default:
                            res = "Khong phai so nguyen";

                    }
                    // goi res ve cho client
                    os.write(res.getBytes());
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // dong ket noi
            // s.close();
        }
    }
}
