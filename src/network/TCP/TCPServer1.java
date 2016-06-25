package network.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class TCPServer1 {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(7777);
			while (true) {
			Socket client = server.accept();
			
			System.out.println(client.getInetAddress()); //客户端IP
			System.out.println(client.getPort());//客户端Port
			
			InputStream is = client.getInputStream();
			System.out.println((char)is.read());
			is.close();
			client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
