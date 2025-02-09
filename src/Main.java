import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String initialScale;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter f for Fahrenheit, c for Celsius, or k for Kelvin: ");
        initialScale = input.nextLine();

        System.out.print("Enter temperature in " + initialScale + ": ");
        double initialTemp = Double.parseDouble(input.nextLine());

        if(initialScale.equals("f")) {
            double cTemp = (initialTemp - 32) * 5 / 9;
            double kTemp = cTemp + 273.15;
            System.out.printf(initialTemp + " degrees Fahrenheit is %.2f degrees Celsius and %.2f Kelvin",
                    cTemp, kTemp);
        }
        else if(initialScale.equals("c")) {
            double fTemp = ((initialTemp * 9 / 5) + 32);
            double kTemp = (initialTemp + 273.15);
            System.out.printf(initialTemp + " degrees Celsius is %.2f degrees Fahrenheit and %.2f Kelvin", fTemp, kTemp);
        }
        else if (initialScale.equals("k")){
            double cTemp = (initialTemp - 273.15);
            double fTemp = ((cTemp * 9 / 5) + 32);
            System.out.printf(initialTemp + " Kelvin is %.2f degrees Celsius and %.2f degrees Fahrenheit", cTemp, fTemp);
        }
        else {
            System.out.println("I didn't understand the scale. Reload the program and try again." +
                    "Hint: Make sure you type your scale in lower case!");
        }
    }
}