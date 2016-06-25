package gui.events;

/*	范例名称：Java事件处理举例
 * 	源文件名称：TestActionEvent2.java
 *	要  点：
 *  	1. 一个事件源组件上可以同时注册多个监听器
 *		2. 一个监听器对象可以同时注册到多个事件源组件上
 *		3. 事件源的信息可以随它所触发的事件自动传递到所有注册过的监听器
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
