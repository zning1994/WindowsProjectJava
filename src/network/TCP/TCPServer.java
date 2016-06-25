package network.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9999);
			Socket client = server.accept();
			
			
			System.out.println(client.getInetAddress()); //客户端IP
			System.out.println(client.getPort());//客户端Port
			
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
