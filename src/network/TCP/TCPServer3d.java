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
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer3d
{
    public static void main(String args[ ])
    {
        try  {
            ServerSocket server = new ServerSocket(5000);
            while (true) {
                Socket s = server.accept( );
                System.out.println("�ͻ�������");
                Thread t = new Thread(new MyThread(s));
                t.start();
            } 
        }
        catch (Exception e)
        { 
            e.printStackTrace( );
        } 
    }
} 

class MyThread implements Runnable {
	
	DataOutputStream dataOut; 
	DataInputStream dataIn;
	Socket s;
	
	MyThread(Socket s) {
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
		try {
            for (int i=0;i<3;i++) {
                String str = dataIn.readUTF();
                System.out.println(str);
                dataOut.writeUTF("�ͻ�����ã�");
            }
            dataIn.close();
            dataOut.close( );
            s.close( );
		}
        catch (Exception e) {
        	e.printStackTrace();
        }

	}
	
}