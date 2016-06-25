package gui.events;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 1.33 2007-06-12
 * @author Cay Horstmann
 */
public class ActionTest
{
   public static void main(String[] args)
   {
       ActionFrame frame = new ActionFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
   }
}

/**
 * A frame with a panel that demonstrates color change actions.
 */
class ActionFrame extends JFrame
{
   public ActionFrame()
   {
      setTitle("ActionTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      buttonPanel = new JPanel();

      // define actions
      Action yellowAction = new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"),
            Color.YELLOW);
      Action blueAction = new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
      Action redAction = new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED);

      // add buttons for these actions
      buttonPanel.add(new JButton(yellowAction));
      buttonPanel.add(new JButton(blueAction));
      buttonPanel.add(new JButton(redAction));

      // add panel to frame
      add(buttonPanel);

      // associate the Y, B, and R keys with names
      InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
//      InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_FOCUSED);//当点击鼠标后，焦点不在buttonPanel上了，所以按键不管用了
//      InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//鼠标在buttonpanel里，因此点击鼠标后键盘还能响应，如果把map放到jframe层面，就不行了。
      imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
      imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
      imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

      // associate the names with actions
      ActionMap amap = buttonPanel.getActionMap();
      amap.put("panel.yellow", yellowAction);
      amap.put("panel.blue", blueAction);
      amap.put("panel.red", redAction);
   }
   
   public class ColorAction extends AbstractAction
   {
      public ColorAction(String name, Icon icon, Color c)
      {
         putValue(Action.NAME, name);
         putValue("color", c);
      }

      public void actionPerformed(ActionEvent event)
      {
         Color c = (Color) getValue("color");
         buttonPanel.setBackground(c);
      }
   }

   private JPanel buttonPanel;

   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 200;
}