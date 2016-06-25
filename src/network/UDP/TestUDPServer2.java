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
				mailReceive=new DatagramSocket(1234);//�����ڶ˿�1234������ȡ���ݰ���DatagramSocket����
				mailReceive.receive(pack);
                address=pack.getAddress(); //pack����InetAddress����
                port = pack.getPort();
                System.out.println("�ͻ��Ķ˿�:"+port);
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
				DatagramPacket data = new DatagramPacket(b, n, address, port); // �������ݰ���Ŀ���ַ�Ͷ˿ڷֱ���address��5678�����е�����Ϊ����b�е�ǰn���ֽ�
				DatagramSocket mailSend = new DatagramSocket(); // �����������ݵ�DatagramSocket����
				mailSend.send(data); // mailSend��������data
				num+=n;
			}
			System.out.println(num);
			in.close();
			byte end[] = "end".getBytes();
			DatagramPacket data = new DatagramPacket(end, end.length, address,port); // �������ݰ���Ŀ���ַ�Ͷ˿ڷֱ���address��5678�����е�����Ϊ����end�е�ȫ���ֽ�
			DatagramSocket mailSend = new DatagramSocket(); // �������������ݵ�DatagramSocket����
			mailSend.send(data); // mailSend��������data
		} catch (Exception e) {		}
	}
}
