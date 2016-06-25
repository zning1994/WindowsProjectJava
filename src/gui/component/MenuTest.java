package gui.component;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 1.23 2007-05-30
 * @author Cay Horstmann
 */
public class MenuTest {
	public static void main(String[] args) {
		MenuFrame frame = new MenuFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class MenuFrame extends JFrame {
	public MenuFrame() {
		setTitle("MenuTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new TestAction("New"));

		// demonstrate accelerators
		JMenuItem openItem = fileMenu.add(new TestAction("Open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

		fileMenu.addSeparator();

		saveAction = new TestAction("Save");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

		saveAsAction = new TestAction("Save As");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();

		fileMenu.add(new AbstractAction("Exit") {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		// demonstrate check box and radio button menus
		readonlyItem = new JCheckBoxMenuItem("Read-only");
		readonlyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				boolean saveOk = !readonlyItem.isSelected();
				saveAction.setEnabled(saveOk);
				saveAsAction.setEnabled(saveOk);
			}
		});

		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
		group.add(insertItem);
		group.add(overtypeItem);

		// demonstrate icons
		Action cutAction = new TestAction("Cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon(
				"./src/gui/component/cut.gif"));
		Action copyAction = new TestAction("Copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon(
				"./src/gui/component/copy.gif"));
		Action pasteAction = new TestAction("Paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon(
				"./src/gui/component/paste.gif"));

		JMenu editMenu = new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);

		// demonstrate nested menus

		JMenu optionMenu = new JMenu("Options");
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);

		editMenu.addSeparator();
		editMenu.add(optionMenu);

		// add all top-level menus to menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		// demonstrate pop-ups
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);

		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popup);
		add(panel);

	}

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
}

/**
 * A sample action that prints the action name to System.out
 */
class TestAction extends AbstractAction {
	public TestAction(String name) {
		super(name);
	}

	public void actionPerformed(ActionEvent event) {
		JOptionPane.showMessageDialog(null, getValue(Action.NAME) + " selected.");
	}
}




