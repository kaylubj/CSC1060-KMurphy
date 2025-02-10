/*
Kaylub Murphy
02/09/2025
Purpose: Learning input and output, and basic calculations
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String restart;

        do {
            //Does everything in here
            //More detail under "while" at the very end
            String initialScale;

            System.out.print("Enter f for Fahrenheit, c for Celsius, or k for Kelvin: ");
            initialScale = input.nextLine();
            //Sets initialScale to whatever is typed
            while(!initialScale.matches("f|c|k")) {
                //So long as what they enter for the scale is not f, c, or k

                System.out.println("I don't understand. Can you try again?");
                initialScale = input.nextLine();
                //If it's still not f, c, or k the while statement will still be true, so it'll keep going
                //Once it is one of them, it'll move on
            }

            System.out.println("Enter temperature in " + initialScale + ": ");
            String initialTempString = input.nextLine();
            //initialTempString will accept whatever they type as a STRING (not an int or double)

            double initialTemp;
            //A double variable that will be used in a moment:

            String numberEntered = "No";
            //Creates an arbitrary string that will not be shown
            //Automatically starts as "No", as in "No, that's not an integer"
            while(numberEntered == "No") {
                //While numberEntered is set to "No", this will continue to loop
                try {
                    initialTemp = Double.parseDouble(initialTempString);
                    //It will try to turn what was entered from a string to a double
                    numberEntered = ("Yes");
                    //If it succeeds, numberEntered will become "Yes"
                    //Since it's no longer no, the while loop is broken
                } catch (NumberFormatException e) {
                    //If it can't parse (turn string into double) it'll run this
                    System.out.println("Not a valid integer. Please try again: ");
                    initialTempString = input.nextLine();
                    //It has the user try again. This repeats until they enter an integer
                }
            }
            initialTemp = Double.parseDouble(initialTempString);
            //Turns initialTempString into a double called initialTemp
            //This was also done in the while loop, but since that loop is broken it's no longer true

            switch (initialScale) {
                //Switch can be used instead of if
                //If you have a lot of "if" statements, this can make things easier
                case "f" ->
                //In the "case" f is typed
                {
                    double cTemp = (initialTemp - 32) * 5 / 9;
                    double kTemp = cTemp + 273.15;
                    //These two are set differently depending on the case

                    System.out.printf(initialTemp + " degrees Fahrenheit is %.2f degrees Celsius and %.2f Kelvin", cTemp, kTemp);
                    //%.2f sets the "double"s to 2 decimal places
                    //the first %.2f has the value of cTemp, then the second has kTemp's value
                }
                case "c" ->
                //In case c is typed
                {
                    double fTemp = ((initialTemp * 9 / 5) + 32);
                    double kTemp = (initialTemp + 273.15);
                    System.out.printf(initialTemp + " degrees Celsius is %.2f degrees Fahrenheit and %.2f Kelvin", fTemp, kTemp);
                }
                case "k" ->
                //In case k is typed
                {
                    double cTemp = (initialTemp - 273.15);
                    double fTemp = ((cTemp * 9 / 5) + 32);
                    System.out.printf(initialTemp + " Kelvin is %.2f degrees Celsius and %.2f degrees Fahrenheit", cTemp, fTemp);
                }

                default ->
                    //If they typed anything else
                        System.out.println("I didn't understand the scale. Let's try again." + "Hint: Make sure you type your scale in lower case!");
            }
            System.out.print("\nType yes to go again, or no to stop: ");
            restart = input.nextLine();
            //Sets "restart" to some string
            while (!restart.equalsIgnoreCase("Yes")) {
                //If they type anything but yes this will run
                // Equals ignore case makes it so that it doesn't matter if they type in upper or lower case
                if (restart.equalsIgnoreCase("No")) {
                    //If they type no then this runs:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    //Ends the program
                } else {
                    //If it's not no
                    System.out.println("I'm sorry, could you try that again?");
                    restart = input.nextLine();
                    //Since return is still not yes, the while loop is still active
                    //So it starts this over. It'll keep starting this while loop over until
                    //They type either yes or no
                    //If they type yes it goes to the next line
                }
            }
        } while (restart.equalsIgnoreCase("Yes"));
        //Causes the program to loop back to "do"
        //It means that while it's true that restart is set to "Yes" (based on what they typed)
        //The program will continue to run "do"
    }
}