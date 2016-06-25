package gui;

import javax.swing.*;

class ExitAndDispose {
	public static void main(String[] args) {
		JFrame jf1 = new JFrame("dispose");
		JFrame jf2 = new JFrame("exit");
		JFrame jf3 = new JFrame("hide");
		JFrame jf4 = new JFrame("do nothing");

		jf1.setBounds(100, 100, 180, 100);
		jf2.setBounds(400, 100, 180, 100);
		jf3.setBounds(700, 100, 180, 100);
		jf4.setBounds(1000, 100, 180, 100);
		
		jf1.setVisible(true);
		jf2.setVisible(true);
		jf3.setVisible(true);
		jf4.setVisible(true);
		
		jf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf4.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		
	}
	
}