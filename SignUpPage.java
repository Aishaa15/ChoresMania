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
        setTitle("Sign Up");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        panel.add(usernameLabel);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        panel.add(passwordLabel);
        panel.add(passwordField);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel securityQuestionLabel = new JLabel("Security Question:");
        securityQuestionField = new JTextField(20);
        panel.add(securityQuestionLabel);
        panel.add(securityQuestionField);

        JLabel securityAnswerLabel = new JLabel("Security Answer:");
        securityAnswerField = new JTextField(20);
        panel.add(securityAnswerLabel);
        panel.add(securityAnswerField);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });
        panel.add(signUpButton);

        add(panel);
        setVisible(true);
    }

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