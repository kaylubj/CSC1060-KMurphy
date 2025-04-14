/*
Kaylub Murphy
01/27/2025
Purpose: Learn concatenation/string manipulation
 */
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        //Variables for time and temperature:
        LocalDateTime currentTime = LocalDateTime.now();
        String day, month;
        int date, year;
        int c = 12, f = 89;
        day = "Monday";
        date = 27;
        month = "January";
        year = 2025;
        //Note: String for month and day is used for words, int for date and year is for integers

        //Print initial values
        System.out.print(day + " " + date + " " + month + " " + year);

        //Now for temperature conversion
        System.out.print("\n" + c + " " + "Celsius is " +
                (c * 9 / 5 + 32) + " Fahrenheit");

        System.out.println("\n" + f + " Fahrenheit is "
                + ((f - 32) * 5 / 9) + " Celsius");

        //Time of day
        System.out.println("Now for the time conversions");
        System.out.println("Hour " + currentTime.getHour());
        System.out.println("Minute " + currentTime.getMinute());
        System.out.println("Second " + currentTime.getSecond());

        //Seconds since midnight
        System.out.println("Seconds since midnight " + ((currentTime.getHour() * 3600) + (currentTime.getMinute() * 60) + currentTime.getSecond()));
        //3600 seconds in an hour + 60 seconds in a minute + seconds

        //% of the day that has passed
        System.out.println("% of day that has passed: " + (100 * (currentTime.getHour() * 60 + currentTime.getMinute()) / 1440) + "%");
        //100 (for turning decimal into percent) * minutes since midnight (minutes that have passed in the day) / 1440 (minutes in a day total)

        //Seconds Elapsed (Line 47-End)
        long startTime = System.currentTimeMillis();
        //"long" is a variable that stores a long string of whole numbers
        //This line sets the variable "startTime" to whatever time of day it is when the program is started in milliseconds

        while (true) {
            //****While these things are true...****
            long timeNow = System.currentTimeMillis();
            //Current time in milliseconds
            long elapsedSeconds = (timeNow - startTime) / 1000;
            //Current time in milliseconds - time in milliseconds since the program started = time elapsed in milliseconds
            //Milliseconds / 1000 = seconds

            System.out.print("\rElapsed seconds: " + elapsedSeconds);
            //Displays seconds elapsed since the program started

            try {
                //****...the program try to will do this:****
                Thread.sleep(1000);
                // Wait for 1 second, then start while/try loop over. ***This changes the value of timeNow, but not startTime***
            }
            // If there is an error when it tries (cannot execute Thread.sleep in this case), it will be sent here:
            catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
                break;
                //Displays error
            }
        }
    }
}