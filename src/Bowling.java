import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name of 1st player: ");
        String player1 = scanner.nextLine();
        System.out.print("Enter name of 2nd player: ");
        String player2 = scanner.nextLine();

        System.out.println("\nBowling Game");
        getGameScores(player1, player2);

        System.out.print("Do you want to play another game? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            main(args);
        } else {
            System.out.println("Exiting program.");
        }
    }

    public static int getRoll(String playerName) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print(playerName + " Enter score (0-10): ");
            int pins = scanner.nextInt();
            if (pins >= 0 && pins <= 10) {
                return pins;
            }
            System.out.println("Invalid input. Enter a number between 0 and 10.");
        } catch (Exception e) {
            System.out.println("Invalid input. Enter a valid number.");
            scanner.next();
        }
        return getRoll(playerName);
    }

    public static int[] getTurnScores(String player, boolean isLastFrame) {
        int roll1 = getRoll(player);
        int roll2 = 0;
        int roll3 = 0;

        if (roll1 == 10) {
            System.out.println("You hit strike, you get a third try."); // Strike
            roll2 = getRoll(player);
            if (roll2 == 10) {
                roll3 = getRoll(player);
            } else {
                roll3 = getRoll(player);
                while (roll2 + roll3 > 10) {
                    System.out.println("Invalid input, Total score of 2nd and 3rd roll cannot be over 10");
                    roll3 = getRoll(player);
                }
            }
            return new int[]{roll1, roll2, roll3};
        } else {
            roll2 = getRoll(player);
            while (roll1 + roll2 > 10 && !isLastFrame) {
                System.out.println("Invalid input, Total score cannot be over 10.");
                roll2 = getRoll(player);
            }
            if (isLastFrame && roll1 + roll2 == 10) {
                roll3 = getRoll(player);
            }
            return new int[]{roll1, roll2, roll3};
        }
    }

    public static void getGameScores(String player1, String player2) {
        int[][] scores1 = new int[10][];
        int[][] scores2 = new int[10][];
        int total1 = 0, total2 = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("\nFrame " + (i + 1) + ":");
            System.out.println(player1 + "'s turn:");
            scores1[i] = getTurnScores(player1, i == 9);
            System.out.println(player2 + "'s turn:");
            scores2[i] = getTurnScores(player2, i == 9);
        }

        System.out.println("\nScores:");

        total1 = 0;
        System.out.print(player1 + "'s frames: ");
        for (int i = 0; i < scores1.length; i++) {
            int[] frame = scores1[i];
            System.out.print("[" + frame[0] + ", " + frame[1]);
            if (frame.length == 3) {
                System.out.print(", " + frame[2]);
            }
            System.out.print("] ");
            for (int j = 0; j < frame.length; j++) {
                total1 += frame[j];
            }
        }
        System.out.println("\n" + player1 + "'s total score: " + total1);

        total2 = 0;
        System.out.print(player2 + "'s frames: ");
        for (int i = 0; i < scores2.length; i++) {
            int[] frame = scores2[i];
            System.out.print("[" + frame[0] + ", " + frame[1]);
            if (frame.length == 3) {
                System.out.print(", " + frame[2]);
            }
            System.out.print("] ");
            for (int j = 0; j < frame.length; j++) {
                total2 += frame[j];
            }
        }
        System.out.println("\n" + player2 + "'s total score: " + total2);

        if (total1 > total2) {
            System.out.println("\n" + player1 + " won");
        } else if (total1 < total2) {
            System.out.println("\n" + player2 + " won");
        } else {
            System.out.println("\nGame tied!");
        }
    }
}
