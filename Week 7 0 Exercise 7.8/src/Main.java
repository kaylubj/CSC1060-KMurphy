import java.util.Scanner;

/*
Kaylub Murphy
04/03/2025
CSC1060 - Wayne Cooke
Exercise 7.8
Purpose: Create a program that takes two words and tells you whether they are anagrams
of each other.
 */

public class Main {

    //Receives both words and sets str1 and str2 to their values
    public static boolean areAnagrams(String str1, String str2) {
        //\\s+ means whitespace (spaces, tabs, etc.). This part replaces all whitespace
        //to "" (nothing) combining it all into a single "word". The .toLowerCase sets
        //it all to lowercase. This is necessary so that the program is able to decide
        //whether something is an anagram without having to worry about spaces or capitals
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();

        //This checks that the two new strings are the same length. If not, the program
        //automatically knows that they are not anagrams of each other, and just returns false
        if (str1.length() != str2.length()) {
            return false;
        }

        //This part creates arrays. The arrays are 256 characters; long enough for all
        //ASCII characters.
        int[] count1 = new int[256];
        int[] count2 = new int[256];

        //This part checks each individual letter in the words. Each time it counts a
        //character it updates the counts accordingly.
        for (int i = 0; i < str1.length(); i++) {
            count1[str1.charAt(i)]++;
            count2[str2.charAt(i)]++;
        }

        //This part compares count1 and count2. If the two are anagrams these two arrays
        //should be exactly the same. The for loop goes through all 256 spaces in each array
        //and checks that it completely matches up.
        for (int i = 0; i < 256; i++) {
            //If at any point the arrays are different, it will return false
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        //If it clears all of these checks, then it is an anagram, so it will return true
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Gets the first word from the user
        System.out.println("Enter a word:");
        String input1 = scanner.nextLine();

        //Gets the second word from the user
        System.out.println("Enter an anagram:");
        String input2 = scanner.nextLine();

        //Sends both words to the boolean areAnagrams method
        //If they are, it returns true and prints "That's an anagram!",
        //and if not it prints "That's not an anagram!"
        if (areAnagrams(input1, input2)) {
            System.out.println("That's an anagram!");
        } else {
            System.out.println("That's not an anagram!");
        }

        //The scanner is no longer in use, so this closes it. Not particularly necessary here
        //as the program ends at this point, but something good to start including
        scanner.close();
    }
}
