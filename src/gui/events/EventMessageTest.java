package gui.events;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class EventMessageTest {

	public static void main(String[] args) {
		new TextFieldFrame();
	}
}

class TextFieldFrame extends JFrame
{
	TextFieldFrame()
	{
		setLocation( 400, 400);
		TextField tf = new TextField();
//		tf.setEchoChar('&');
		add(tf);
		tf.addActionListener(new TFActionListener());
		pack();
		setVisible(true);
	}
}

class TFActionListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText());
		tf.setText("");
	}
}
