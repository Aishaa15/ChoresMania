import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUpPage extends JFrame {
    private JTextField nameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField securityQuestionField;
    private JTextField securityAnswerField;

    private LoginPage loginPage;

    public SignUpPage() {
        initializeUI();
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    private void initializeUI() {
        // Set the title and size of the window
        setTitle("Sign Up");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with null layout
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Labels and text fields for user input
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 80, 20);
        nameField = new JTextField();
        nameField.setBounds(100, 10, 150, 20);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 40, 80, 20);
        usernameField = new JTextField();
        usernameField.setBounds(100, 40, 150, 20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 70, 80, 20);
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 70, 150, 20);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 100, 80, 20);
        emailField = new JTextField();
        emailField.setBounds(100, 100, 150, 20);

        JLabel securityQuestionLabel = new JLabel("Security Question:");
        securityQuestionLabel.setBounds(10, 130, 120, 20);
        securityQuestionField = new JTextField();
        securityQuestionField.setBounds(140, 130, 150, 20);

        JLabel securityAnswerLabel = new JLabel("Security Answer:");
        securityAnswerLabel.setBounds(10, 160, 120, 20);
        securityAnswerField = new JTextField();
        securityAnswerField.setBounds(140, 160, 150, 20);

        // Sign Up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(100, 200, 100, 30);
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });

        // Adding components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(securityQuestionLabel);
        panel.add(securityQuestionField);
        panel.add(securityAnswerLabel);
        panel.add(securityAnswerField);
        panel.add(signUpButton);

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

        saveUserInformation(name, username, password, email, securityQuestion, securityAnswer);
        JOptionPane.showMessageDialog(this, "Sign up successful!");

        // Clear the fields after sign-up
        nameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        emailField.setText("");
        securityQuestionField.setText("");
        securityAnswerField.setText("");
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
}