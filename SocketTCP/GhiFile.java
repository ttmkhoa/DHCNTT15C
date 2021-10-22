import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class GhiFile {
    DataOutputStream dos;

    synchronized void Ghi(FileOutputStream fos, char ch) {
        try {
            System.out.println(Thread.currentThread().getName() + " : " + fos);
            dos = new DataOutputStream(fos);
            dos.writeByte(ch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
