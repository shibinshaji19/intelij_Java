// Author - Shibin Shaji
// Date Created - 16 February 2025
// Description - Purpose of this program is to do a temperature analysis of x number of days.
// Importing library
import java.util.Scanner;
public class Temperature_analysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Main title
        System.out.println("\n Temperature Analysis \n");
        // Getting user input for number of days
        int days = 0; //initializing variable
        do {
            try { // validating user input using try and catch
                System.out.print("Enter the number of days to analyze (2-366): ");
                days = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Error: Invalid input. Please enter a valid number.");
                continue;
            }
            if (days < 2 || days > 366) {
                System.out.println("Error: Number exceed range, please enter a number between 2 and 366.");
            }
        } while (days < 2 || days > 366); // loops until valid input is received

        // Arrays to store temperature values
        double[] low_temp = new double[days];
        double[] high_temp = new double[days];
        double[] day_average = new double[days];
        // Collect temperature data
        for (int i = 0; i < days; i++) {
            System.out.println("\nDay " + (i + 1));
            double low = -101; //initializing boundary values
            double high = 101;
            do {
                try {  // validating user input using try and catch
                    System.out.print("Enter the low temperature: ");
                    low = scanner.nextDouble();

                    System.out.print("Enter the high temperature: ");
                    high = scanner.nextDouble();

                    // Validate the input ranges
                    if (low < -100 || low > 100 || high < -100 || high > 100) {
                        System.out.println("Error: Temperatures must be between -100 and 100.");
                        continue;
                    } else if (high < low) {
                        System.out.println("Error: High temperature cannot be lower than the low temperature.");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Error: Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                    continue;
                }
            } while (low < -100 || low > 100 || high < -100 || high > 100 || high < low);

            low_temp[i] = low;
            high_temp[i] = high;
            day_average[i] = (low + high) / 2;
        }
        // Calculate overall statistics
        double total_average = 0;
        double highest_temp = high_temp[0];
        double lowest_temp = low_temp[0];
        int highest_day = 1;//Stores day number that has the highest temperature, starting with Day 1
        int lowest_day = 1;//Stores day number that has the lowest temperature, starting with Day 1

        for (int i = 0; i < days; i++) {
            total_average += day_average[i];

            if (high_temp[i] > highest_temp) {
                highest_temp = high_temp[i];
                highest_day = i + 1;
            }
            if (low_temp[i] < lowest_temp) {
                lowest_temp = low_temp[i];
                lowest_day = i + 1;
            }
        }
        total_average = total_average/ days;
        // Display results
        System.out.println("\nAnalysis Results ");
        for (int i = 0; i < days; i++) {
            System.out.printf("Day %d: Low: %.1f celsius, High: %.1f celsius, Avg: %.1f celsius \n",
                    i + 1, low_temp[i], high_temp[i], day_average[i]);
        }
        System.out.printf("Overall Average Temperature: %.1f celsius \n", total_average);
        System.out.printf("Highest Temperature: %.1f celsius on Day %d\n", highest_temp, highest_day);
        System.out.printf("Lowest Temperature: %.1f celsius on Day %d\n", lowest_temp, lowest_day);

    }
}