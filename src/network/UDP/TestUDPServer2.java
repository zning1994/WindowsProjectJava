package network.UDP;

import java.net.*;
import java.io.*;
import java.net.*;
import java.io.*;


public class TestUDPServer2 {
	public static void main(String args[])
	{  
		DatagramPacket pack=null;
		DatagramSocket mailReceive=null;
		ServerThread thread;
		byte b[]=new byte[8192];
		InetAddress address=null;
		int port = 0;
		pack=new DatagramPacket(b,b.length);
		while(true)
		{  
			try{
				mailReceive=new DatagramSocket(1234);//创建在端口1234负责收取数据包的DatagramSocket对象。
				mailReceive.receive(pack);
                address=pack.getAddress(); //pack返回InetAddress对象。
                port = pack.getPort();
                System.out.println("客户的端口:"+port);
   				new ServerThread(address, port).start();
			}
			catch (IOException e) { }
		}
	}
}

class ServerThread extends Thread {
	InetAddress address;
	int port;
	DataOutputStream out = null;
	DataInputStream in = null;
	String s = null;

	ServerThread(InetAddress address, int port) {
		this.address = address;
		this.port = port;
	}

	public void run() {  
		FileInputStream in;
		byte b[]=new byte[1024];
		try{   
			in = new FileInputStream("src/network/UDP/a.jpg");
			int n = -1;
			int num = 0;
			while ((n = in.read(b)) != -1) {
				DatagramPacket data = new DatagramPacket(b, n, address, port); // 创建数据包，目标地址和端口分别是address和5678，其中的数据为数组b中的前n个字节
				DatagramSocket mailSend = new DatagramSocket(); // 创建发送数据的DatagramSocket对象
				mailSend.send(data); // mailSend发送数据data
				num+=n;
			}
			System.out.println(num);
			in.close();
			byte end[] = "end".getBytes();
			DatagramPacket data = new DatagramPacket(end, end.length, address,port); // 创建数据包，目标地址和端口分别是address和5678，其中的数据为数组end中的全部字节
			DatagramSocket mailSend = new DatagramSocket(); // 创建负责发送数据的DatagramSocket对象
			mailSend.send(data); // mailSend发送数据data
		} catch (Exception e) {		}
	}
}
