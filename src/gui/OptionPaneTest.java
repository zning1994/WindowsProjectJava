package gui;

import javax.swing.JOptionPane;

public class OptionPaneTest {
	public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "����!");
        
        int i = JOptionPane.showConfirmDialog(null, "�����ڻ�����?");
        System.out.println(i);

        String s1 = JOptionPane.showInputDialog(null, "�����ڻ�����?");
        System.out.println(s1);

        String [ ] s = {"��", "����"};
        String s2 = (String)JOptionPane.showInputDialog(null, "�����ڻ�����?", "����",
            JOptionPane.QUESTION_MESSAGE, null, s, s[0]);
        System.out.println(s2);

        s2 = (String)JOptionPane.showInputDialog(null, "�����ڻ�����?", "����",
                JOptionPane.ERROR_MESSAGE, null, s, s[1]);
        System.out.println(s2);
	}
}
