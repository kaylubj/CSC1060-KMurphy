import java.util.Scanner;

public class Main {

    public static String noX(String str) {

        if (str.isEmpty()) {
            return "";
        }
        //Splits the string into the first character and the rest
        char first = str.charAt(0);
        String rest = str.substring(1);

        //Creates a string that will be created through recursion
        String recurse = noX(rest);

        //Base case first

        if (first == 'x') {
            return recurse;
        } else {
            return first + recurse;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String result = noX(input.nextLine());
        System.out.println(result);
    }
}