import java.util.Scanner;

public class Main {

    public static int numberOfElevens(int[] arrayGiven, int index){

       if(index>=arrayGiven.length) return 0;

       int counter = (arrayGiven[index] == 11) ? 1 : 0;

         return counter + (numberOfElevens(arrayGiven, index + 1));
}

    public static void main(String[] args) {
        //Takes a number from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        System.out.print("Another: ");
        int number2 = input.nextInt();

        System.out.print("Another: ");
        int number3 = input.nextInt();

        int[] numbers = new int[]{number, number2, number3};

        System.out.println("Number of elevens: " + numberOfElevens(numbers, 0));
    }


}