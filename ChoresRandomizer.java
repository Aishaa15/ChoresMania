package choresmania;

import java.awt.Color;
import java.awt.Container;
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
      
     ImageIcon persons = new ImageIcon("/Users/armee/choresmania/demo/src/main/java/choresmania/catto.png");
     JLabel label_persons = new JLabel(persons);
     label_persons.setBounds(50,80, 1600, 1500);
     window5.add(label_persons);

      JLabel person1 = new JLabel("Person #1");
      person1.setBounds(320,300,180,40);
      person1.setFont(new Font("Serif", Font.BOLD, 20));
      window5.add(person1);

      //make label for person1
      JLabel person1_label = new JLabel("chore...");//add chore randomized here
      person1_label.setBounds(320,350,200,40);
      person1_label.setFont(new Font("Serif", Font.BOLD, 20));
      window5.add(person1_label);

      JLabel person2 = new JLabel("Person #2");
      person2.setBounds(965,300,180,40);
      person2.setFont(new Font("Serif", Font.BOLD, 20));
      window5.add(person2);

      JLabel person2_label = new JLabel("chore...");
      person2_label.setBounds(965,350,200,40);
      person2_label.setFont(new Font("Serif", Font.BOLD, 20));
      window5.add(person2_label);

      JLabel person3 = new JLabel("Person #3");
      person3.setBounds(320,780,180,40);
      person3.setFont(new Font("Serif", Font.BOLD, 20));
      window5.add(person3);

      JLabel person3_label = new JLabel("chore...");
      person3_label.setBounds(320,830,200,40);
      person3_label.setFont(new Font("Serif", Font.BOLD, 20));
      window5.add(person3_label);

      JLabel person4 = new JLabel("Person #4");
      person4.setBounds(965,780,180,40);
      person4.setFont(new Font("Serif", Font.BOLD, 20));
      window5.add(person4);

      JLabel person4_label = new JLabel("chore...");
      person4_label.setBounds(965,830,200,40);
      person4_label.setFont(new Font("Serif", Font.BOLD, 20));
      window5.add(person4_label);

      JButton back_button = new JButton("Go Back");
      back_button.setBounds(90, 50, 100, 40);
      window5.add(back_button);
      back_button.addActionListener(new ActionListener() 
      {
          public void actionPerformed(ActionEvent e) 
          {
            Dashboard menu = new Dashboard();
          }
      });

      


      window5.setLayout(null);
      window5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window5.setVisible(true);
      window5.setResizable(false);

      
    }

     
}
