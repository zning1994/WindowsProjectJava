package network.URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlReadDataTest
{
    public static void main(String args[ ])
    {
        try {
            URL u = new URL("http://www.tsinghua.edu.cn/publish/newthu/index.html");
            BufferedReader r = new BufferedReader(
                new InputStreamReader(u.openStream( ),"utf-8"));
            String s;
            while ((s = r.readLine( )) != null) // 获取网络资源信息
                System.out.println(s); // 输出网络资源信息
            r.close( );
        }
        catch (Exception e) {
            System.err.println("发生异常:" + e);
            e.printStackTrace( );
        }
    }
} 
