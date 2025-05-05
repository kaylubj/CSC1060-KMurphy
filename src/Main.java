/*
Kaylub Murphy
05/04/2025
CSC1060
Wayne Cooke
Purpose: Practice control structures, input, output, variables, functions, and random numbers by creating:
A game of Pig that must:
Lets you play against the computer
Asks if they want to roll or hold and calculate scores appropriately
The computer uses a strategy where they try to get at least a score of 20 each round, then hold
Switches turns until either the user or the computer gets a score off 100, at which point the game ends
After each game the user is asked if they want to play again
Who goes first is chosen at random
The program must be split into at least 3 functions
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    //Scanner and random number generator
    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);

    //Starts the game by running the playGame method
    //Uses a do while loop to run the game once at the beginning, then run the playAgain method to ask if they
    //want to play again. It'll loop if it returns as true, otherwise it'll breaks the do while, print the last line
    //and end the program
    public static void main(String[] args) {
        do {
            playGame();
        } while (playAgain());
        System.out.println("Thanks for playing!");
    }

    //Method for the game
    public static void playGame() {
        //ints that track the scores for the user and the computer
        int userTotal = 0;
        int computerTotal = 0;
        //A boolean that is randomly set to true or false
        boolean userTurn = rand.nextBoolean();

        //Welcome message
        System.out.println("Welcome to Pig!");
        //Takes the random boolean. If it's true, it will say "You" and if it's false it'll say "Computer"
        System.out.println((userTurn ? "You" : "Computer") + " will go first.");

        //While loop that tracks if either the user's or the computer's score is below 100. As soon as one of
        //their scores is above 100, the loop breaks
        while (userTotal < 100 && computerTotal < 100) {
            //If userTurn (the randomly generated boolean) is true, it'll call either playerTurn or computerTurn
            //It sends the current total for that player to the method. Whatever it gets back (the points scored
            //that round) will be added to their total
            if (userTurn) {
                userTotal += playerTurn(userTotal);
                if (userTotal >= 100) break;
            } else {
                computerTotal += computerTurn(computerTotal);
                if (computerTotal >= 100) break;
            }
            //Switches the boolean between true and false so that it alternates turns
            userTurn = !userTurn;
        }

        //Once one of the players reaches 100 points it exits the while loop and gets to here
        //If the user has more than 100 points, it'll print the first message, otherwise the computer must have
        //won, so it'll print the second
        if (userTotal >= 100)
            System.out.println("You win with " + userTotal + " points!");
        else
            System.out.println("Computer wins with " + computerTotal + " points!");
    }

    //Method that is called when it's the player's turn
    public static int playerTurn(int currentTotal) {
        //int that stores how many points they've scored THIS ROUND (not overall)
        int roundScore = 0;
        //Starts by telling the user it's their turn and lets them know how many points they currently have
        System.out.println("\nYour turn! Current total score: " + currentTotal);
        //A while loop set to break when they decide to hold
        while (true) {
            //Asks the user to press r to roll or h to hold
            System.out.print("Roll or hold? (r/h): ");
            //Takes in that input and sets it to lower case. That way it'll understand what they want to do, even
            //if the user types their answer in uppercase
            String input = scanner.nextLine().toLowerCase();
            //If they type h it lets them know they decided to hold and tells them how many points they scored
            //that round. By default this is 0, but that will change...
            if (input.equals("h")) {
                System.out.println("You hold. Round score: " + roundScore);
                break;
            }
            //...if they decide to roll.
            else if (input.equals("r")) {
                //Calls the rollDie method, which generates a random number from 1-6, and sets roll to that number
                int roll = rollDie();
                //Tells them what they rolled
                System.out.println("You rolled: " + roll);
                //In Pig if you roll a 1 then you don't earn any points that round
                if (roll == 1) {
                    //If they get a 1 it lets them know and sets roundScore to 0. then it breaks the while loop
                    System.out.println("Rolled a 1! No points this round.");
                    roundScore = 0;
                    break;
                }
                //Otherwise it'll add whatever they rolled to their roundScore. It'll let them know how many points
                //they've currently earned that round.
                else {
                    roundScore += roll;
                    System.out.println("Round score: " + roundScore);
                    //Checks if their current score plus the number of points they've earned this round is 100 or
                    //more. If so,it'll break the while loop. That way it goes straight to return roundScore. This
                    //is because there's no more reason to play; they already won, so when it returns round score
                    //the program will automatically tell them they won
                    if (currentTotal + roundScore >= 100) break;
                }
            }
            //If they don't enter an r or an h when asked, it'll tell them that they need to try again and go back
            //to the beginning of the while loop where it'll ask them again
            else {
                System.out.println("Invalid input. Enter 'r' or 'h'.");
            }
        }
        //Returns the number of points they scored that round
        return roundScore;
    }

    //Method for the computer's turn. Accepts the computer's current score as an int (currentTotal)
    public static int computerTurn(int currentTotal) {
        //Starts their score at 0
        int roundScore = 0;
        //Tells them it's the computer's turn and what their current score is
        System.out.println("\nComputer's turn! Current total score: " + currentTotal);
        //Checks both that the computer hasn't won yet (if their current score and round score are less than 100
        //and CHECKS IF THEY HAVE SCORED 20 POINTS OR MORE THAT ROUND. The while loop will not break until then,
        //so the computer will keep rolling until they have scored 20 points that round. This is the computer's
        //strategy for the game
        while (roundScore < 20 && currentTotal + roundScore < 100) {
            //Calls rollDie and sets roll to whatever it gives (a random number from 1-6)
            int roll = rollDie();
            //Tells you what they rolled
            System.out.println("Computer rolled: " + roll);
            //If they rolled a 1 it tells you that they get no points this round. It sets roundScore to 0 and
            //breaks the loop and returns that 0. That way 0 points end up added to their total score
            if (roll == 1) {
                System.out.println("Computer rolled a 1! No points this round.");
                roundScore = 0;
                break;
            }
            //If they roll anything else it adds whatever they got to the number of points they've won this round
            else {
                roundScore += roll;
            }
        }
        //Once they have a score of 20 (or more, up to 25 depending on their rolls) or they bust it comes down here
        //If they scored more than 20, it'll say that the computer holds. Otherwise, it won't (it already says that
        //they rolled a 1 and earned no points).
        if(roundScore >= 20) System.out.print("Computer holds. ");
        //Prints out the computer's round score, then returns it to the playGame method
        System.out.println("Round score: " + roundScore);
        return roundScore;
    }

    //Rolls the die by generating a random number between 1 and 6
    public static int rollDie() {
        //rand.nextInt starts at 0, so it really gives you a random number between 0 and 5, so we add 1
        return rand.nextInt(6) + 1;
    }

    //Asks if the player wants to play again
    public static boolean playAgain() {
        System.out.print("Play again? (y/n): ");
        //Sets their answer to lowercase, so if they type it in uppercase they'll still understand
        String input = scanner.nextLine().toLowerCase();
        //Returns true only if they type y
        return input.equals("y");
    }
}
