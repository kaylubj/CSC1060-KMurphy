/*
Kaylub Murphy
04/07/2025
CSC1060 - Wayne Cooke
Exercise 11.2
Purpose: Write a class that represents Scrabble tiles. The purpose is to practice the mechanical
part of creating classes. The exercise has me write a class with a constructor that takes parameters
for the letter and value of Scrabble tiles and display them. Then I am to make a Z tile worth 10 pts.
I also need to create getters and setters for each attribute.
*/

public class Tile {
    //Instance variables for the letter and value
    private char letter;
    private int value;

    //A constructor that takes a letter and a value as a parameter and initializes the variables
    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    //Takes a Tile object as a parameter and prints it
    public static void printTile(Tile tile) {
        System.out.println("Letter: " + tile.letter + ", Value: " + tile.value);
    }

    //A method that displays the string value of the object
    public String toString() {
        return "Tile{letter=" + letter + ", value=" + value + "}";
    }

    //Compares the two tiles to check that their letters and their values match
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tile)) return false;

        Tile other = (Tile) obj;
        return this.letter == other.letter && this.value == other.value;
    }

    //This lets other code see the letter. This code did not end up needing to be used,
    //But the exercise wanted me to make it
    public char getLetter() {
        return letter;
    }

    //Neither of the setters were used either, but they could be useful later for changing
    //The letter or the value
    public void setLetter(char letter) {
        this.letter = letter;
    }

    //This lets other code see the value of the tile. This code also was not used.
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        //Creates a new tile called zTile with the letter Z and value of 10.
        Tile zTile = new Tile('Z', 10);
        //Runs the printTile method for zTile
        printTile(zTile);

        // Optional: test toString and equals
        System.out.println(zTile.toString());

        Tile anotherZ = new Tile('Z', 10);
        System.out.println("Tiles are equal? " + zTile.equals(anotherZ));
    }
}
