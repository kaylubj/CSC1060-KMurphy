/*
Kaylub Murphy
2/21/2025
Purpose: Write a program that calculates the sum of the first 1 natural numbers,
first using a for loop, then using a while loop,
Prints out the first 15 numbers of a "fibonacci" sequence, if the first two numbers
were the numbers they entered instead of 0 and 1,
Finally takes a number from the user and counts up from that number in a
"right triangle" pattern
 */

import java.util.Scanner;

public class Main {

    //The method for finding the sum of the first 10 numbers using a for loop
    //int x is the toTen value (1) from the main method.
    public static void sumOfForNumbers(int x) {
        //loopCounter counts the number of times the for loop has gone for
        int loopCounter;
        //Create a variable for the number that x will be added to
        int y = 2;

        /*The loop that will repeat. The loop counter starts at zero, and
        each time the loop repeats the counter increases by 1. The loop will
        run 10 times.*/
        for (loopCounter = 1; loopCounter < 10; loopCounter++) {
            //Sets the variable sum to be the sum of x and y
            int sum = (x + y);
            System.out.print(x + " + " + y + " = " + sum + "\n");
            //Sets x to the new sum
            x = sum;
            //Sets y to the next number in the 1-10 sequence (1,2,3,etc.)
            y = y + 1;
        }
    }

    //The method for finding the sum of the first 10 numbers using a while loop
    public static void sumOfWhileNumbers() {
        //x is set to 1, y is set to 2, and counter is set to 1. These are the initial
        //values these variables will enter with, and they will change within the while loop
        int x = 1;
        int y = 2;
        int counter = 1;

        while (counter >= 1 && counter < 10) {
            System.out.println((x) + " + " + y + " = " + (x + y));
            //Runs calculations to add the first 10 natural numbers:
            x = (x + y);
            y = y + 1;
            counter = counter + 1;
        }
    }

    /*
    Accepts fibonacciNum1 and fibonacciNum2 sent from the main method and sets x = the first
    and y = the second
     */
    public static void fibonacciMethod(int x, int y) {
        int counter = 1;
        //Loop repeats 14 times. It is written as 7, but each loop displays 2 numbers at a time
        while (counter <= 7) {
            System.out.print(x + " " + y + " ");
            x = x + y;
            y = x + y;
            int counterPlusOne;
            counterPlusOne = counter + 1;
            counter = counterPlusOne;
        }
        //Loop is broken after the 14th number, so this prints out number 15
        System.out.print(x);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //Sends a value of 1 to the method sumOfForNumbers
        int toTen = 1;
        System.out.println("Let's add up the first 10 numbers:");
        sumOfForNumbers(toTen);

        //Runs sumOfWhileNumbers
        System.out.println("\nLet's go again:");
        sumOfWhileNumbers();

        //Takes the input of 2 numbers and sends them to fibonacciMethod
        System.out.print("\nEnter a number: ");
        int fibonacciNum1 = input.nextInt();
        System.out.print("Enter another: ");
        int fibonacciNum2 = input.nextInt();
        fibonacciMethod(fibonacciNum1, fibonacciNum2);

        //Runs the method getUserNumber from the RightAngleLoop class
        RightAngleLoop.getUserNumber();
    }
}