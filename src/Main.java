/*
Kaylub Murphy
03/03/2025
Purpose: Create a program that compares two strings and checks if the user input can be made from the
random letters that were given
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static StringBuilder generateLetters() {
        Random randomLetters = new Random();
        StringBuilder stringOfLetters = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            char c = (char) (randomLetters.nextInt(26) + 'A');
            stringOfLetters.append(c);
        }
        return stringOfLetters;
    }

    public static boolean canSpell(String lettersGiven, String lettersEntered) {
        Map<Character, Integer> tileCount = new HashMap<>();

        for (char scrabbleTiles : lettersGiven.toCharArray()) {
            tileCount.put(scrabbleTiles, tileCount.getOrDefault(scrabbleTiles, 0) + 1);
        }

        for (char checkLettersMatch : lettersEntered.toCharArray()) {
            if (!tileCount.containsKey(checkLettersMatch) || tileCount.get(checkLettersMatch) == 0) {
                return false;
            }
            tileCount.put(checkLettersMatch, tileCount.get(checkLettersMatch) - 1);
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String scrabbleLetters = String.valueOf(generateLetters());

        System.out.println("Here are your scrabble letters: " + scrabbleLetters);
        System.out.print("Enter a word you can spell from these: ");
        String userInput = input.nextLine().toUpperCase();

        //System.out.println(canSpell(scrabbleLetters, userInput));
        int i = 0;
        while (i == 0) {
            if (canSpell(scrabbleLetters, userInput)) {
                System.out.println("You have those tiles! (Just make sure it's a real word before you play it!)");
                i++;
            } else {
                System.out.println("You can't spell that! Let's try that again: ");
                userInput = input.nextLine().toUpperCase();
            }
        }

    }
}