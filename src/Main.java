// Author : Shibin Shaji
// Date created : March 20. 2025
// Purpose of program is to get familiar using getter/setter and exception handling
public class Main {
    public static void main(String[] args) {
        // Tty and catch to display any exceptions
        try {
            // Create two instances of the Player class
            Player player1 = new Player();
            player1.setterName("jake"); // Setting player1's name
            player1.setterWins(2);      // Setting player1's wins
            player1.setterScore(94);   // Setting player1's score

            Player player2 = new Player();
            player2.setterName("taylor");  // Setting player2's name
            player2.setterWins(3);      // Setting player2's wins
            player2.setterScore(100);   // Setting player2's score

            // Displaying the information of both players using toString method
            System.out.println(player1);
            System.out.println(player2);

        } catch (IllegalArgumentException e) {
            // Catching and printing the exception messages when there is any.
            System.out.println("Error: " + e.getMessage());
        }
    }
}

