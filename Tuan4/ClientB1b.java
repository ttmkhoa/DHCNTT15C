import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientB1b {
    public static void main(String[] args) throws IOException {
        while (true) {
            Socket s = null;
            DataInputStream dis = null;
            DataOutputStream dos = null;
            try {
                s = new Socket("localhost", 7777);

                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());

                Scanner input = new Scanner(System.in);
                String str = null;

                while (true) {
                    System.out.println("Nhap so: ");
                    str = input.nextLine();
                    dos.writeUTF(str);

                    String res = dis.readUTF();
                    System.out.println(str + " doc la: " + res);
                }

            } catch (Exception e) {
                System.out.println("Dang ngat ket noi");
                dis.close();
                dos.close();
                s.close();
                e.printStackTrace();
                System.out.println("Da~ ngat ket noi");
            }
        }
    }
}
