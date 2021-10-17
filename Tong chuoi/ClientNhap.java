import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientNhap {
	public static int defaultPort = 1234;

	public void SendRequest() {
		try {
			Socket s = new Socket("localhost", defaultPort);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("Nhap Chuoi:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String request;
			while ((request = br.readLine()) != null) {
				out.println(request);
				System.out.println("Kqua tu server: " + in.readLine() + "\n");
			}

			out.close();
			in.close();
			br.close();
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClientNhap c = new ClientNhap();
		c.SendRequest();
	}

}
