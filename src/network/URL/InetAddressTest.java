package network.URL;
// ////////////////////////////////////////////////////////
// 
// J_InetAddress.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �����ַ���̡�
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

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest
{
    public static void main(String args[ ])
    {
        String tsing = "www.tsinghua.edu.cn";
        String sina = "www.sina.com.cn";
        InetAddress ts= null;
        InetAddress[] ss = null;

        try { 
            ts = InetAddress.getByName(tsing);
            ss = InetAddress.getAllByName(sina);
            
        } catch (UnknownHostException e) { 
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        } 
        
        if (ts!=null) {
            System.out.println("�廪��ѧ�������ַ��: " + ts.getHostAddress( ));
            System.out.println("�廪��ѧ��վ����������: " + ts.getHostName( ));
        }
        
        if (ss!=null) {
            System.out.println("���˵������ַ����: " );
            for (InetAddress s : ss) 
            	System.out.println(s.getHostAddress());
        }
    }
} 