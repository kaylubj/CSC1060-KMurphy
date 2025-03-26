/*
Rational Numbers
Kaylub Murphy
03/24/2025
Purpose: Create a rational class
 */
public class Rational {
    private int numerator;
    private int denominator;

    //Make the two constructors:
    Rational() {
        numerator = 0;
        denominator = 1;
    }

    Rational(int n, int d) {
        numerator = n;
        denominator = d;
    }

    //Print the ratio
    public String toString() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }

    //Negate numerator
    public boolean negate() {
        numerator = -1 * numerator;
        return false;
    }

    //Invert the number
    public boolean invert() {
        boolean retVal = false;
        if (numerator != 0) {
            int temp = numerator;
            numerator = denominator;
            denominator = temp;
            retVal = true;
        }
        return retVal;
    }

    //Convert to a decimal
    public double toDouble() {
        return (double) numerator / denominator;
    }

    /*Return greatest common divisor
    Divide n/d and save remainder as r
    If remainder = 0 then d is your answer
    If not set n = d and d = r and repeat
    */
    public int gcd() {
        int retVal = denominator;
        int n = numerator;
        int rem = n % retVal;
        while (rem != 0) {
            n = retVal;
            retVal = rem;
            rem = n % retVal;
        }
        return retVal;
    }
}
