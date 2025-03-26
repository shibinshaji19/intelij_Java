// Author : Shibin Shaji
// Date created : March 20. 2025
// Purpose of program is to get familiar using getter/setter and exception handling
public class Player {
    private String name; //instance variable declaration
    private int wins;
    private int score;

    // Getting player name
    public String getterName() {
        return name;
    }
    // Getting number of wins
    public int getterWins() {
        return wins;
    }
    // Getting score
    public int getterScore() {
        return score;
    }
    // Validation and setting players name
    public void setterName(String playerName) {
        if (playerName == null) {
            throw new IllegalArgumentException("Name cannot be empty"); // Throwing an exception
        }
        name = playerName;
    }
    // Setting number of wins and validation
    public void setterWins(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Win cannot be negative.");
        }
        wins = number;
    }
    // Setting the scores of player
    public void setterScore(int playerScore) {
        if (playerScore < 0) {
            throw new IllegalArgumentException("Score cannot be negative.");
        }
        score = playerScore;
    }
    // Overriding the toString method to display the information of player
    @Override
    public String toString() {
        return "Player{name='" + name + "', wins=" + wins + ", score=" + score + "}";
    }
}
