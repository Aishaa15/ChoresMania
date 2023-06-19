
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpPage extends JFrame {
    private JTextField nameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField securityQuestionField;
    private JTextField securityAnswerField;


    public SignUpPage() {
        initializeUI();
    }


        this.loginPage = loginPage;
    }

    private void initializeUI() {
        // Set the title and size of the window
        setTitle("Sign Up");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with null layout
        JPanel panel = new JPanel();
        panel.setLayout(null);


        // Add the panel to the window
        add(panel);
        setVisible(true);
    }

    // Method to handle sign up process
    private void signUp() {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();
        String securityQuestion = securityQuestionField.getText();
        String securityAnswer = securityAnswerField.getText();

        // Check if any field is empty
        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty()
                || securityQuestion.isEmpty() || securityAnswer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sign up not successful. Please try again.");
        } else {
            saveUserInformation(name, username, password, email, securityQuestion, securityAnswer);
            JOptionPane.showMessageDialog(this, "Sign up successful!");
            dispose();


            // Clear the fields after sign-up
            nameField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            emailField.setText("");
            securityQuestionField.setText("");
            securityAnswerField.setText("");

        }
    }

    // Method to save user information to a file
    private void saveUserInformation(String name, String username, String password, String email,
                                     String securityQuestion, String securityAnswer) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("user_information.txt", true));
            writer.println("Name: " + name);
            writer.println("Username: " + username);
            writer.println("Password: " + password);
            writer.println("Email: " + email);
            writer.println("Security Question: " + securityQuestion);
            writer.println("Security Answer: " + securityAnswer);
            writer.println();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

