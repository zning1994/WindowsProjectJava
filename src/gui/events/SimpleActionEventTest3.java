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

public class SimpleActionEventTest3 {
	public static void main(String args[]) {
		MyFrame f = new MyFrame("Test Frame");
	}
}

class MyFrame2 extends JFrame {
	private String title;
	
	public MyFrame2(String title) {
		super(title);
		this.title = title;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( dim.width/2, dim.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton b = new JButton("Press Me!");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Frame title : "+MyFrame2.this.title);
			}
		});
		
		add(b);
		pack();
		setVisible(true);
	}
}


