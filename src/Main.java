import java.util.Scanner;

public class Main {
    public static int bottlesOfBeer(int j) {
        String plural = (j == 1) ? "bottle" : "bottles";
        String plural2 = (j==2)? "bottle": "bottles";
        System.out.println(j + " " + plural + " of beer on the wall, " + j + " " + plural + " of beer!"
                + " Take one down, pass it around, " + --j + " " + plural2 + " of beer on the wall!");
        return j;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Give me a number: ");
        int beerBottles = input.nextInt();

        while (beerBottles > 0) {
            beerBottles = bottlesOfBeer(beerBottles);
        }
    }
}