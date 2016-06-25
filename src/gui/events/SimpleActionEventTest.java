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

public class SimpleActionEventTest {
	public static void main(String args[]) {
		JFrame f = new JFrame("Test Frame");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width/2, dim.height/2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton b = new JButton("Press Me!");
		ButtonListener bl = new ButtonListener();
		b.addActionListener(bl);
		
		f.add(b);
		f.pack();
		f.setVisible(true);
	}
}

class ButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "button pressed!");
	}
}
