class Player {
    private String name;
    private int score;

    // Constructor to initialize player
    public Player(String playerName) {
        if (playerName == null || playerName.trim().length()== 0) {  // Throw exception if name is empty
            throw new IllegalArgumentException("Player name cannot be empty");
        }
        setName(playerName);  // Using setter for name
        setScore(0); // Initialize score to 0 using setter method
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name with validation
    public void setName(String playerName) {
        if (playerName == null || playerName.trim().length() == 0) {
            throw new IllegalArgumentException("Player name cannot be empty"); // Throw exception if name is empty
        }
        name = playerName;  // Setting name
    }

    // Getter for score
    public int getScore() {
        return score;
    }

    // Setter for score with validation to ensure it is non-negative
    public void setScore(int newScore) {
        if (newScore < 0) {
            throw new IllegalArgumentException("Score cannot be negative");  // Validate that score is not negative
        }
        score = newScore;  // Setting score
    }

    // Method to update score which is used in the game class
    public void updateScore(int scoreChange) {
        setScore(getScore() + scoreChange);  // Using getter and setter to update score
    }
}
