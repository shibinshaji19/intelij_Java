// Author - Shibin Shaji
// Date Created - 19 February 2025
// Description - Purpose of this program is to create few functions and call it from different class.
public class NumberTools {
    static boolean isEven(int x) {
        return x % 2 == 0; // checks if remainder of this math is zero
    }

    static boolean isPositive(int x) {
        return x > 0; // checks if value is greater than zero
    }

    static boolean isPower(int x) {
        if (x <= 0) return false; // displays false if its equal or less than 0
        while (x % 2 == 0) {       // Keep dividing by 2 until value of x is 1 to check is it's a power of 2
            x = x / 2;
        }
        return x == 1;
    }

    static boolean isSquare(int x) {
        if (x < 0) return false; // return false if value less than 0
        int num = (int) Math.sqrt(x); // takes square root of x and convert to integer and stores in variable
        return num * num == x; // squares the saved value to see if its equal to value of x
    }
}
