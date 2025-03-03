/*
Kaylub Murphy
2/24/2025
Purpose: Create a program that checks whether a string is a palindrome
 */

import java.util.Scanner;

public class Main {

    //Checks if the input is a palindrome. Sets the variable that was sent (palindrome)
    //to yesOrNo
    public static void isPalindrome(String yesOrNo) {

        //Creates a new StringBuilder
        StringBuilder sBuild = new StringBuilder();

        //Turns yesOrNo into a character array called c
        //Goes through this loop for every character
        for (char c : yesOrNo.toCharArray()) {
            //Checks if the character is a letter or digit
            if (Character.isLetterOrDigit(c)) {
                //If it is, it is added to sBuild
                sBuild.append(c);
            }
        }

        //sBuild.toString() turns the characters contained in sBuild into a string
        //sBuild.reverse().toString does the same, but reverses the order of the characters
        String forward = sBuild.toString();
        String reversed = sBuild.reverse().toString();

        //Checks if the two strings are equal to each other
        if (forward.equals(reversed)) {
            //If so it prints this
            System.out.println("This is a palindrome!");
        } else {
            //Otherwise it prints this
            System.out.println("This is not a palindrome!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word: ");
        //.toLowerCase() sets whatever they typed to lower case
        //This way, even if the capitalization is different, the program will still
        //detect if it's a palindrome
        String palindrome = input.nextLine().toLowerCase();

        //Runs the isPalindrome method above, and sends palindrome as the variable
        isPalindrome(palindrome);
    }
}