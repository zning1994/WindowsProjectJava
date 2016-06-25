package gui;

import javax.swing.JOptionPane;

public class OptionPaneTest {
	public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "您好!");
        
        int i = JOptionPane.showConfirmDialog(null, "您现在还好吗?");
        System.out.println(i);

        String s1 = JOptionPane.showInputDialog(null, "您现在还好吗?");
        System.out.println(s1);

        String [ ] s = {"好", "不好"};
        String s2 = (String)JOptionPane.showInputDialog(null, "您现在还好吗?", "输入",
            JOptionPane.QUESTION_MESSAGE, null, s, s[0]);
        System.out.println(s2);

        s2 = (String)JOptionPane.showInputDialog(null, "您现在还好吗?", "输入",
                JOptionPane.ERROR_MESSAGE, null, s, s[1]);
        System.out.println(s2);
	}
}
