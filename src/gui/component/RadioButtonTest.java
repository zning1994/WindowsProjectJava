package gui.component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 1.33 2007-06-12
 * @author Cay Horstmann
 */
public class RadioButtonTest {
	public static void main(String[] args) {
		RadioButtonFrame frame = new RadioButtonFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/**
 * A frame with a sample text label and radio buttons for selecting font sizes.
 */
class RadioButtonFrame extends JFrame {
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 200;
	private static final int DEFAULT_SIZE = 12;

	private JPanel buttonPanel;
	private ButtonGroup group;
	private JLabel label;
	
	public RadioButtonFrame() {
		setTitle("RadioButtonTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// add the sample text label
		label = new JLabel("Radio Button Test!");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);

		// add the radio buttons
		buttonPanel = new JPanel();
		group = new ButtonGroup();

		addRadioButton("Small", 8);
		addRadioButton("Medium", 12);
		addRadioButton("Large", 18);
		addRadioButton("Extra large", 36);

		add(buttonPanel, BorderLayout.SOUTH);
	}


	public void addRadioButton(String name, final int size) {
		boolean selected = (size == DEFAULT_SIZE);
		JRadioButton button = new JRadioButton(name, selected);
		group.add(button);
		buttonPanel.add(button);

		// this listener sets the label font size

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// size refers to the final parameter of the addRadioButton method
				label.setFont(new Font("Serif", Font.PLAIN, size));
			}
		};

		button.addActionListener(listener);
	}

}
