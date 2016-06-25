package network.TCP;
// ////////////////////////////////////////////////////////
// 
// J_Server.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ����TCPͨѶ���̵ķ������˳���
// ////////////////////////////////////////////////////////
// Copyright:
//
// Using this example, please explicitly refer to the book:
//     Jun-Hai Yong. Textbook for Programming in Java. 
//     Beijing: Tsinghua University Press, 2007.
// The example should be used legally, beneficially and
// without any harm to anybody. Please note that the
// author and the publisher make no warranty of any kind
// on the examples provided.
// Citation examples:
// The program is an example in (or based on, or modified from)
//     Jun-Hai Yong. Textbook for Programming in Java. 
//     Beijing: Tsinghua University Press, 2007.
//
// Some other books by Jun-Hai Yong are:
//      [1] Jun-Hai Yong. Programming in Java. 
//          Beijing: Tsinghua University Press, 2004.
//      [2] Jun-Hai Yong. Exercises for Programming in Java.
//          Beijing: Tsinghua University Press, 2006.
//
// ��Ȩ:
// ʹ�ñ����ӣ���ע������:
//     Ӻ����. Java ������ƽ̳�. ����: �廪��ѧ������, 2007.
// ��Ϸ�ʹ�����̣�����;Ӧ���Ϸ�������Ҳ�Ӧ���κ�������κ�
// �˺�����ʧ��ͬʱ��ע��̲����߼�������û�ж����������κγ�
// ŵ�뱣֤��
// �������õķ�������������:
// ������������̲ĵ�һ������(�򱾳����������̲ĵ������޸�)
//     Ӻ����. Java ������ƽ̳�. ����: �廪��ѧ������, 2007.
//
// Ӻ��������д�����µĽ̲ĺͽ̲�:
//      [1] Ӻ����. Java �������. ����: �廪��ѧ������, 2004.
//      [2] Ӻ����. Java�������ϰ�⼯(���ο���). 
//          ����: �廪��ѧ������, 2006.
//
// ////////////////////////////////////////////////////////

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPServer3e
{
    public static void main(String args[ ]){
    	TCPServer3e server = new TCPServer3e();
    	server.start();
    }
    
	List<Socket> clientSockets = new ArrayList<Socket>();

    public void start() {
        try {
        	ServerSocket server = new ServerSocket(5000);
            while (true) {
                Socket s = server.accept( );
                System.out.println("�ͻ�������");
                clientSockets.add(s);
                Thread t = new Thread(new MyServerThread2(s));
                t.start();
            }
        }
        catch (Exception e) { 
            e.printStackTrace( );
        } 
    }
    

class MyServerThread2 implements Runnable {
	
	DataOutputStream dataOut; 
	DataInputStream dataIn;
	Socket s;
	
	MyServerThread2(Socket s) {
		this.s = s;
		try {
			this.dataOut = new DataOutputStream(s.getOutputStream( ));
			this.dataIn = new DataInputStream(s.getInputStream( ));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		boolean flag = true;
		try {
			while (flag) {
				String str = dataIn.readUTF();
                System.out.println(str);
                if(str.equals("exit")) {
                	flag = false;
                	s.close();//�ɷ������˹ر�socket���ͻ����ٹرգ����ᱨ���������connection reset����
                	continue;
                }
                for (Socket ss : clientSockets) {
                	if (ss!=s) 
                		new DataOutputStream(ss.getOutputStream()).writeUTF(str);
                }
			}
		}catch (IOException e) {
        	e.printStackTrace();
        } finally {
            try {
				if (dataIn!=null ) dataIn.close();
				if (dataOut!=null ) dataOut.close( );
				if (s!=null ) s.close( );
            } catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
	
}
} 

