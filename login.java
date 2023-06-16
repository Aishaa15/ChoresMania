import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;


public class login extends Themainpage
{
    //create login page
    public login()
    {
      //make login window
      JFrame window2 = new JFrame("Login");
      window2.setSize(1000,1000);
      
      //set background color
      Container dp = window2.getContentPane();
      dp.setBackground(new Color(247, 205, 208));
      
      //Create header label
      JLabel header = new JLabel("Login");
      header.setBounds(450,100,500,80);
      header.setFont(new Font("Serif", Font.BOLD,55));
      window2.add(header);
     
      //create username label
      JLabel user_name = new JLabel("Username:");
      user_name.setBounds(380, 300, 200, 30);
      user_name.setFont(new Font("", Font.BOLD, 20));
      window2.add(user_name);
     
      //create textfield for username
      JTextField username = new JTextField();
      username.setBounds(500,300,200,40);
      window2.add(username);

      //create password label
      JLabel pass_word = new JLabel("Password:");
      pass_word.setBounds(380,400,200,30);
      pass_word.setFont(new Font("", Font.BOLD,20));
      window2.add(pass_word);

      //create passwordfield
      JPasswordField password = new JPasswordField();
      password.setBounds(500,400,200,40);
      window2.add(password);

      //create login button 
      JButton login_button = new JButton("Login");
      login_button.setBounds(500,550,100,40);
      window2.add(login_button);

      //add actionlistener 
      login_button.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
               
        }
      });

      window2.setLayout(null);
      window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window2.setVisible(true);
      window2.setResizable(false);


    }
}
