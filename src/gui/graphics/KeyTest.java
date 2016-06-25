package gui.graphics;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class KeyTest {
	public static void main(String[] args) {
		new KeyFrame();
	}
}

class KeyFrame extends JFrame {
	public KeyFrame() {
		this.setSize(200, 200);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new MyKeyMonitor());
		this.setVisible(true);
	}
	
	class MyKeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_UP) {
				JOptionPane.showMessageDialog(KeyFrame.this, "up is pressed");
			}
		}
	}
}
