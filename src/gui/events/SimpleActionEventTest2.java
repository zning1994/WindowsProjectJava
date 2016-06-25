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

public class SimpleActionEventTest2 {
	public static void main(String args[]) {
		MyFrame f = new MyFrame("Test Frame");
	}
}

class MyFrame extends JFrame {
	private String title;
	
	public MyFrame(String title) {
		super(title);
		this.title = title;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( dim.width/2, dim.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton b = new JButton("Press Me!");
		ButtonListener bl = new ButtonListener();
		b.addActionListener(bl);
		
		add(b);
		pack();
		setVisible(true);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Frame title : "+MyFrame.this.title);
		}
	}
}


