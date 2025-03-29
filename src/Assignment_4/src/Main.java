// Author: Shibin Shaji
// Date : March 26, 2025
// Purpose: The purpose of this program is to familiarize using different classes with public and private methods or variables
import java.util.Scanner;

public class Main {
    // Custom exception class to handle invalid input
    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message); // This pass the message to superclass
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String player1Name = "", player2Name = ""; // Initializes two variables as empty strings
        Player player1 = null, player2 = null; // Initializes two Player objects as null

        // Validate Player 1 Name
        while (player1 == null) { // Ensuring player name is not empty
            try {
                System.out.print("Enter name of 1st player: ");
                player1Name = scanner.nextLine().trim(); // Get input and remove extra spaces
                if (player1Name.isEmpty()) {
                    throw new InvalidInputException("Player name cannot be empty."); // Throw custom exception for invalid input
                }
                player1 = new Player(player1Name);  // Creating player object
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage()); // Handle invalid input and display error message
            }
        }

        // Validate Player 2 Name
        while (player2 == null) {  // Ensuring player name is not empty
            try {
                System.out.print("Enter name of 2nd player: ");
                player2Name = scanner.nextLine().trim(); // Get input and remove extra spaces
                if (player2Name.isEmpty()) {
                    throw new InvalidInputException("Player name cannot be empty."); // Throw custom exception for invalid input
                }
                player2 = new Player(player2Name);  // Creating player object
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage()); // Handle invalid input and display error message
            }
        }

        // Start the Game
        Game game = new Game(player1, player2);  // Create Game object with Player 1 and Player 2
        game.start();
    }
}
