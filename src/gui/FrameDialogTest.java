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
		JButton b1 = new JButton("模态");
		JButton b2 = new JButton("非模态");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog(frame, "新的对话框", true);
				dialog.setSize(100,100);
				dialog.setVisible(true);
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog(frame, "新的对话框", false);
				dialog.setSize(100,100);
				dialog.setVisible(true);
			}
		});
		frame.add(b1);
		frame.add(b2);
		
		frame.setVisible(true);
	}
}


