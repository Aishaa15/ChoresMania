import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;


public class Themainpage extends JFrame
{
        
    public Themainpage()
    {
        //creating main window
        JFrame window = new JFrame("Chores Mania");
        window.setSize(1000,1000);

        //set the background colour
        Container cp = window.getContentPane();
        cp.setBackground(new Color(247, 205, 208));

        //add title image
        ImageIcon image = new ImageIcon("chores.png");
        JLabel label_image = new JLabel(image);
        label_image.setBounds(180, 50, 600, 500);
        window.add(label_image);

        //create login button 
        JButton Login = new JButton("Login");
        Login.setBounds(380,550,250,40);
        window.add(Login);

        //connect login button to login window
        Login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               window.dispose();
               login menu = new login();
            }
        });


        //create sign up button
        JButton signup = new JButton("Sign up");
        signup.setBounds(380,650,250,40);
        window.add(signup);

        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
    }
}
