// Author - Shibin Shaji
// Date Created - 30 January 2025
// Description - Purpose of this program is calculate BMI of a person.
// Importing library
import java.util.Scanner;
public class Body_mass_index {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Declaring variables required
        double height;
        double weight;
        double bmi;
        // Getting inputs from the user
        System.out.println("Enter your height in inches");
        height = input.nextDouble();
        // Validating the user inputs
        while (height < 24 || height > 120) {
            System.out.println("Out of range value detected. Please enter a value between 24 and 120 inches");
            height = input.nextDouble();
        }
        System.out.println("Enter your weight in pounds");
        weight = input.nextDouble();
        // Validating user input
        while (weight < 25) {
            System.out.println("Out of range value detected, Please enter a value greater than 25");
            weight = input.nextDouble();
        }
        // Calculation
        bmi = (weight * 703)/(height * height);
        // Displaying outputs
        System.out.printf("Your height is"+" "+height+" "+"inches"+" "+"and you weight is"+" "+weight+" "+"pounds.");
        System.out.printf("Your body mass index is %.1f\n", bmi);
        if (bmi < 16) {
            System.out.println("BMI category: Severely Underweight");
        } else if (bmi >= 16 && bmi < 18.5) {
            System.out.println("BMI category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("BMI category: Healthy");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("BMI category: Overweight");
        } else {
            System.out.println("BMI category: Obese");
        }
    }
}
