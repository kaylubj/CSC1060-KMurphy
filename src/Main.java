/*
Kaylub Murphy
2/24/2025
Purpose: Create a program that checks whether a string is a palindrome
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void isPalindrome(String yesOrNo){
        StringBuilder sBuild = new StringBuilder();

        for (char c: yesOrNo.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                sBuild.append(c);
            }
        }

        String forward = sBuild.toString();
        String reversed = sBuild.reverse().toString();
        if (forward.equals(reversed)){
            System.out.println("This is a palindrome!");
        }
        else{
            System.out.println("This is not a palindrome!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String palindrome = input.nextLine().toLowerCase();
        isPalindrome(palindrome);
    }
}