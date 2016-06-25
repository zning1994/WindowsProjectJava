package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrameDialogTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b1 = new JButton("ģ̬");
		JButton b2 = new JButton("��ģ̬");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog(frame, "�µĶԻ���", true);
				dialog.setSize(100,100);
				dialog.setVisible(true);
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog(frame, "�µĶԻ���", false);
				dialog.setSize(100,100);
				dialog.setVisible(true);
			}
		});
		frame.add(b1);
		frame.add(b2);
		
		frame.setVisible(true);
	}
}


