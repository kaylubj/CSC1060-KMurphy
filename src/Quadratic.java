/*
Kaylub Murphy
4/19/25
CSC1060
Wayne Cooke
Purpose: Practice exceptions in programs by creating a program that solves the quadratic equation
 */
public class Quadratic {
    //This part is just a default constructor. Even though it doesn't do anything, it's needed
    //to create a Quadratic object
    Quadratic(){}

    //Accepts inputs as doubles a b and c
    String calculateAnswers(double a, double b, double c){
        //answer by default is an error message
        String answer = "Illegal Input: ";
        //rad is currently 0, but will be set to b^2 - 4ac.
        double rad = 0;

        //try is used to handle exceptions; it TRIES to do something, and if it fails then it throws to catch
        try {
            //You can't divide by 0, so if a = 0 then it throws this error (/ by zero)
            if (a == 0){
                throw new IllegalAccessException("/ by zero");
            }
            //If it's not zero, then it sets radius to b^2 - 4ac
            rad = b * b - (4 * a * c);

            //If that number is negative, then the square root of it would be an imaginary number, so
            //It gives the error "Imaginary Number is Generated"
            if (rad < 0) {
                throw new IllegalAccessException("Imaginary Number is Generated");
            }
        }
        //When the error is thrown, it is caught here. e is the text within "IllegalAccessException"
        catch (IllegalAccessException e) {
            //Sets answer to what it already is ("Illegal Input: ") plus the text it was sent
            answer += e;
            //Returns the new answer
            return answer;
        }
        //If it passes these tests, then it skips catch and goes here:
        //Sets a1 and a2 as the answers. a1 is the quadratic equation for plus and a2 is for minus
        //for the "+-" in the numerator
        double a1 = (-b + Math.sqrt(rad)) / (2 * a);
        double a2 = (-b - Math.sqrt(rad)) / (2 * a);

        //Returns a1 and a2
        return "Your answers are: " + a1 + " and " + a2;
    }
}
