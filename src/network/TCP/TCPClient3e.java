package network.TCP;
// ////////////////////////////////////////////////////////
// 
// J_Client.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     基于TCP通讯例程的客户端程序。
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
// 版权:
// 使用本例子，请注明引用:
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
// 请合法使用例程，其用途应当合法有益而且不应对任何人造成任何
// 伤害或损失。同时请注意教材作者及出版社没有对例程做出任何承
// 诺与保证。
// 具体引用的方法及例子如下:
// 本程序是下面教材的一个例程(或本程序基于下面教材的例程修改)
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
//
// 雍俊海还编写过如下的教材和教参:
//      [1] 雍俊海. Java 程序设计. 北京: 清华大学出版社, 2004.
//      [2] 雍俊海. Java程序设计习题集(含参考答案). 
//          北京: 清华大学出版社, 2006.
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
            System.err.println("发生异常:" + e);
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
