package choresmania;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dashboard 
{
 private final JTextField chore1 = new JTextField();
 private final JTextField chore2 = new JTextField();
 private final JTextField chore3 = new JTextField();
 private final JTextField chore4 = new JTextField();
     public Dashboard()
    {

        String fileName = "user_information.txt";
        String securityQuestion = null;
        String securityAnswer = null;
        String savedUsername = null;
        String passwordLine = null;
        String email = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Scanner sc = new Scanner(new File(fileName));
            //instantiating the StringBuffer class
            StringBuffer buffer = new StringBuffer();
            //Reading lines of the file and appending them to StringBuffer
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine()+System.lineSeparator());
            }
            String fileContents = buffer.toString();
            //closing the Scanner object
            sc.close();
            
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    savedUsername = line.substring(10);

                    // Read the next line for password
                    passwordLine = reader.readLine();
                    passwordLine = passwordLine.substring(10);
                    String loginCheck = reader.readLine();
                    email = reader.readLine();
                    email = email.substring(7);
                    securityQuestion = reader.readLine();
                    securityAnswer = reader.readLine();
                    String choresList = reader.readLine();
                    choresList = choresList.substring(9+savedUsername.length());
                    if(loginCheck.endsWith("true")){
                        break;
                    }
                    }
                }
            } catch (IOException e) {
            e.printStackTrace();
            }
      
      securityQuestion += "";
      //make login window
      JFrame window4 = new JFrame("Dashboard");
      window4.setSize(1500,1500);
      
      //set background color
      Container dp = window4.getContentPane();
      dp.setBackground(new Color(247, 205, 208));
      
      //Create header label
      JLabel header1 = new JLabel("Welcome " + savedUsername);
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

      
      chore1.setBounds(100,500,200,40);
      window4.add(chore1);
      chore1.getText();
      

      
      chore2.setBounds(100,600,200,40);
      window4.add(chore2);
      chore2.getText();

      //JTextField chore3 = new JTextField();
      chore3.setBounds(100,700,200,40);
      window4.add(chore3);
      chore3.getText();

      //JTextField chore4 = new JTextField();
      chore4.setBounds(100,800,200,40);
      window4.add(chore4);
      chore4.getText();

      JButton gobtn = new JButton("GO");
      gobtn.setBounds(1200,900,200,40);
      window4.add(gobtn);

      JLabel grocery = new JLabel("Grocery List:");
      grocery.setFont(new Font("Serif",Font.PLAIN,30));
      grocery.setBounds(550,350,500,70);
      window4.add(grocery);

      JTextArea grocerylist = new JTextArea();
      grocerylist.setBounds(510,450,300,400);
      window4.add(grocerylist);


      gobtn.addActionListener(new ActionListener() 
      {
        public void actionPerformed(ActionEvent e) 
        {
            String fileName = "user_information.txt";
            String securityQuestion = null;
            String securityAnswer = null;
            String savedUsername = null;
            String passwordLine = null;
            String email = null;
            String chores = null;
            ArrayList<String> allChores = new ArrayList<String>();
            allChores.add(chore1.getText());
            allChores.add(chore2.getText());
            allChores.add(chore3.getText());
            allChores.add(chore4.getText());
            System.out.println(allChores);
            Collections.shuffle(allChores);
            System.out.println(allChores);
            String formattedChores = formatArrayList(allChores);
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                Scanner sc = new Scanner(new File(fileName));
                StringBuffer buffer = new StringBuffer();
                while (sc.hasNextLine()) {
                    buffer.append(sc.nextLine()+System.lineSeparator());
                }
                String fileContents = buffer.toString();
                sc.close();
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("Username: ")) {
                        savedUsername = line.substring(10);

                        // Read the next line for password
                        passwordLine = reader.readLine();
                        passwordLine = passwordLine.substring(10);
                        String loginCheck = reader.readLine();
                        email = reader.readLine();
                        email = email.substring(7);
                        securityQuestion = reader.readLine();
                        securityAnswer = reader.readLine();
                        String choresList = reader.readLine();
                        chores = choresList.substring(9+savedUsername.length());

                        if(loginCheck.endsWith("true")){
                            fileContents = fileContents.replace(choresList, savedUsername + " Chores: "+formattedChores);
                            FileWriter writer = new FileWriter(fileName);
                            System.out.println("");
                            System.out.println("new data: "+fileContents);
                            writer.append(fileContents);
                            writer.close();
                            System.out.println("Current user: " + savedUsername);
                            System.out.println("Chores: " + choresList);
                            
                            break;
                        }
                        }
                    }
                } catch (IOException ea) {
                ea.printStackTrace();
                }
        }
        
           
      });


  
      window4.setLayout(null);
      window4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window4.setVisible(true);
      window4.setResizable(false);


    }
    public static String formatArrayList(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    //for the next page
    /* Example usage 
        String inputString = "A, B, C, D";
        ArrayList<String> arrayList = convertToArrayList(inputString);
        System.out.println(arrayList);
    */
    public static ArrayList<String> convertToArrayList(String inputString) {
        List<String> stringList = Arrays.asList(inputString.split(",\\s*"));
        return new ArrayList<>(stringList);
    }
    
}
