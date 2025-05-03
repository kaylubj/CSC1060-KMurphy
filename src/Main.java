/*
Kaylub Murphy
4/21/2025
CSC1060
Wayne Cooke
Purpose: Learn inheritance by creating a program that simulates banking

Purpose: Add a FileIO to the Banking File
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //*******
        Account master = new Account();
        int temp = master.getNextAccountNumber();

        CheckingAccount checks = new CheckingAccount("Me", temp, 122, 500);
        checks.add(500);
        checks.subtract(125.50);
        checks.addInterest();
        checks.printBalance();


        //Grabs the next account number
        int temp2 = checks.getNextAccountNumber();
        //This creates a new checking account with an initial balance of $100
        CheckingAccount checking = new CheckingAccount("You", temp2, 1.5, 1000);
        checking.add(300);
        //Calls the addInterest() method under checking to add 1.5% interest to the $1000
        checking.addInterest();
        //Calls the printBalance() method to print this new balance ($102.50)
        checking.printBalance();

        int temp3 = checking.getNextAccountNumber();
        //Creates an account for a loan with an initial balance of $1000
        Loan mortgage = new Loan("Someone else", temp3, 6.5, 200000);
        //Adds debt to the mortgage
        mortgage.add(10000);
        //Subtracts debt to the mortgage
        mortgage.subtract(15000);
        //Interest is added to the loan
        mortgage.addInterest();
        //And that new balance is printed ($1100.00)
        mortgage.printBalance();

        //Has each account run the printTransactionHistory() method
        checks.printTransactionHistory();
        checking.printTransactionHistory();
        mortgage.printTransactionHistory();
    }
}