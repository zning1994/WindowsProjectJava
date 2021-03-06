package gui.layout;
// ////////////////////////////////////////////////////////
// 
// J_GridBagLayout.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     网格包布局管理器例程。
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


import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutTest
{
    public static void main(String args[ ])
    {
        JFrame frame = new JFrame( "网格包布局管理器例程" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize( 320, 160 );
        GridBagLayout gr = new GridBagLayout( );
        frame.setLayout( gr );
        int [ ] gx = {0, 1, 2, 3, 1, 0, 0, 2};
        int [ ] gy = {0, 0, 0, 0, 1, 2, 3, 2};
        int [ ] gw = {1, 1, 1, 1, GridBagConstraints.REMAINDER, 2, 2, 2};
        int [ ] gh = {2, 1, 1, 1, 1, 1, 1, 2};
        GridBagConstraints gc = new GridBagConstraints( );
        String s;
        JButton b;
        for (int i=0; i < gx.length; i++)
        {
            s = "按钮" + (i+1);
            b = new JButton( s );
            gc.gridx = gx[i];
            gc.gridy = gy[i];
            gc.gridwidth = gw[i];
            gc.gridheight = gh[i];
            gc.fill = GridBagConstraints.BOTH;
            gr.setConstraints(b, gc);
            frame.add( b );
        }
        frame.setVisible( true );
    } 
} 
