package network.TCP;
// ////////////////////////////////////////////////////////
// 
// J_Client.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ����TCPͨѶ���̵Ŀͻ��˳���
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

import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;

public class TCPClient3e
{
    public static void main(String args[ ])
    {
    	 DataOutputStream dataOut = null;
         DataInputStream dataIn = null;
         BufferedReader reader = null;
         Socket s = null;
         try
         {
            s = new Socket("localhost", 5000);
            dataOut = new DataOutputStream(s.getOutputStream());
            dataIn = new DataInputStream(s.getInputStream( ));
            reader = new BufferedReader (new InputStreamReader(System.in));
            String str = null;
            Thread t = new Thread(new MyClientThread(s));
            t.start();
            
            while (true) {
            	str = reader.readLine();
	            dataOut.writeUTF(str);
            }
        }
        catch (Exception e) { 
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        } finally {
            try {
				dataIn.close( );
	            dataOut.close();
	            reader.close();
	            s.close( );
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
} 


class MyClientThread implements Runnable {
	Socket s;
	DataInputStream dataIn;

	MyClientThread(Socket s) {
		this.s = s;
		try {
			this.dataIn = new DataInputStream(s.getInputStream( ));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
        try {
        	while (true) {
        		String str =  dataIn.readUTF( );
        		System.out.println(str);
        	}
		} catch (EOFException e) {
			System.out.println("Client closed!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            try {
				if (dataIn!=null ) dataIn.close();
				if (s!=null ) s.close( );
            } catch (IOException e) {
				e.printStackTrace();
			}
        }

	}
}
