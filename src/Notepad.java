// Author: Shibin Shaji
// Date: April 9, 2025
// Purpose: This program creates a notepad in a GUI.
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Notepad {
    public static void main(String[] args) {
        // Create buttons for opening a file, saving a file, closing the application, and toggling dark/light mode
        JButton openFileButton = new JButton("Open File");
        JButton saveFileButton = new JButton("Save File");
        JButton closeButton = new JButton("Close");
        JButton toggleModeButton = new JButton("Dark/Light");

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openFileButton);
        buttonPanel.add(saveFileButton);
        buttonPanel.add(closeButton);
        buttonPanel.add(toggleModeButton);  // Added the new toggle button

        // Creating a frame for the editor
        JFrame editorFrame = new JFrame("Notepad");

        // Creating a JTextArea where user can type
        JTextArea textField = new JTextArea();

        // Adding the JTextArea in a JScrollPane to the center of the frame
        editorFrame.getContentPane().add(new JScrollPane(textField), BorderLayout.CENTER);

        // Adding the button panel to the bottom of the frame
        editorFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Open button opens file chooser to open a file
        openFileButton.addActionListener(event -> {
            // Create the file chooser
            JFileChooser fileChooser = new JFileChooser();

            // Show the file chooser and get the user's choice
            int userOption = fileChooser.showOpenDialog(editorFrame);

            // If the user selects a file, read its content into the JTextArea
            if (userOption == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                File selectedFile = fileChooser.getSelectedFile();

                // Reads the content of the selected file and display it in the JTextArea
                try (BufferedReader fileReader = new BufferedReader(new FileReader(selectedFile))) {
                    textField.read(fileReader, null); // Read content into JTextArea
                } catch (Exception e) {
                    // Handle any errors
                    e.printStackTrace();
                }
            }
        });

        // Save button saves the file
        saveFileButton.addActionListener(event -> {
            // Creating the file chooser
            JFileChooser fileChooser = new JFileChooser();

            // Show the file chooser and get the user input
            int userOption = fileChooser.showSaveDialog(editorFrame);

            // If the user selects a file, save the content of the JTextArea to it
            if (userOption == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                File selectedFile = fileChooser.getSelectedFile();

                // Writes the content of the JTextArea to the selected file
                try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(selectedFile))) {
                    textField.write(fileWriter);  // Write the content to the file
                } catch (Exception e) {
                    // Handle any errors
                    e.printStackTrace();
                }
            }
        });

        // Closing the application button
        closeButton.addActionListener(event -> System.exit(0));

        // Toggle Dark/Light Mode
        toggleModeButton.addActionListener(e -> {
            // Check current background color and switch between dark and light mode
            if (textField.getBackground().equals(Color.BLACK)) {
                textField.setBackground(Color.WHITE);  // Set background to white for light mode
                textField.setForeground(Color.BLACK);  // Set text color to black for light mode
            } else {
                textField.setBackground(Color.BLACK);  // Set background to black for dark mode
                textField.setForeground(Color.WHITE);  // Set text color to white for dark mode
            }
        });

        // Setting the window size
        editorFrame.setSize(800, 500);

        // Program exits when the user closes the window
        editorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible to the user
        editorFrame.setVisible(true);
    }
}
