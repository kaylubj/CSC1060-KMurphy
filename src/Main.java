/*
Kaylub Murphy
02/09/2025
Purpose: Create a random number generator/number guessing game
 */

import java.util.Random;
//Imports a random number generator

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       Random random = new Random();
       //Makes a new random number generator named "random".
       int randomNumber = random.nextInt(100) + 1;
       //Assigns the random number it generates to randomNumber (the variable)

        System.out.println("I'm thinking of a number between 1 and 100");
        System.out.print("Guess what it is!: ");
        int guess = Integer.parseInt(input.nextLine());
        //The next input is the users guess. The scanner reads the guess as a string
        // The Integer.parseInt turns the string into an integer. This way we can do calculations

        System.out.println("You guessed " + guess + " and I was thinking of the number " + randomNumber);

        if(randomNumber>guess)
        //If the number generated is greater than the number they guessed
        {
            System.out.println("You were " + (randomNumber - guess) + " too low");
            //Shows how far off they were
        }
        else if(randomNumber<guess)
        //If their guess was lower
        {
            System.out.println("You were " + (guess - randomNumber) + " too high");
            //Shows how far off they were
        }
        else
        //This doesn't need a condition
        //This is run if their guess isn't more or less than the random number
        //In other words, if their guess is equal
        {
            System.out.println("You got it!");
        }
    }
}