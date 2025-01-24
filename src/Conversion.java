// Author - Shibin Shaji
// Date Created - 23 January 2025
// Description - Purpose of this program is to convert unit of measurements
// Meter to kilometer
// Celsius to fahrenheit
// Gram to kilogram
// Libraries required
import java.util.Scanner;
public class Conversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Declaring variables
        double meter;
        double kilometer;
        double gram;
        double kilogram;
        double celsius;
        double fahrenheit;
        // Getting inputs from the user
        System.out.println("Enter a number in meters to convert to kilometer");
        meter = input.nextDouble();
        System.out.println("Enter a number in gram to convert to kilogram");
        gram = input.nextDouble();
        System.out.println("Enter a number in celsius to convert to fahrenheit");
        // Conversions
        celsius = input.nextDouble();
        kilometer = meter / 1000;
        kilogram = gram / 1000;
        fahrenheit = (celsius * 9/5) + 32;
        // Displaying output
        System.out.println(meter+ "m is equivalent to: "+kilometer+"km");
        System.out.println(gram+ "g is equivalent to: "+kilogram+ "kg");
        System.out.println(celsius+ "c is equivalent to:"+fahrenheit+"f");
    }

}
