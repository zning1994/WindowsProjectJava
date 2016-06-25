package gui.graphics;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MousePaintTest {
	public static void main(String args[]) {
		JFrame f = new JFrame("drawing");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(300,300,400,400);
		f.add(new PaintPanel());
		f.setVisible(true);
	}
}

class PaintPanel extends JPanel {
	ArrayList points;
	
	PaintPanel() {
		points = new ArrayList();
		this.addMouseListener(new MyMouseAdapter());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
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
	
	class MyMouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			PaintPanel f = (PaintPanel) e.getSource();
			f.addPoint(new Point(e.getX(), e.getY()));
			f.repaint();
		}
	}
}


