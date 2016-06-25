package gui.layout;
/*	范例名称：FlowLayout 用法举例
 * 	源文件名称：TestFlowLayout.java
 *	要  点：
 *		1. 布局管理器的概念和作用
 *   	2. FlowLayout的性质及用法
 */

import java.awt.*;
import javax.swing.*;

public class FlowLayoutTest {
    public static void main(String args[]) {
	 	JFrame f = new JFrame("Flow Layout");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        f.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        
        f.add(button1);
        f.add(button2);
        f.add(button3);
        f.add(button4);
        f.add(button5);
        
        f.setSize(100,100);
//        f.pack();
        f.setVisible(true);
    }
}
