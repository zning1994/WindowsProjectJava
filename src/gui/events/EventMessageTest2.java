package gui.events;

/*	�������ƣ�Java�¼��������
 * 	Դ�ļ����ƣ�TestActionEvent2.java
 *	Ҫ  �㣺
 *  	1. һ���¼�Դ����Ͽ���ͬʱע����������
 *		2. һ���������������ͬʱע�ᵽ����¼�Դ�����
 *		3. �¼�Դ����Ϣ�����������������¼��Զ����ݵ�����ע����ļ�����
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventMessageTest2 {
	public static void main(String args[]) {
		JFrame f = new JFrame("Test");
		f.setLocation(100, 100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton b1 = new JButton("Start");
		JButton b2 = new JButton("Stop");
		ButtonListener2 bh = new ButtonListener2();
		b1.addActionListener(bh);
		b2.addActionListener(bh);
		b2.setActionCommand("game over");
		
		f.add(b1, "North");
		f.add(b2, "Center");
		f.pack();
		f.setVisible(true);
	}
}

class ButtonListener2 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("a button has been pressed,"
				+ "the relative info is:\n " + e.getActionCommand());
	}
}
