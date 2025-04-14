import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        // Get the greatest number
        int greatest = greatestNumber(num1, num2, num3);

        // Switch statement to print the result
        switch (greatest) {
            case 1:
                System.out.println("The greatest number is: " + num1);
                break;
            case 2:
                System.out.println("The greatest number is: " + num2);
                break;
            case 3:
                System.out.println("The greatest number is: " + num3);
                break;
            default:
                System.out.println("Unexpected error.");
        }

        scanner.close();
    }

    // Method to determine the greatest number
    public static int greatestNumber(int num1, int num2, int num3) {
        if (num1 >= num2 && num1 >= num3) {
            return 1; // Indicates num1 is the greatest
        } else if (num2 >= num1 && num2 >= num3) {
            return 2; // Indicates num2 is the greatest
        } else {
            return 3; // Indicates num3 is the greatest
        }
    }
}