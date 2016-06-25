package gui.events;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowCloseEventTest1 {
	public static void main(String[] args) {
		JFrame frame  = new JFrame();
		frame.setSize(300, 200);
		frame.addWindowListener(new WindowAdapter() {

			//Invoked when a window is in the process of being closed. 
			//The close operation can be overridden at this point.
			@Override
			public void windowClosing(WindowEvent e) {
				int r = JOptionPane.showConfirmDialog(frame, "确定要关闭吗？");
				if (r == JOptionPane.YES_OPTION)
					frame.dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("window closed");
				System.exit(1);
			}
		});
		frame.add(new Button("Center"));
		frame.setVisible(true);
	}
}
