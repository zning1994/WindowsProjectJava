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
