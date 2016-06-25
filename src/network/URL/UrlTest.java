package network.URL;

import java.net.URL;
import java.net.MalformedURLException;

public class UrlTest
{
    public static void main(String args[ ])
    {
        try{
            URL u = new URL("http://www.tsinghua.edu.cn:80/publish/newthu/index.html#test"); 
            System.out.println("��URL(" + u + ")����:"); 
            System.out.println("Э����" + u.getProtocol( )); 
            System.out.println("��������" + u.getHost( )); 
            System.out.println("�ļ�����" + u.getFile( )); 
            System.out.println("�˿ں���" + u.getPort( )); 
            System.out.println("������" + u.getRef( )); 
        }
        catch (MalformedURLException e)
        { 
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        }
    } 
} 
