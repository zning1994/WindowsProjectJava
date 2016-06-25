package network.TCP;
// ////////////////////////////////////////////////////////
// 
// J_Server.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     基于TCP通讯例程的服务器端程序。
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
                System.out.println("客户端连接");
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
                	s.close();//由服务器端关闭socket，客户端再关闭，不会报错，否则会有connection reset错误
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

