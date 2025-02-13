/*
Kaylub Murphy
02/12/25
Purpose: Learn to use separate functions and have them pass info back and forth.
 */

import java.util.Scanner;

public class Main {

    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateDiameter(double radius) {
        return radius * 2;
    }

    public static double calculateCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a value for your radius in inches: ");
        double radius = input.nextDouble();
        double area = calculateArea(radius);
        double diameter = calculateDiameter(radius);
        double circumference = calculateCircumference(radius);


        System.out.println("Here's what I calculated: ");
        System.out.printf("The area is %.5f square inches.", area);
        System.out.printf("\nThe diameter is " + diameter + " inches.");
        System.out.printf("\nThe circumference is %.5f inches.", circumference);

    }
}