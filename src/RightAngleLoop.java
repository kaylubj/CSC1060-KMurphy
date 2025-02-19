import java.util.Scanner;

public class RightAngleLoop {
    public static void getUserNumber() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nFinally, enter one more number: ");
        int rightAngle = input.nextInt();
        int firstNumber = 0;
        String firstLine = "";
        for (firstNumber = 0; firstNumber <= 9; firstNumber++) {
            String nextLines = firstLine + " " + (rightAngle + firstNumber);
            System.out.println(nextLines);
            firstLine = nextLines;
        }
    }
}
