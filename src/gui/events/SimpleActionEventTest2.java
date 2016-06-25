package gui.events;

/*	范例名称：Java事件处理举例
 * 	源文件名称：TestActionEvent.java
 *	要  点：
 *  	1. Java事件处理机制
 *		2. 事件源、事件监听器概念及作用
 *		3. 如何在一个现有组件上注册监听器
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


