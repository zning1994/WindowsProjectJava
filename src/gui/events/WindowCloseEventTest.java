package gui.events;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowCloseEventTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("window closing");
//				int r = JOptionPane.showConfirmDialog(frame, "确定要关闭吗？");
//				if (r == JOptionPane.YES_OPTION)
//					frame.dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("window closed");
//				System.exit(1);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("window opened");				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println("window iconified");				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				System.out.println("window deiconified");				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("window activated");				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println("window deactivated");				
			}
		});
		frame.add(new Button("Center"));
		frame.setVisible(true);
	}
}
