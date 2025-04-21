/*
Kaylub Murphy
4/19/25
CSC1060
Wayne Cooke
Purpose: Practice exceptions in programs by creating a program that solves the quadratic equation
 */
import java.util.Scanner;

public class Main {
    //This method is used to ensure that only real numbers are put in
    public static double getABC(Scanner input) {
        //While true creates an infinite loop that will only end when it gets a valid number
        while (true) {
            //It tries to return a double, which it can only do for a real number
            try {
                return input.nextDouble();
            }
            //If it can't, it'll give this exception
            catch (Exception e) {
                System.out.print("I don't understand...please try again: ");
                //Asks them to go again. This repeats until it is able to return input.nextDouble();
                input.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        //Creates a new instance of Quadratic called quad
        Quadratic quad = new Quadratic();
        //Creates the variables a b and c
        double a,b,c;
        Scanner input = new Scanner(System.in);
        //A boolean that will be used for the while loop
        boolean loop = true;

        //Some initial calculations using each of the numbers. For example, the first one calculates
        //the quadratic equation with the numbers 1 7 and 6 for a b and c
        System.out.println("Calculate Quadratics!");
        System.out.println(quad.calculateAnswers(1, 7, 6));
        System.out.println(quad.calculateAnswers(1, -5, 3));
        System.out.println(quad.calculateAnswers(5, 8, 2));

        //While "loop" is true;
        while (loop) {
            //Asks the user to type in 3 values; a, b, and c
            System.out.print("Type the values for a, b, c for 0 = a * x ^ 2 + b * x + c\na: ");
            //Sets the first input as a
            a = getABC(input);
            System.out.print("b: ");
            b = getABC(input);
            System.out.print("c: ");
            c = getABC(input);
            input.nextLine();

            //Calls the calculateAnswers method under Quadratic, plugging in a b and c
            System.out.println(quad.calculateAnswers(a, b, c));

            //Infinite loop asks if the user want to go again
            while (true) {
                System.out.print("Do you want to go again? (Y/N): ");
                //Asks for then to type y or n, and sets repeat to their answer
                String repeat = input.nextLine();

                //If they type y or Y...
                if (repeat.equalsIgnoreCase("y")) {
                    //Ends the current while(true) loop, so it skips else if and else, so
                    //it goes back to the beginning of while(loop)
                    break;
                }
                //If they type n or N...
                else if (repeat.equalsIgnoreCase("n")) {
                    //It sets loop to false
                    loop = false;
                    //Skips else. Since loop is now false, it ends the while(loop) as well, and reaches
                    //the end of the program
                    break;
                }
                //If they type in anything else it shows this method and asks them again.
                else {
                    System.out.print("I don't understand. Can you try that again?: ");
                }
            }
        }
    }
}