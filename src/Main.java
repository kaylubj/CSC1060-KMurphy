import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Keeps track of what the user inputs
        String name, location, age, activity, donate;
        Scanner input = new Scanner(System.in);

        //Asks name
        System.out.print("Hello! What's your name? ");
        name = input.nextLine();
        //Sets name variable to whatever the user inputs

        System.out.print("Nice to meet you! Where are you from? ");
        location = input.nextLine();

        System.out.print("Awesome! What's your age? ");
        age = input.nextLine();

        System.out.print("That's cool! What's your favorite activity? ");
        activity = input.nextLine();

        System.out.print("That's great! How much would you like to donate? ");
        donate = input.nextLine();

        System.out.println("Your name is " + name + ", you are from " + location +
                ", you are " + age + " years old, you enjoy " + activity +
                ",\nand would like to donate $" + donate + ".");
    }
}