

        // Adding components to the panel
        panel.add(header);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        // Add the panel to the window
        add(panel);
        setVisible(true);
    }

    // Method to handle login process
    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Read the user information from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    String savedUsername = line.substring(10);

                    // Read the next line for password
                    String passwordLine = reader.readLine();
                    if (passwordLine != null && passwordLine.startsWith("Password: ")) {
                        String savedPassword = passwordLine.substring(10);

                        if (username.equals(savedUsername) && password.equals(savedPassword)) {
                            found = true;
                            break;
                        }
                    }
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose();
                // Place your code here for the next step after successful login
            } else {
                JOptionPane.showMessageDialog(this, "Login failed. Please try again.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while reading the file.");
        }

        // Clear the fields after login attempt
        usernameField.setText("");
        passwordField.setText("");
    }
}
