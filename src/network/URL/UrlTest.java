package network.URL;

import java.net.URL;
import java.net.MalformedURLException;

public class UrlTest
{
    public static void main(String args[ ])
    {
        try{
            URL u = new URL("http://www.tsinghua.edu.cn:80/publish/newthu/index.html#test"); 
            System.out.println("在URL(" + u + ")当中:"); 
            System.out.println("协议是" + u.getProtocol( )); 
            System.out.println("主机名是" + u.getHost( )); 
            System.out.println("文件名是" + u.getFile( )); 
            System.out.println("端口号是" + u.getPort( )); 
            System.out.println("引用是" + u.getRef( )); 
        }
        catch (MalformedURLException e)
        { 
            System.err.println("发生异常:" + e);
            e.printStackTrace( );
        }
    } 
} 
