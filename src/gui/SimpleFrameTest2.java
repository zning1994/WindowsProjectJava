package gui;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.*;

public class SimpleFrameTest2 {
	public static void main(String[] args) {
		SimpleFrame2 frame = new SimpleFrame2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(new JButton("µ„Œ“"));
		frame.setVisible(true);
	}
}

class SimpleFrame2 extends JFrame {
	public SimpleFrame2() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setBackground(Color.BLACK);
//		this.getContentPane().setBackground(Color.BLACK);
		this.setAlwaysOnTop(true);
	}
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
}


