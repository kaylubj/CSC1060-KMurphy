/*
Kaylub Murphy
02/12/25
Purpose: Practice working with conditionals.
 */

import java.util.Scanner;

public class Main {

    public static String isPositive() {
        return "That number is positive!";
    }

    public static String isNegative() {
        return "That number is negative!";
    }

    public static String isZero() {
        return "0 is neither positive nor negative";
    }

    public static String isOdd() {
        return "That number is odd!";
    }

    public static String isEven() {
        return "That number is even!";
    }

    public static int greatestNumber(int num1, int num2, int num3) {

        if (num1 >= num2 && num1 >= num3) {
            return 1;
        } else if (num2 >= num1 && num2 >= num3) {
            return 2;
        } else {
            return 3;
        }
    }

    public static String readFloatingPoint(double floatingPointEntered) {

        String plusOrMinus = "";

        if (floatingPointEntered < 1 && floatingPointEntered >= 0) {
            plusOrMinus = "small positive";
        } else if (floatingPointEntered < 0 && floatingPointEntered > -1) {
            plusOrMinus = "slightly negative";
        } else if (floatingPointEntered < -1000000) {
            plusOrMinus = "very negative";
        } else if (floatingPointEntered > 1000000) {
            plusOrMinus = "large";
        }
        return plusOrMinus;
    }

    public static String getWeekDay(int oneToSeven) {
        return switch (oneToSeven) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "";
        };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = input.nextInt();

        String signOnNum;
        if (num > 0) {
            signOnNum = isPositive();
        } else if (num < 0) {
            signOnNum = isNegative();
        } else {
            signOnNum = isZero();
        }
        System.out.println(signOnNum);

        String evenOrOdd;
        if (num % 2 == 0) {
            evenOrOdd = isEven();
        } else {
            evenOrOdd = isOdd();
        }
        System.out.println(evenOrOdd);

        System.out.println("Now give me three more numbers! (Hit enter after each number)");

        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();


        int greatest = greatestNumber(num1, num2, num3);
        switch (greatest) {
            case 1:
                System.out.println("The greatest number is " + num1);
                break;
            case 2:
                System.out.println("The greatest number is " + num2);
                break;
            case 3:
                System.out.println("The greatest number is " + num3);
                break;
        }


        System.out.println("Next, give me a floating-point number: ");
        double floatingPointEntered = input.nextDouble();

        String floatingPointResult = readFloatingPoint(floatingPointEntered);
        System.out.println("That's a " + floatingPointResult + " number!");

        System.out.println("Finally, give me a number between 1 and 7");
        int oneToSeven = input.nextInt();
        String weekDay = getWeekDay(oneToSeven);
        System.out.println("The day of the week is " + weekDay);
    }
}