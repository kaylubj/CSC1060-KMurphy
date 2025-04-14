import java.util.ArrayList;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a fruit: ");
        String fruit = scanner.nextLine();

        // Get the letter from the user
        System.out.print("Enter a letter from the fruit: ");
        char letter = scanner.next().charAt(0);

        // Find all indices of the letter
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < fruit.length(); i++) {
            if (fruit.charAt(i) == letter) {
                indices.add(i);
            }
        }

        // Display the results
        if (!indices.isEmpty()) {
            System.out.println("The letter '" + (letter + 1) + "' is found at indices: " + indices);
        } else {
            System.out.println("The letter '" + (letter + 1) + "' is not found in the fruit.");
        }

        scanner.close();
    }
}