import java.util.Scanner;

class Turn {
    private Player player1;
    private Player player2;
    // Constructor to initialize the turn with two players
    public Turn(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }
    // Method to manage each player's turn in the game
    public void play() {
        for (int i = 0; i < 10; i++) {  // For each frame
            System.out.println("\nFrame " + (i + 1));

            // Player 1's turn
            System.out.println(player1.getName() + "'s turn:");
            int[] rollResults1 = getTurnScores(player1.getName()); // Get roll results for Player 1
            int frameScore1 = rollResults1[0] + rollResults1[1] + rollResults1[2];  // Calculate frame score for Player 1
            player1.updateScore(frameScore1);  // Update score

            // Player 2's turn
            System.out.println(player2.getName() + "'s turn:");
            int[] rollResults2 = getTurnScores(player2.getName()); // Get roll results for Player 2
            int frameScore2 = rollResults2[0] + rollResults2[1] + rollResults2[2]; // Calculate frame score for Player 2
            player2.updateScore(frameScore2);  // Update score
        }
    }
    // Method to get the scores of a player's turn (handles strikes, spares, and regular rolls)
    public static int[] getTurnScores(String player) {
        int roll1 = Throw.getScore(player);
        int roll2 = 0;
        int roll3 = 0;

        if (roll1 == 10) {
            System.out.println("You hit a strike! You get a third try.");
            roll2 = Throw.getScore(player);

            if (roll2 == 10) {
                System.out.println("You hit a strike again!");
                roll3 = Throw.getScore(player);

                if (roll1 + roll2 + roll3 == 30) {
                    System.out.println("You hit a turkey!");
                }
            } else {
                roll3 = Throw.getScore(player);
                while (roll2 + roll3 > 10) {
                    System.out.println("Invalid input. Total score of second and third rolls cannot exceed 10.");
                    roll3 = Throw.getScore(player);
                }
            }
            return new int[]{roll1, roll2, roll3};
        } else {
            roll2 = Throw.getScore(player);
            if (roll1 + roll2 == 10) {
                System.out.println("You hit a spare! You get a third try.");
                roll3 = Throw.getScore(player);
            }

            while (roll1 + roll2 > 10) {
                System.out.println("Invalid input. Total score cannot exceed 10.");
                roll2 = Throw.getScore(player);
            }

            return new int[]{roll1, roll2, roll3};
        }
    }
}
