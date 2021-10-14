import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerB1b {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(7777);
        System.out.println("Server B1b is running.....");

        DataInputStream dis = null;
        DataOutputStream dos = null;
        while (true) {
            try {
                Socket s = ss.accept();

                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());

                String line = "";

                while (true) {
                    line = dis.readUTF();
                    char ch[] = line.toCharArray();
                    if (Character.isDigit(ch[0])) {
                        int i = Integer.parseInt(line);
                        switch (i) {
                            case 0:
                                line = "khong";
                                break;
                            case 1:
                                line = "mot";
                                break;
                            case 2:
                                line = "hai";
                                break;

                        }
                        dos.writeUTF(line);
                    } else {
                        dos.writeUTF("khong phai so nguyen");
                    }
                }

            } catch (Exception e) {
                dos.close();
                dis.close();
                System.out.println(e.getMessage());
            }
        }
    }
}
