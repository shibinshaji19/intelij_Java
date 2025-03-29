class Game {
    private Player player1;
    private Player player2;
    private int gamesPlayed;
    // Constructor to initialize the game with two players
    public Game(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
        gamesPlayed = 0; // Initialize number of games played
    }
    // Method to start the game
    public void start() {
        while (gamesPlayed < 3) {
            System.out.println("\nBowling Game " + (gamesPlayed + 1));
            int initialScore1 = player1.getScore(); // Store player's initial score before the game
            int initialScore2 = player2.getScore(); // Store player's initial score before the game

            Turn turn = new Turn(player1, player2); // Create a Turn object to handle each player's turn
            turn.play(); // Execute the turns for both players
            gamesPlayed++;  // Increment the number of games played

            // Display score after each game
            int gameScore1 = player1.getScore() - initialScore1;
            int gameScore2 = player2.getScore() - initialScore2;
            System.out.println("\nScores after Game " + gamesPlayed + ":");
            System.out.println(player1.getName() + "'s score: " + gameScore1);
            System.out.println(player2.getName() + "'s score: " + gameScore2);
        }

        // Final score display after all 3 games
        System.out.println("\nFinal Scores: ");
        System.out.println(player1.getName() + "'s total score: " + player1.getScore());
        System.out.println(player2.getName() + "'s total score: " + player2.getScore());

        // Finding the winner
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " won!");
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println(player2.getName() + " won!");
        } else {
            System.out.println("Game tied!");
        }
    }
}
