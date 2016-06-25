package gui.layout;
/*	�������ƣ�BorderLayoutӦ�þ���
 * 	Դ�ļ����ƣ�TestBorderLayout.java
 *	Ҫ  �㣺FlowLayout���ֹ����������ʼ��÷�
 */

import java.awt.*;
import javax.swing.*;
public class BorderLayoutTest2 {
	public static void main(String args[]) {
		JFrame frame = new JFrame("GUI example 3");
		
		JPanel paneln = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel l1 = new JLabel("File");
		JLabel l2 = new JLabel("Help");
		paneln.add(l1);
	    paneln.add(l2);
		
		JButton bw1 = new JButton("West1");
		
		JButton bwc = new JButton("main work area");
		
	    frame.add(bw1, BorderLayout.WEST);
	    frame.add(bwc, BorderLayout.CENTER);
	    frame.add(paneln, BorderLayout.NORTH);
	    
	    frame.pack();
	    frame.setVisible(true);

	}
}
