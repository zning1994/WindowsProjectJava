package gui;

import java.awt.Color;
import java.awt.Frame;


public class SimpleFrameTestAWT {
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setSize(300, 200);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);
	}
}
