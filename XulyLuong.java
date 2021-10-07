import java.io.*;
import java.net.*;

public class XulyLuong extends Thread {
    Socket s;

    public XulyLuong(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            while (true) {
                int ch = is.read();
                System.out.println((char) ch);
                if (ch == -1)
                    break;
                os.write(ch);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
