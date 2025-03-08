import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of 1st player: ");
        String player1 = scanner.nextLine();
        System.out.print("Enter name of 2nd player: ");
        String player2 = scanner.nextLine();

        System.out.println("\nWelcome to bowling\n");
        getGameScores(player1, player2);

        System.out.print("Do you like to record scores for another game? (yes/no): ");
        String input = scanner.nextLine();
        if (input.compareToIgnoreCase("yes") == 0) {
            main(args);
        } else {
            System.out.println("Exiting program");
        }
    }

    public static int getRoll(String playerName) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print(playerName + " Enter the score between (0-10): ");
            int pins = scanner.nextInt();

            if (pins >= 0 && pins <= 10) {
                return pins;
            } else {
                System.out.println("Invalid input. Please enter a number between 0 and 10.");
                return getRoll(playerName); // Recursion
            }
        } catch (Exception e) { // Catch all exceptions
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Takes invalid input to avoid infinite loop
            return getRoll(playerName); // Recursion
        }
    }

    public static int[] getTurnScores(String player, boolean lastFrame) {
        int try1 = getRoll(player);
        int try2 = 0;
        int try3 = 0;

        if (try1 == 10) { // Strike
            System.out.println("You hit strike, you get a third try.");
            try2 = getRoll(player);
            try3 = getRoll(player);
            return new int[]{10, try2, try3};
        } else {
            try2 = getRoll(player);
            while (try1 + try2 > 10) {
                System.out.println("Invalid input, total score cannot be over 10");
                try2 = getRoll(player);
            }
            if (lastFrame && try1 + try2 == 10) {
                try3 = getRoll(player);
            }
            return new int[]{try1, try2, try3};
        }
    }

    public static void getGameScores(String player1, String player2) {
        int[][] frames1 = new int[10][];
        int[][] frames2 = new int[10][];
        int totalScore1 = 0;
        int totalScore2 = 0;

        for (int frame = 0; frame < 10; frame++) {
            System.out.println("\nFrame " + (frame + 1) + ":");
            System.out.println(player1 + "'s turn");
            frames1[frame] = getTurnScores(player1, frame == 9);

            System.out.println(player2 + "'s turn");
            frames2[frame] = getTurnScores(player2, frame == 9);
        }