/*
Kaylub Murphy
04/07/2025
CSC1060 - Wayne Cooke
Exercise 11.3
Purpose: Write a class definition for Date. Date is an object that contains a month, day, and year
The class should have two constructors: a default date, as well as one to take parameters
 */

public class Date {
    //Instance variables for year, month, and date
    private int year;
    private int month;
    private int day;

    //This is the default constructor; it doesn't take any parameters and just
    //Uses 1/1/2000 as a default date
    public Date() {
        year = 1995;
        month = 1;
        day = 1;
    }

    //This constructor does take parameters; It uses these parameters to initialize the variables
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //This method displays the date.
    public void display() {
        System.out.println("Date: " + month + "-" + day + "-" + year );
    }

    // Main method to test the class
    public static void main(String[] args) {
        //Prints the default date
        System.out.println("The default date:");
        //Creates a new Date object called default date
        Date defaultDate = new Date();
        //Sends the default date to the display method
        defaultDate.display();


        System.out.println("My birthday:");
        //Creates a new Date object for my birthday using the constructor that takes parameters
        Date birthday = new Date(2000, 3, 1);
        //Sends the parameters laid out in the birthday Date object to the display method
        birthday.display();
    }
}