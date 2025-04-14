/*
Kaylub Murphy
1/27/2025
Purpose: Display Time
 */
import java.time.LocalDateTime;
public class Main {

    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        //Variables for hour, minute, and second
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}