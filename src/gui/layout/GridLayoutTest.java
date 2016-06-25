package gui.layout;
/*	范例名称：GridLayout应用举例
 * 	源文件名称：TestGridLayout
 *	要  点：GridLayout布局管理器的性质及用法
 */

import java.awt.*;
import javax.swing.*;
public class GridLayoutTest {
	public static void main(String args[]) {
        JFrame f = new JFrame("GridLayout Example");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200, 200);
        JButton b1 = new JButton("b1");
        JButton b2 = new JButton("b2");
        JButton b3 = new JButton("b3");
        JButton b4 = new JButton("b4");
        JButton b5 = new JButton("b5");
        JButton b6 = new JButton("b6");
        f.setLayout (new GridLayout(3,2));
        f.add(b1);        
        f.add(b2);
        f.add(b3);        
        f.add(b4);
        f.add(b5);        
        f.add(b6);
//        f.pack();           
        f.setVisible(true);
	}
}
