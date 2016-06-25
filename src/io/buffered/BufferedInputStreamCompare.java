package io.buffered;
// ////////////////////////////////////////////////////////
// 
// J_BufferedInputStream.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     带与不带缓存在读取数据时的效率比较例程。
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

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Date;

public class BufferedInputStreamCompare
{
    public static void main(String args[ ])
    {
        try
        {
        	String fileName = "src/io/buffered/克罗地亚狂想曲.mp3";
            int i, ch;
            i = 0;
            Date d1= new Date( );
            FileInputStream f = new FileInputStream(fileName);
            while ((ch=f.read( )) != -1) // read entire file
                i++;
            f.close( );
            Date d2= new Date( );
            long t = d2.getTime( ) - d1.getTime( ); // 单位(毫秒)
            System.out.printf("读取文件%1$s(共%2$d字节)%n", fileName, i);
            System.out.printf("不带缓存的按单字节方法需要%1$d毫秒%n", t);


            i = 0;
            d1= new Date( );
            byte[] bytes = new byte[1024*512];
            f = new FileInputStream(fileName);
            while ((ch=f.read(bytes,0,1024*512  )) != -1) // read entire file
                i+=ch;
            f.close( );
            d2= new Date( );
            
            t = d2.getTime( ) - d1.getTime( ); // 单位(毫秒)
            System.out.printf("不带缓存的按字节数组方法需要%1$d毫秒%n", t);

            
            i = 0;
            d1= new Date( );
            f = new FileInputStream(fileName);
            BufferedInputStream fb = new BufferedInputStream(f);
            while ((ch=fb.read( )) != -1) // read entire file
                i++;
            fb.close( );
            d2= new Date( );
            
            t = d2.getTime( ) - d1.getTime( ); // 单位(毫秒)
            System.out.printf("带缓存的方法需要%1$d毫秒%n", t);
        }
        catch (Exception e)
        {
            System.err.println("发生异常:" + e);
            e.printStackTrace( );
        } // try-catch结构结束
    } // 方法main结束
} // 类J_BufferedInputStream结束
