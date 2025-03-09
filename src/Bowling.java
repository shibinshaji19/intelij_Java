// Author - Shibin Shaji
// Date Created - 6 March 2025
// Description - Purpose of this program is to record scores for bowling game.
// Importing library
import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // creating scanner class  to scan user input

        System.out.print("Enter name of 1st player: ");// asking user for name of first player
        String player1 = scanner.nextLine();
        System.out.print("Enter name of 2nd player: ");// asking user for name of second player
        String player2 = scanner.nextLine();

        System.out.println("\nBowling Game"); // displaying title
        getGameScores(player1, player2); // using function to get scores of both player

        System.out.print("Do you want to play another game? (yes/no): "); // asking user if they want to record scores of another game
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            main(args);
        } else { // if no, exiting the program
            System.out.println("Exiting program.");
        }
    }

    public static int getRoll(String playerName) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print(playerName + " Enter score (0-10): "); // asking player for their roll
            int pins = scanner.nextInt();
            if (pins >= 0 && pins <= 10) { // validating user input
                return pins;
            }
            System.out.println("Invalid input. Enter a number between 0 and 10."); // asking user again if input exceeds (0-10) range
        } catch (Exception e) {
            System.out.println("Invalid input. Enter a valid number."); // showing error message if they enter special characters
            scanner.next();
        }
        return getRoll(playerName); // using recursion to calling itself
    }

    public static int[] getTurnScores(String player, boolean lastFrame) { // method to manage player's turn, strike and spares
        int roll1 = getRoll(player); // first roll
        int roll2 = 0; // second roll
        int roll3 = 0; // third roll if they hit a strike or spare on last frame

        if (roll1 == 10) { // checking if player hit a strike on roll1
            System.out.println("You hit strike, you get a third try."); // Strike
            roll2 = getRoll(player);
            if (roll2 == 10) { // checking if player hit a strike on roll2
                roll3 = getRoll(player);
            } else {
                roll3 = getRoll(player);
                while (roll2 + roll3 > 10) { // validating for total of 2nd and 3rd cannot exceed 10 unless they hit a strike
                    System.out.println("Invalid input, Total score of 2nd and 3rd roll cannot be over 10");
                    roll3 = getRoll(player);
                }
            }
            return new int[]{roll1, roll2, roll3};
        } else {
            roll2 = getRoll(player); // player gets only two roll if they haven't hit a strike
            while (roll1 + roll2 > 10 && !lastFrame) { // player gets extra roll on last frame if they hit spare also checking if total of both rolls cannot exceed 10
                System.out.println("Invalid input, Total score cannot be over 10.");
                roll2 = getRoll(player);
            }
            if (lastFrame && roll1 + roll2 == 10) { //player gets extra roll on last frame if they hit spare
                roll3 = getRoll(player);
            }
            return new int[]{roll1, roll2, roll3};
        }
    }

    public static void getGameScores(String player1, String player2) {
        int[][] scores1 = new int[10][]; // array to store player 1's scores for each frame
        int[][] scores2 = new int[10][]; // array to store player 2's scores for each frame
        int total1 = 0;
        int total2 = 0; // variables to store total of both players

        for (int i = 0; i < 10; i++) { // loop to process each frame
            System.out.println("\nFrame " + (i + 1) + ":");
            System.out.println(player1 + "'s turn:");
            scores1[i] = getTurnScores(player1, i == 9); // get player 1's scores for the current frame
            System.out.println(player2 + "'s turn:");
            scores2[i] = getTurnScores(player2, i == 9); // get player 2's scores for the current frame
        }

        System.out.println("\nFinal Scores");
        // display player 1's scores and calculate their total
        total1 = 0;
        System.out.print(player1 + "'s frames: ");
        for (int i = 0; i < scores1.length; i++) {
            int[] frame = scores1[i]; // getting the current frame for player 1
            System.out.print("[" + frame[0] + ", " + frame[1]); // printing first two rolls of frame
            if (frame.length == 3) { // checking if there is third roll
                System.out.print(", " + frame[2]); // printing third roll
            }
            System.out.print("] ");
            for (int j = 0; j < frame.length; j++) { // looping through the roll to calculate the final score
                total1 += frame[j]; //adding the score
            }
        }
        System.out.println("\n" + player1 + "'s total score: " + total1);
        // display player 2's scores and calculate their total
        total2 = 0;
        System.out.print(player2 + "'s frames: ");
        for (int i = 0; i < scores2.length; i++) {
            int[] frame = scores2[i]; // getting the current frame for player 2
            System.out.print("[" + frame[0] + ", " + frame[1]); // printing first two rolls of frame
            if (frame.length == 3) { // checking if there is third roll
                System.out.print(", " + frame[2]); // printing third roll
            }
            System.out.print("] ");
            for (int j = 0; j < frame.length; j++) { // looping through the roll to calculate the final score
                total2 += frame[j]; //adding the score
            }
        }
        System.out.println("\n" + player2 + "'s total score: " + total2);

        if (total1 > total2) { // checking who won the game
            System.out.println("\n" + player1 + " won");
        } else if (total1 < total2) {
            System.out.println("\n" + player2 + " won");
        } else {
            System.out.println("\nGame tied!"); // if the total scores are equal, it's a tie.
        }
    }
}
