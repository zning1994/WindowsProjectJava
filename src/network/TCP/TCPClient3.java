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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;

public class TCPClient3
{
    public static void main(String args[ ])
    {
        try
        {
            Socket s = new Socket("localhost", 5000);
            DataOutputStream dataOut = null;
            DataInputStream dataIn = null;
            for (int i=0; i<3; i++) {
            	dataOut = new DataOutputStream(s.getOutputStream());
	            dataOut.writeUTF("��������ã�");
	            dataIn = new DataInputStream(s.getInputStream( ));
	            String str =  dataIn.readUTF( );
	            System.out.println(getTime(System.currentTimeMillis()) +"  "+str);
	            Thread.sleep(3000);
            }
            dataIn.close( );
            dataOut.close();
            s.close( );
        }
        catch (Exception e)
        { 
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        } 
    }
    
    public static String getTime(long time) {
    	Calendar cal = Calendar.getInstance();
    	cal.setTimeInMillis(time);
    	return cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    }
} 