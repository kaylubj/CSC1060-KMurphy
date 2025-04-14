import java.util.Scanner;

/*
Kaylub Murphy
04/03/2025
CSC1060 - Wayne Cooke
Exercise 7.6
Purpose: Create a program that takes 6 numbers from the user. The first 5 are put into an array. The program returns
true if all the numbers in the array are prime and their product is n (the 6th number).
 */
public class Main {
    //Checks if a number is prime
    public static boolean isPrime(int num) {
        //If the number is less than or equal to 1, it will automatically return that the number is not prime
        if (num <= 1) return false;
        //Checks if the number is divisible by any number from 2-n
        //We start at 2, because being divisible by 1 tells us nothing about whether a number is prime
        //We end at the square root of the number, because any number beyond that is already accounted for.
        //For example, the square root of 49 is 7. Any number we check that's greater than 7 will have already
        //Been tested for by that point
        for (int i = 2; i <= Math.sqrt(num); i++) {
            //If there is a number that it can divide by that doesn't have a remainder (other than 1 and itself),
            //then it's not prime
            if (num % i == 0) return false;
        }
        return true;
    }

    // This checks if the array contains only prime numbers whose product is n
    public static boolean arePrimeFactors(int n, int[] array) {
        //1 is a placeholder
        int product = 1;

        //For each number in the array
        for (int num : array) {
            //Sends the number to the method isPrime. If it comes back false, then false will be sent back to main
            if (!isPrime(num)) {
                return false; // Not all numbers are prime
            }
            //If it doesn't come back as false, all the numbers in the array (num) will be multiplied together.
            //This will be the new value of product.
            product *= num;
        }
        //Checks if the value of the product is equal to n. If it is, it will return true
        //Otherwise it will return false
        return product == n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("For this program, I'll need some numbers from you!");
        //Have the user enter the value of n
        System.out.print("Enter the value of a number: ");
        int n = scanner.nextInt();

        //Have the user enter the number of factors they want to enter. This will be the size of the array.
        System.out.println("Next I need some prime numbers that multiply together to give us " + n);
        System.out.print("Enter the number of factors you want to use: ");
        int size = scanner.nextInt();

        //Creates an array called factors. The size has already been determined, but for now the slots are empty
        int[] factors = new int[size];

        //The user enters the values of the factors
        System.out.println("Enter the factors:");
        //With each number entered, the number is added to next slot in the factors array
        for (int i = 0; i < size; i++) {
            factors[i] = scanner.nextInt();
        }

        // Sends n and the array to arePrimeFactors
        if (arePrimeFactors(n, factors)) {
            System.out.println("The numbers are all prime and their product is " + n + ".");
        } else {
            System.out.println("The numbers are not all prime and/or their product does not equal " + n + ".");
        }
    }
}