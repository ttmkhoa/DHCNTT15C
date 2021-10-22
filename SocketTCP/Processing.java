import java.net.Socket;
import java.io.*;

public class Processing extends Thread {
    Socket s;

    public Processing(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            OutputStream os = s.getOutputStream();
            InputStream is = s.getInputStream();
            GhiFile obj = new GhiFile();
            FileOutputStream fos1;
            fos1 = new FileOutputStream("E:\\testdir\\client1.txt");
            int n;
            while (true) {

                n = is.read();
                System.out.println((char) n);

                obj.Ghi(fos1, (char) n);

                if (n == -1)
                    break;
                os.write(n);
                //
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
