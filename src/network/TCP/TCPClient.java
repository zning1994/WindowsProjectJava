package network.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {
		Socket client = null;
		try {
			client = new Socket("localhost",9999);
			System.out.println(client.getLocalAddress());
			System.out.println(client.getLocalPort());
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}