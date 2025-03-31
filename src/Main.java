import com.sun.jdi.IntegerValue;

import java.util.Scanner;

/*
Kaylub Murphy
03/31/2025
Purpose: Create a program that converts a number from decimal to binary and hexadecimal
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String goAgain;
        do {
            System.out.print("Would you like to convert to binary or hexadecimal? (B/H) ");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("b")) choseBinary();
            else if (choice.equalsIgnoreCase("h")) choseHex();
            else System.out.println("I didn't get that");
            System.out.print("Would you like to go again? ");
            goAgain = input.nextLine();
        }
        while(goAgain.equalsIgnoreCase("y"));
    }

    public static void choseBinary(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int userInput = input.nextInt();
        System.out.println("Your number is binary is: " + toBinary(userInput));
    }

    public static void choseHex(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int userInput = input.nextInt();
        System.out.println("Your number is hexadecimal is: " + toHex(userInput));
    }

    public static String toBinary(int num) {
        /*
        Check if num is 0. If so, stop (base case)
        Divide num by 2
        Check if the remainder is a one or a zero and add that number to the end
        Repeat until num is 0
        */
        if (num == 0){
            return "";
        }
        else{
            return toBinary(num / 2) + (num % 2);
        }
    }

    public static String toHex(int num){
        //Check if num = 0. If so, stop, base case
        //Divide num by 16 and check remainder
        //Compare remainder to its hexadecimal value (EX: If remainder is 11, its hex value is B)
        //Add that value to the end of the string
        //Repeat until num = 0
        //Return string
        if (num == 0) {
            return "";
        }
        else{
            int remainder = num % 16;
            char hexDigit = "0123456789ABCDEF".charAt(remainder);
            return toHex((num / 16)) + hexDigit;
        }
    }
}