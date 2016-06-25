package network.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient1 {
	public static void main(String[] args) {
		Socket client = null;
		try {
			client = new Socket("localhost",7777);
			OutputStream os = client.getOutputStream();
			os.write('a');
			os.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}