package gui.layout;
/*	�������ƣ�BorderLayoutӦ�þ���
 * 	Դ�ļ����ƣ�TestBorderLayout.java
 *	Ҫ  �㣺FlowLayout���ֹ����������ʼ��÷�
 */

import java.awt.*;
import javax.swing.*;
public class BorderLayoutTest {
	public static void main(String args[]) {
		JFrame f;
		f = new JFrame("Border Layout");
		JButton bn = new JButton("BN");
		JButton bs = new JButton("BS");
		JButton bw = new JButton("BW");
		JButton be = new JButton("BE");
		JButton bc = new JButton("BC");

		f.add(bn, BorderLayout.NORTH);
		f.add(bs, BorderLayout.SOUTH);
		f.add(bw, BorderLayout.WEST);
		f.add(be, BorderLayout.EAST);
		f.add(bc, BorderLayout.CENTER);
		
		f.setSize(200,200);
//		f.pack();
		f.setVisible(true);
	}
}
