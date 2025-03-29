import java.util.Scanner;

class Throw {
    public static int getScore(String playerName) {
        Scanner scanner = new Scanner(System.in);
        int pins = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(playerName + ", enter score (0-10): ");
                pins = scanner.nextInt();  // Taking input as an integer
                if (pins < 0 || pins > 10) {
                    System.out.println("Invalid input! Score must be between 0 and 10.");
                } else {
                    validInput = true;  // Exit the loop when valid input is given
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next();  // Prevent infinite loop
            }
        }

        return pins;
    }
}
