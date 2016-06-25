package gui.layout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BoxLayoutTest
{
    public static void main(String args[ ])
    {
        JFrame f = new JFrame( "��ʽ���ֹ���������" );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxLayout bl = new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS );  
        f.setLayout( bl );
        
        String s;
        JButton b;
        for (int i=0; i<6; i++)
        {
            s = "��ť" + (i+1);
            b = new JButton( s );
            f.add( b );
        }
        f.pack();
        f.setVisible( true );
    } 
} 
