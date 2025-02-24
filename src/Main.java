/*
Kaylub Murphy
02/22/2025
Purpose: Write a program that sings "Bottles of Beer". The program should take a number from
the user and count down from that number. The program should also use proper grammar and say
"1 bottle", not "1 bottles"
 */
import java.util.Scanner;

public class Main {
    //Method that sings the song
    public static int bottlesOfBeer(int j) {
        /* plural asks whether the number of bottles (j) is 1. If so, it would use the word
        "bottle". Otherwise, it would say "bottles". Plural 2 does the same, but because of
        its location in the song, it needs to be set to change to "bottle" when j = 2 for
        it to work */
        String plural = (j == 1) ? "bottle" : "bottles";
        String plural2 = (j == 2) ? "bottle" : "bottles";
        System.out.println(j + " " + plural + " of beer on the wall, " + j + " " + plural + " of beer!"
                + " Take one down, pass it around, " + --j + " " + plural2 + " of beer on the wall!");
        //Sets beerBottles to the new number for j. (--j sets j to one less than it was).
        return j;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Give me a number: ");
        //beerBottles is set to whatever the user puts in. That number is also saved as
        //beerBottlesStart
        int beerBottles = input.nextInt();
        int beerBottlesStart = beerBottles;

        //Sends beerBottles to the bottlesOfBeer method, (in that method it calls it j)
        while (beerBottles > 0) {
            //Since j is returned at the end of each run of the bottlesOfBeer method,
            //beerBottles is set to the new j value at the end of each run. Once it reaches
            //0, the while loop is broken
            beerBottles = bottlesOfBeer(beerBottles);
        }

        /* Once the while loop is broken this runs. beerBottlesStart was not affected
        by the while loop, so it's still set to the user's input. isPlural works like
        plural and plural 2, and sets the grammar for the last verse */
        String isPlural = (beerBottlesStart == 1) ? "bottle" : "bottles";
        System.out.println("Go to the store and buy some more, " + beerBottlesStart
                + " " + isPlural + " of beer on the wall!");
    }
}