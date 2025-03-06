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

        Map<String,Integer>numCount1 = numCountMethod(ga);
        System.out.println("The times numbers have appeared: \n" + numCount1);

        Map<Character, Integer> letterCount1 = letterCountMethod(ga);
        System.out.println("The number of times each letter has appeared: \n" + letterCount1);
    }

    public static Map<String,Integer> numCountMethod(String numOfNums){
        Map<String,Integer> numCount2 = new HashMap<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(numOfNums);

        while (matcher.find()){
            String number = matcher.group();
            numCount2.put(number, numCount2.getOrDefault(number, 0) +1);
        }
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