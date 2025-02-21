import java.util.Scanner;

public class RightAngleLoop {
    public static void getUserNumber() {
        Scanner input = new Scanner(System.in);

        System.out.print("\n\nFinally, enter one more number: ");
        int rightAngle = input.nextInt();
        int n;
        //Starts the first value as an empty character, that will change in the loop
        String firstLine = "";
        //Loop repeats 10 times, starting at 0 and counting up to 9
        //n increases by 1 each time it loops
        for (n = 0; n <= 9; n++) {
            //Writes whatever firstLine is, adds a space, and follows it with the next
            //number in the series by adding the initial input value with the number
            //of times this has looped
            String nextLines = firstLine + " " + (rightAngle + n);
            System.out.println(nextLines);
            //With each new line, "firstLine" is now whatever was just printed. So each
            //time this loops it will print (whatever it printed in the last line) + " "
            //+ (rightAngle + n). This way it just keeps adding more numbers each line.
            firstLine = nextLines;
        }
    }
}
