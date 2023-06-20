import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Dashboard 
{
     public Dashboard()
    {
          //make login window
         JFrame window4 = new JFrame("Dashboard");
          window4.setSize(1500,1500);
          
          //set background color
          Container dp = window4.getContentPane();
          dp.setBackground(new Color(247, 205, 208));
          
          //Create header label
          JLabel header1 = new JLabel("Welcome");
          header1.setBounds(100,100,500,80);
          header1.setFont(new Font("Serif", Font.BOLD,55));
          window4.add(header1);
    
          JLabel dash_board = new JLabel("DASHBOARD");
          dash_board.setBounds(100,200,500,80);
          dash_board.setFont(new Font("Serif", Font.ITALIC,35));
          window4.add(dash_board);
    
          JLabel td_chores = new JLabel("Todays Chores:");
          td_chores.setBounds(100,350,500,80);
          td_chores.setFont(new Font("Serif",Font.PLAIN,30));
          window4.add(td_chores);
    
          JTextField chore1 = new JTextField();
          chore1.setBounds(100,500,200,40);
          window4.add(chore1);
          chore1.getText();
          
    
          JTextField chore2 = new JTextField();
          chore2.setBounds(100,600,200,40);
          window4.add(chore2);
          chore2.getText();
    
          JTextField chore3 = new JTextField();
          chore3.setBounds(100,700,200,40);
          window4.add(chore3);
          chore3.getText();
    
          JTextField chore4 = new JTextField();
          chore4.setBounds(100,800,200,40);
          window4.add(chore4);
          chore4.getText();
    
          JButton gobtn = new JButton("GO");
          gobtn.setBounds(1200,900,200,40);
          window4.add(gobtn);
          
          JButton saveButton = new JButton("Save");
          saveButton.setBounds(900, 850, 200, 40); // Adjusted bounds for visibility
           window4.add(saveButton);
   
          JLabel grocery = new JLabel("Grocery List:");
          grocery.setFont(new Font("Serif",Font.PLAIN,30));
          grocery.setBounds(550,350,500,70);
          window4.add(grocery);
    
          JTextArea grocerylist = new JTextArea();
          grocerylist.setBounds(510,450,300,400);
          window4.add(grocerylist);
    
    
          saveButton.addActionListener(new ActionListener() 
          {
            public void actionPerformed(ActionEvent e) 
            {
                String groceryText = grocerylist.getText();
        
                // Save the text to the file
                try (FileWriter writer = new FileWriter("User_information.txt")) {
                    writer.write(groceryText);
                    JOptionPane.showMessageDialog(null, "Information saved successfully!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred while saving the information.");
                }
            }
        });
    
    
      
          window4.setLayout(null);
          window4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          window4.setVisible(true);
          window4.setResizable(false);


    }
    
}
