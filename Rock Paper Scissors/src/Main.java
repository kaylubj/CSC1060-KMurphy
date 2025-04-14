
import java.util.Random;
import java.util.Scanner;

/*
Kaylub Murphy
04/07/2025
CSC1060 - Wayne Cooke
Rock Paper Scissors
Purpose: Create a program to play rock paper scissors with the computer.
The program should also keep score.
 */

public class Main {
    public static void main(String[] args) {
        //Creates a scanner, random number generator, and int variables for keeping score
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int wins = 0;
        int losses = 0;
        int ties = 0;

        System.out.println("Welcome to Rock, Paper, Scissors!");

        //The while true loop allows the user to exit the loop when it reaches break;
        while (true) {
            //Asks the user for an input. The \" allows for "" within a string
            System.out.print("\nEnter \"rock\", \"paper\", or \"scissors\" (or type quit to exit): ");
            //Takes what the user types and converts it to lowercase to make it easier to check
            String userInput = input.nextLine().toLowerCase();

            //If they type quit, it gives them the "Thanks for playing!" message, then breaks.
            //The break; ends the loop, and the program continues outside the while loop
            //In this case, it just closes the scanner and ends the program
            if (userInput.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            //If they enter anything other than rock, paper, or scissors it displays this message and "continues"
            //The continue command skips everything else in the while loop and goes back to the top
            //This way it asks for the user to enter something again
            if (!userInput.equals("rock") && !userInput.equals("paper") && !userInput.equals("scissors")) {
                System.out.println("I don't understand...Please enter \"rock\", \"paper\", or \"scissors\": ");
                continue;
            }

            //The variable computerChoice is a random number from 0-2 (since it starts at 0 it doesn't contain 3)
            int computerChoice = random.nextInt(3);
            //For 0, 1, and 2, it creates an array for each of the choices. Rock is in the 0 spot of the array,
            //paper is in the 1 spot, and scissors is in the 2 spot
            String[] choices = {"rock", "paper", "scissors"};
            //The variable computerMove takes a random number from computerChoice, and picks that string.
            //For example, if computerChoice randomly generates 1, it computerMove is set to paper.
            //A new random number will be generated every time computerMove is called
            String computerMove = choices[computerChoice];

            //Tells you what the computer chose
            System.out.println("Computer chose: " + computerMove);

            //If the user chose the same thing, it tells them it's a tie.
            if (userInput.equals(computerMove)) {
                System.out.println("It's a tie!");
                //Adds 1 to the tie counter
                ties++;
            }
            //Otherwise if the user beats the computer
            //&& means both conditions were met, || means this condition OR that condition was met
            //Goes through the three possible ways the user could win, and if one is met...
            else if (
                    (userInput.equals("rock") && computerMove.equals("scissors")) ||
                            (userInput.equals("paper") && computerMove.equals("rock")) ||
                            (userInput.equals("scissors") && computerMove.equals("paper"))
            )
            //...It tells the user that they win, and adds 1 to the score count
            {
                System.out.println("You win!");
                wins++;
            }
            //Otherwise, it lets them know that they lost, and adds 1 to their loss count
            else {
                System.out.println("You lose!");
                losses++;
            }

            //Prints the current scores
            System.out.println("Score -> Wins: " + wins + ", Losses: " + losses + ", Ties: " + ties);
        }

        //Closes the scanner
        input.close();
    }
}