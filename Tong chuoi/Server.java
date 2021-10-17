import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
	public static int defaultPort = 1234;

	public void ReceiveRequest() throws SocketException {
		try {
			ServerSocket ss = new ServerSocket(defaultPort);
			System.out.println("Server socket is create");
			Socket s = ss.accept();
			System.out.println("Server is ready.... ");
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			int tong = 0;
			String request;
			while ((request = in.readLine()) != null) {
				String[] n = request.split(" ");

				for (int i = 0; i < n.length; i++) {
					int temp = Integer.parseInt(n[i]);
					tong = tong + temp;
				}
				out.println(tong);
				System.out.println("Tong chuoi vua nhan la:" + tong);
			}
			out.close();
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SocketException {
		Server s = new Server();
		s.ReceiveRequest();
	}

}
