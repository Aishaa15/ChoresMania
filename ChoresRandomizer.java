import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChoresRandomizer 
{
    public ChoresRandomizer()
    {
      JFrame window5 = new JFrame("Duty Assignment");
      window5.setSize(1500,1500);

      Container rp = window5.getContentPane();
      rp.setBackground(new Color(247, 205, 208));
      
      ImageIcon person1 = new ImageIcon("/Users/armee/choresmania/demo/src/main/java/choresmania/catfriends.png");
      JLabel label_person1 = new JLabel(person1);
      label_person1.setBounds(20,80, 1200, 1500);
      window5.add(label_person1);

      JLabel chorelabel = new JLabel("----CHORES----");
      chorelabel.setBounds(1200, 100, 200, 30);
      chorelabel.setFont(new Font("", Font.BOLD, 20));
      window5.add(chorelabel);



      window5.setLayout(null);
      window5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window5.setVisible(true);
      window5.setResizable(false);

      
    }

     
}
