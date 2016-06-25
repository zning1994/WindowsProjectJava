package gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

import javax.swing.*;

public class PanelTest {
    public static void main(String args[]) {
		JFrame f = new JFrame("Java Frame with Panel");
	    JPanel p = new JPanel();
//	    f.setLayout(null);
	    f.setBounds(300,300,500,600);
	    f.getContentPane().setBackground(new Color(0,0,102));
	    p.setBounds(50,50,400,400);
	    p.setBackground(new Color(204,204,255));
	    p.add(new JButton("点我"));
	    p.add(new JButton("点我"));
	    p.add(new JButton("点我"));
	    f.add(p);
	    f.setVisible(true);
	}
}
