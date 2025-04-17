// Author: Shibin Shaji
// Date Created: April 15, 2025
// Purpose: Create a application to manage a Vet Clinic

// Importing Swing
import javax.swing.*;
// For layout properties
import java.awt.*;
// For handling button clicks
import java.awt.event.*;
// For file writing
import java.io.*;
// For date/time
import java.util.Date;
// For email format validation
import java.util.regex.Pattern;

public class VetClinic {
    // Method to validate if the email address, Reference: https://www.geeksforgeeks.org/pattern-compilestring-method-in-java-with-examples/
    public static boolean isValidEmail(String email) {
        String regexPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regexPattern);  // Compiling the regex pattern into a pattern object
        return pattern.matcher(email).matches(); // Match the input email against the pattern
    }

    public static void main(String[] args) {
        // Creating the main window (JFrame)
        JFrame frame = new JFrame("Vet Patient Registration");
        frame.setSize(500, 400); // Setting window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app on window close

        // Creating a panel with 6 rows and 1 column to hold everything
        JPanel mainPanel = new JPanel(new GridLayout(6, 1));

        // Patient Name Panel
        JPanel patientPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Left-align panel
        JLabel patientLabel = new JLabel("Patient Name:"); // Label for patient name
        JTextField patientBox = new JTextField(20); // Text field
        patientPanel.add(patientLabel); // Add label to panel
        patientPanel.add(patientBox); // Add field to panel

        // Owner Name Panel
        JPanel ownerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel ownerLabel = new JLabel("Owner Name:");
        JTextField ownerBox = new JTextField(20);
        ownerPanel.add(ownerLabel);
        ownerPanel.add(ownerBox);

        // Email Panel
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel emailLabel = new JLabel("Email Address:");
        JTextField emailBox = new JTextField(20);
        emailPanel.add(emailLabel);
        emailPanel.add(emailBox);

        // Vet Selection Panel
        JPanel vetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel vetLabel = new JLabel("Veterinarian:");

        // Radio buttons for selecting a vet
        JRadioButton vet1 = new JRadioButton("Dr. David");
        JRadioButton vet2 = new JRadioButton("Dr. Davis");
        JRadioButton vet3 = new JRadioButton("Dr. Dre");
        vet1.setSelected(true); // Set default selected vet

        // Grouping radio buttons to allow only one selection
        ButtonGroup vetGroup = new ButtonGroup();
        vetGroup.add(vet1);
        vetGroup.add(vet2);
        vetGroup.add(vet3);

        // Add components to vet panel
        vetPanel.add(vetLabel);
        vetPanel.add(vet1);
        vetPanel.add(vet2);
        vetPanel.add(vet3);

        // Message Panel
        JPanel messagePanel = new JPanel(); // Empty panel for messages
        JLabel messageLabel = new JLabel(" "); // Label to show messages
        messageLabel.setForeground(Color.GRAY); // Set message color to gray
        messagePanel.add(messageLabel);

        // Button Panel
        JPanel buttonPanel = new JPanel(); // Panel for Register, Clear, Exit buttons
        JButton registerButton = new JButton("Register"); // Button to register
        JButton clearButton = new JButton("Clear"); // Button to clear form
        JButton exitButton = new JButton("Exit"); // Button to exit app
        buttonPanel.add(registerButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        // Add All Panels to Main Panel
        mainPanel.add(patientPanel);
        mainPanel.add(ownerPanel);
        mainPanel.add(emailPanel);
        mainPanel.add(vetPanel);
        mainPanel.add(messagePanel);
        mainPanel.add(buttonPanel);

        // Add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true); // Show the frame

        // Email Validation Regex
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get and trim input values from the text fields
                String patient = patientBox.getText().trim();
                String owner = ownerBox.getText().trim();
                String email = emailBox.getText().trim();

                // Validate if patient name is empty
                if (patient.isEmpty()) {
                    messageLabel.setText("Patient name cannot be empty.");
                    messageLabel.setForeground(Color.RED); // Set message color to red
                    return; // Stop execution if validation fails
                }

                // Validate if owner name is empty
                if (owner.isEmpty()) {
                    messageLabel.setText("Owner name cannot be empty.");
                    messageLabel.setForeground(Color.RED);
                    return;
                }

                // Validate if email is empty
                if (email.isEmpty()) {
                    messageLabel.setText("Email address cannot be empty.");
                    messageLabel.setForeground(Color.RED);
                    return;
                }

                // Validate email format using regex
                if (!isValidEmail(email)) {
                    messageLabel.setText("Invalid email format.");
                    messageLabel.setForeground(Color.RED);
                    return;
                }

                // Determine which vet radio button is selected
                String vet = "";
                if (vet1.isSelected()) { // Reference: https://www.cs.rutgers.edu/courses/111/classes/fall_2011_tjang/texts/notes-java/GUI/components/50radio_buttons/25radiobuttons.html
                    vet = "Dr. David";
                } else if (vet2.isSelected()) {
                    vet = "Dr. Davis";
                } else if (vet3.isSelected()) {
                    vet = "Dr. Dre";
                }
                // Try to open a save dialog and write the form data to the selected file
                BufferedWriter bw = null;
                try {
                    JFileChooser fileChooser = new JFileChooser(); // File dialog
                    int option = fileChooser.showSaveDialog(frame); // Show dialog

                    if (option == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile(); // Get selected file
                        bw = new BufferedWriter(new FileWriter(file, true));
                        bw.write("Patient Registration\n");
                        bw.write("Patient: " + patient + "\n");
                        bw.write("Owner: " + owner + "\n");
                        bw.write("Email: " + email + "\n");
                        bw.write("Vet: " + vet + "\n");
                        bw.write("Date: " + new Date() + "\n");
                        messageLabel.setText("Registration saved");
                        messageLabel.setForeground(Color.BLUE);
                    }
                } catch (IOException ee) {
                    messageLabel.setText("Error saving file.");
                    messageLabel.setForeground(Color.RED);
                } finally {
                    try {
                        if (bw != null) {
                            bw.close(); // Close even if there's an error
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        // Clear Button
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reset form fields
                patientBox.setText("");
                ownerBox.setText("");
                emailBox.setText("");
                vet1.setSelected(true); // Reset vet to default
                messageLabel.setText("All fields cleared."); // Show message
                messageLabel.setForeground(Color.GRAY);
            }
        });

        // Exit Button
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
