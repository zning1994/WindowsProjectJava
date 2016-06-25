package gui.graphics;
import java.awt.*;

import javax.swing.JFrame;

public class SimplePaintTest {
	public static void main(String[] args) {
		new PaintFrame();
	}
}

class PaintFrame extends JFrame {
	
	public PaintFrame() {
		setBounds(200,200,640,480);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(50, 50, 30, 30);
		g.setColor(Color.green);
		g.fillRect(80,80,40,40);
	}
	
}