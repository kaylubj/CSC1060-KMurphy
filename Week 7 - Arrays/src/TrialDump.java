//Code that didn't quite work, but I'm not sure I want to get rid of yet

import java.util.Scanner;

public class TrialDump {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("I need 6 numbers from you!");
        System.out.println("First I'll need 5 prime numbers!");
        System.out.print("Enter your first number (1-100): ");
        int num1 = input.nextInt();
        System.out.print("Enter your second number (1-100): ");
        int num2 = input.nextInt();
        System.out.print("Enter your third number (1-100): ");
        int num3 = input.nextInt();
        System.out.print("Enter your fourth number (1-100): ");
        int num4 = input.nextInt();
        System.out.print("Enter your fifth number (1-100): ");
        int num5 = input.nextInt();
        System.out.println("Give me one more number, and let's see if you can guess the product of those 5!");
        System.out.print("Enter your sixth number (Any Number): ");
        int n = input.nextInt();

        boolean isPrime = arePrimeFactors(num1, num2, num3, num4, num5, n);
        if (isPrime)
        {
            System.out.println("All of the first five numbers are prime and their product is n!");
        }
        else{
            System.out.println("That doesn't work");
        }
    }

    public static boolean arePrimeFactors(int num1, int num2, int num3, int num4, int num5, int n) {
        int[] numCheck = new int[]{num1, num2, num3, num4, num5};
        StringBuilder sBuild = new StringBuilder();

        if ((num1 * num2 * num3 * num4 * num5) != n) return false;
        for (int num : numCheck) {
            if (num == 1) return false;
            if (num == 2) return false;
            else if (num % 2 == 0) {
                sBuild.append("Y");
            } else if (num == 3) return false;
            else if (num % 3 != 0) return false;
            else if (num % 3 == 0) {
                sBuild.append("Y");
            } else if (num == 5) return false;
            else if (num % 5 != 0) return false;
            else if (num % 5 == 0) {
                sBuild.append("Y");
            } else if (num == 7) return false;
            else if (num % 7 != 0) return false;
            else if (num % 7 == 0) {
                sBuild.append("Y");
            } else if (num == 11) return false;
            else if (num % 11 != 0) return false;
            else if (num % 11 == 0) {
                sBuild.append("Y");
            }
        }
        if (sBuild.equals("YYYYY")) return true;
        return false;
    }
}
