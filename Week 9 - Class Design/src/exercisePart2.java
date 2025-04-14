/*
Kaylub Murphy
04/07/2025
CSC1060 - Wayne Cooke
Exercise 9.5 - Part 2
Purpose: Takes an array of numbers from the user and raises them to a given power
 */

public class exercisePart2 {
    public static int[] histogram(int[] scores, int numCounters){
        int[] histogram = new int[numCounters];

        for (int score : scores) {
            if (score >= 0 && score < 100) {
                int index = (score * numCounters) / 100;
                histogram[index]++;
            }
        }

        return histogram;
    }

    public static void main(String[] args) {
        int[] scores = {23, 45, 67, 89, 99, 5, 32, 70, 88, 92, 100};
        int numCounters = 10;

        int[] result = histogram(scores, numCounters);
        int tens = 0;

        for (int i = 0; i < result.length; i++) {
            System.out.println("Scores from " + tens + 0 + "-" + tens + 9 + ": " + result[i]);
            tens++;
        }
    }
}
