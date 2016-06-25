package gui;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultiPanelTest {
    public static void main(String args[]) {
        new MyFrame2("MyFrameWithPanel",300,300,400,300);
    }
}


class MyFrame2 extends JFrame{
    private JPanel p1,p2,p3,p4;
    MyFrame2(String s,int x,int y,int w,int h){
        super(s);
        setLayout(null);
        p1 = new JPanel(); p2 = new JPanel();
        p3 = new JPanel(); p4 = new JPanel();
        p1.setBounds(0,0,w/2,h/2);
        p2.setBounds(0,h/2,w/2,h/2);
        p3.setBounds(w/2,0,w/2,h/2);
        p4.setBounds(w/2,h/2,w/2,h/2);
        p1.setBackground(Color.BLUE);
        p2.setBackground(Color.GREEN);
        p3.setBackground(Color.YELLOW);
        p4.setBackground(Color.MAGENTA);
        add(p1);add(p2);add(p3);add(p4);
        setBounds(x,y,w,h);
        setVisible(true);
    }
}
