package gui.layout;
/*	�������ƣ�FlowLayout �÷�����
 * 	Դ�ļ����ƣ�TestFlowLayout.java
 *	Ҫ  �㣺
 *		1. ���ֹ������ĸ��������
 *   	2. FlowLayout�����ʼ��÷�
 */

import java.awt.*;
import javax.swing.*;

public class FlowLayoutTest {
    public static void main(String args[]) {
	 	JFrame f = new JFrame("Flow Layout");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        f.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        
        f.add(button1);
        f.add(button2);
        f.add(button3);
        f.add(button4);
        f.add(button5);
        
        f.setSize(100,100);
//        f.pack();
        f.setVisible(true);
    }
}
