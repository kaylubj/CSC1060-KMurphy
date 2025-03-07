/*
Kaylub Murphy
03/06/2025
Purpose: Create a program that counts the number of each letter and the number of numbers
that are spoken in the Gettysburg Address
 */

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //Creates string ga with the text of the Gettysburg Address
        String ga = "Delivered at the dedication of the Soldiers' National Cemetery at Gettysburg, Pennsylvania.\n" +
                "\n" +
                "Four score and seven years ago our fathers brought forth, on this continent, a new nation, conceived in Liberty, and dedicated to the proposition that all men are created equal.\n" +
                "\n" +
                "Now we are engaged in a great civil war, testing whether that nation, or any nation so conceived and so dedicated, can long endure. We are met on a great battle-field of that war. We have come to dedicate a portion of that field, as a final resting place for those who here gave their lives that that nation might live. It is altogether fitting and proper that we should do this.\n" +
                "\n" +
                "But, in a larger sense, we can not dedicated ”we can not consecrate”we can not hallow”this ground. The brave men, living and dead, who struggled here, have consecrated it, far above our poor power to add or detract. The world will little note, nor long remember what we say here, but it can never forget what they did here. It is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. It is rather for us to be here dedicated to the great task remaining before usâ€”that from these honored dead we take increased devotion to that cause for which they gave the last full measure of devotional”that we here highly resolve that these dead shall not have died in vain”that this nation, under God, shall have a new birth of freedom”and that government of the people, by the people, for the people, shall not perish from the earth.\n" +
                "\n" +
                "Abraham Lincoln\n" +
                "\n" +
                "November 19, 1863.";

        //Prints the string
        System.out.println(ga);

        //Creates a hashmap called numCount1. It calls the numCountMethod and sends
        //ga to it. Whatever is returned is what the hashmap (numCount2) is set to.
        Map<String,Integer>numCount1 = numCountMethod(ga);
        System.out.println("The times numbers have appeared: \n" + numCount1);

        //Creates a hashmap called letterCount1. It calls the letterCountMethod and sends
        //ga to it. Whatever is returned is what the hashmap (letterCount2) is set to.
        Map<Character, Integer> letterCount1 = letterCountMethod(ga);
        System.out.println("The number of times each letter has appeared: \n" + letterCount1);
    }

    //This method counts the number of times each number appears in ga. It creates a
    //Hashmap that associates the numbers in the Gettysburg address with the number of times
    //That number shows up. The ga string was sent to it when the method was called
    public static Map<String,Integer> numCountMethod(String numOfNums){
        //Creates a new hashmap called numCount2 (2 to illustrate that it is a separate hashmap
        Map<String,Integer> numCount2 = new HashMap<>();

        //Creates a pattern to match one or more digits. The \d+ makes sure that only
        //numbers are extracted from the phrase
        Pattern pattern = Pattern.compile("\\d+");

        //The matcher searches the text for numbers
        Matcher matcher = pattern.matcher(numOfNums);

        //matcher.find finds the next number in the text. While a number is found:
        while (matcher.find()){
            //The number is extracted as a string and added to a group called number
            String number = matcher.group();
            //This checks if the number is already on the map. If it is then it adds increments
            //it's associated value on the map by 1. Otherwise, it sets the initial count to 1
            numCount2.put(number, numCount2.getOrDefault(number, 0) +1);
        }
        //Returns the map created.
        return numCount2;
    }
    public static Map <Character, Integer> letterCountMethod(String numOfLetters){
        Map<Character, Integer> letterCount2 = new HashMap<>();

        for (char c : numOfLetters.toCharArray()){
            if (Character.isLetter(c)){
                c = Character.toLowerCase(c);
                letterCount2.put(c, letterCount2.getOrDefault(c,0)+1);
            }
        }
        return letterCount2;
    }
}