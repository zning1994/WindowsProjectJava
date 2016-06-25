package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;;

public class SimpleDialogTest {
	public static void main(String[] args) {
		JDialog dialog = new JDialog();
		dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		dialog.setSize(300, 200);
		dialog.setVisible(true);
	}
}
