package Tuan3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileTReader extends Thread {

    String filename;

    public FileTReader(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {

        try {
            // Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            // Bước 2: Đọc dữ liệu
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                Thread.sleep(2000);
            }
            // Bước 3: Đóng luồng
            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
    }

    public static void main(String[] args) {
        FileTReader t1 = new FileTReader("E:\\testdir\\test1.txt");
        t1.start();

        FileTReader t2 = new FileTReader("E:\\testdir\\test2.txt");
        t2.start();
    }
}
