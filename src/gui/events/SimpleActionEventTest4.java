package gui.events;

/*	�������ƣ�Java�¼��������
 * 	Դ�ļ����ƣ�TestActionEvent.java
 *	Ҫ  �㣺
 *  	1. Java�¼��������
 *		2. �¼�Դ���¼��������������
 *		3. �����һ�����������ע�������
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SimpleActionEventTest4 {
	public static void main(String args[]) {
		MyFrame3 f = new MyFrame3("Test Frame");
	}
}

class MyFrame3 extends JFrame {
	
	public MyFrame3(String title) {
		super(title);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( dim.width/2, dim.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton b = new JButton("Press Me!");
		ButtonListener1 bl = new ButtonListener1();
		b.addActionListener(bl);
		ButtonListener2 bl2 = new ButtonListener2();
		b.addActionListener(bl2);
		
		add(b);
		pack();
		setVisible(true);
	}
	
	class ButtonListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "This is the 1st button listener");
		}
	}
	
	class ButtonListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "This is the 2nd button listener");
		}
	}
}


