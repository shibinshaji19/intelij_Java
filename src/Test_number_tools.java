// Author - Shibin Shaji
// Date Created - 19 February 2025
// Description - Purpose of this program is to use functions from different class.
// Importing library
import java.util.Scanner;
public class Test_number_tools {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Welcome to number analyzer \n"); //title
        int num;
            try { //validation
                System.out.println("Please enter an integer to analyze"); //taking user input
                num = scanner.nextInt();
                //printing the results after passing the value through functions
                System.out.println("Number: " + num);
                System.out.println("Is it a even number? " + NumberTools.isEven(num));
                System.out.println("Is it a positive number? " + NumberTools.isPositive(num));
                System.out.println("Is it a power of 2? " + NumberTools.isPower(num));
                System.out.println("Is it a perfect square? " + NumberTools.isSquare(num));

            } catch (Exception e) { // invalid error message
                System.out.println("Error: Invalid input. Please enter an integer.");
            }

        }
    }
