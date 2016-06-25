package gui.graphics;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;

public class MouseMotionTest {
	public static void main(String args[]) {
		new MyMouseMotionFrame2("drawing...");
	}
}

class MyMouseMotionFrame2 extends JFrame {
	ArrayList points = null;

	MyMouseMotionFrame2(String s) {
		super(s);
		points = new ArrayList();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		setBounds(300, 300, 400, 300);
		setVisible(true);
		this.addMouseMotionListener(new MyMouseAdapter());
	}

	public void paint(Graphics g) {
		Iterator i = points.iterator();
		while (i.hasNext()) {
			Point p = (Point) i.next();
			g.setColor(Color.BLUE);
			g.fillOval(p.x, p.y, 10, 10);
		}
	}

	public void addPoint(Point p) {
		points.add(p);
	}
	

class MyMouseAdapter extends MouseMotionAdapter {
	private int num = 0;

	public void mouseMoved(MouseEvent e) {
		MyMouseMotionFrame2 f = (MyMouseMotionFrame2) e.getSource();
		f.addPoint(new Point(e.getX(), e.getY()));
		if (num++ >= 5) {
			f.repaint();
			num = 0;
		}
	}
}

}
