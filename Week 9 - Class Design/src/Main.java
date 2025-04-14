/*
Kaylub Murphy
04/07/2025
CSC1060 - Wayne Cooke
Exercise 9.5 - Part 1
Purpose: Takes an array of numbers from the user and raises them to a given power
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Creates a number called size, given by the user
        System.out.println("Enter how many numbers you want to use: ");
        int size = input.nextInt();

        //Creates a double array the size of "size" (the number they just gave)
        double[] userArray = new double[size];
        //Asks the user to enter that many numbers
        System.out.println("Enter " + size + " numbers: ");

        //Each number they enter gets added to the array as a double
        for (int i = 0; i < size; i++) {
            userArray[i] = input.nextDouble();
        }

        //Takes the next number as the double "power"
        System.out.println("What power do you want to raise them to?: ");
        double power = input.nextDouble();

        //Sends userArray (the numbers in the array) and power (the thing they just entered)
        //to the powArray method. answer will be a double array of whatever it returns
        //What it returns will be each number in the array raised to the given power
        double[] answer = powArray(userArray, power);
        System.out.println("Here are your results: ");
        //Prints each double in the answer array
        for (double val : answer) System.out.println(val);

        //Runs exercise Part 2
        System.out.println("\nPart 2! (Histogram of Scores):");
        exercisePart2.main(null);

        //Runs Exercise 11.3
        System.out.println("\n\nExercise 11.2 (Tile Class):");
        Tile.main(null);

        //Runs Exercise 11.3
        System.out.println("\n\nExercise 11.3 (Date Class):");
        Date.main(null);
    }

    public static double[] powArray(double[] userArray, double power) {
        double[] result = new double[userArray.length];
        for (int i = 0; i < userArray.length; i++) result[i] = Math.pow(userArray[i], power);
        return result;
    }


    /*
These were part of the code I was told to start with, however they were unnecessary

    public static int search(double[] array, double target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; // not found
    }

    public static double sum(double[] array) {
        double total = 0.0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    }
*/

}