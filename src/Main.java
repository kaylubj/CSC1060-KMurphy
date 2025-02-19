import java.util.Scanner;

public class Main {
    public static void sumOfForNumbers(int x) {
        int loopCounter;
        int y = 2;
        x = 1;
        for (loopCounter = 0; loopCounter <= 9; loopCounter++) {
            int sum = (x + y);
            System.out.print(x + " + " + y + " = " + sum + "\n");
            x = sum;
            y = y + 1;
        }
    }

    public static void sumOfWhileNumbers(int x) {
        x = -1;
        int y = 2;
        int sum = x + y;
        int counter = 0;

        while (counter >= 0 && counter < 10) {
            System.out.println((sum) + " + " + y + " = " + (sum + y));
            x = sum;
            sum = (sum + y);
            y = y + 1;
            counter = counter + 1;
        }
    }

    public static void fibonacciMethod(int x, int y) {
        int counter = 0;
        while (counter <= 6) {
            System.out.print(x + " " + y + " ");
            x = x + y;
            y = x + y;
            int counterPlusOne;
            counterPlusOne = counter + 1;
            counter = counterPlusOne;
        }
        System.out.print(x);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int toTen = 1;
        System.out.println("Let's add up the first 10 numbers:");
        sumOfForNumbers(toTen);

        System.out.println("\nLet's go again:");
        sumOfWhileNumbers(toTen);

        System.out.print("\nEnter a number: ");
        int fibonacciNum1 = input.nextInt();
        System.out.print("Enter another: ");
        int fibonacciNum2 = input.nextInt();
        fibonacciMethod(fibonacciNum1, fibonacciNum2);

        RightAngleLoop.getUserNumber();
    }
}