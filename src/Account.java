/*
Kaylub Murphy
4/21/2025
CSC1060
Wayne Cooke
Purpose: Learn inheritance by creating a program that simulates banking

Purpose: Add a FileIO to the Banking File
 */

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Creates a public class called Account
//This is the backbone of the program. This class stores the balance, interest rate, account numbers and holders,
//and methods for using FileIO
public class Account {
    //Creates two private fields***. balance stores how much money is currently in the account,
    //and interest rate stores interest. Since they're private, they have to be accessed
    //by getters and setters
    protected double balance;
    private double interestRate;
    //***for this assignment, balance was changed from private to protected to allow subclasses to directly
    //access it

    //Newest added fields for this assignment: contains account number, holder, type, a seed, and (most
    //importantly for this assignment), an instance of FileIO called file, which will be used to read
    //and write transaction history
    private int accountNumber;
    private String accountHolder;
    private int accountSeed = 1000;
    private FileIO file;
    private String accountType = "";

    //This is the base constructor. When there are no arguments, the balance is automatically
    //set to 0
    public Account() {
        //Holds the name for the file associated with the account
        String fileName;

        //Default information for the account
        accountNumber = 0;
        accountHolder = "John Donut";
        interestRate = 0.03;
        this.balance = 0.0;

        //Sets fileName to the users account number, and adds .txt to the end to make it a text file.
        //accountSeed will serve as the starting point for account numbers; how this works will be explained later
        fileName = accountNumber + ".txt";
        //Creates a new FileIO named fileName
        file = new FileIO(fileName);
        //Writes a new line in the file that says the name of the account holder, the account type, and the interest
        //rate on that account. These are all separated by a semicolon
        file.appendLine(accountHolder + "; " + accountType + "; " + interestRate);
    }

    //This is the constructor with a parameter. It allows you to set an initial balance
    //for the account.
    public Account(double initialBalance) {
        String fileName;
        accountNumber = 0;
        accountHolder = "John Donut";
        interestRate = 0.03;
        this.balance = initialBalance;

        //Creates and writes the file in the same way
        fileName = accountNumber + ".txt";
        file = new FileIO(fileName);
        file.appendLine(accountHolder + ";" + accountType + ";" + interestRate);
    }


    //This is the constructor with parameters. It allows you to set an account holder, number, interest rate,
    //initial balance, and type for the account.
    public Account(String accountHolder, int accountNumber, double interestRate, double initialBalance,
                   String accountType) {
        //Creates a string for naming the file and an object that refers to that file path
        String fileName;
        File fileHandle;
        boolean repeat = true;
        this.accountHolder = "John Doe";
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
        this.balance = initialBalance;
        this.accountType = accountType;

        //A do-while loop that makes sure that each account gets its own unique file by running through numbers
        //starting from 1000 and checking if a file with that name already exists
        do {
            //Sets the file name to the current account number.txt
            fileName = this.accountNumber + ".txt";
            //Sets the file handle to the name of the current account
            fileHandle = new File(fileName);
            //If a file with that name already exists...
            if (fileHandle.exists()) {
                //It adds 1 to that account number and increments accountSeed (the starting number, 1000)
                //Then it loops and tries again
                this.accountNumber++;
                this.accountSeed = accountNumber + 1;
            } else {
                //If it doesn't, that it creates a new file with that name, and breaks the loop
                file = new FileIO(fileName);
                repeat = false;
            }
        } while (repeat);

        //Writes the account holder's name, their account type, and their interest rate to the file
        file.appendLine(accountHolder + "; " + accountType + "; " + interestRate);

    }

    //The getter for the interest rate; allows you to get the interest rate, even though
    //it's private
    public double getInterestRate() {
        return interestRate;
    }

    //Setter for the interest rate; allows you to set the interest rate, even though
    //it's private
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    //Getter for balance; works just like getInterestRate()
    public double getBalance() {
        return balance;
    }

    //This method allows you to add money to the account
    public void add(double amount) {
        //If the amount is positive...
        if (amount > 0) {
            //It updates balance to its current value + the amount added
            balance = getLastRecordedBalance();
            balance += amount;
            //Records the date
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yy"));
            //Appends the file with the date, the amount added, and the balance
            file.appendLine(date + "; add; " + amount + "; " + balance);
        }
    }

    //This method allows you to subtract money from the account
    public void subtract(double amount) {
        //If the amount is positive and balance is greater than the amount you're trying
        //to subtract (if there's enough money in the account)...
        if (amount > 0 && amount <= balance) {
            //balance updates to its current value - the amount
            balance = getLastRecordedBalance();
            balance -= amount;
            //Records the date
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yy"));
            //Appends the file with the date, the amount added, and the balance
            file.appendLine(date + "; sub" + "; " + amount + "; " + balance);
        }
    }

    //This method adds interest
    public void addInterest() {
        //Updates balance to its current amount + the interest on that current amount
        //For example, if they have $1000 dollars, it updates their balance to:
        //1000 + (1000 * (interestRate))
        balance = getLastRecordedBalance();
        double interest = balance * (interestRate / 100.0);
        balance += interest;
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yy"));
        file.appendLine(date + "; int; " + String.format("%.2f", interest) + "; " +
                String.format("%.2f", balance));
    }

    //This method prints the current balance on the account
    public void printBalance() {
        //Displays current balance. The %.2f formats it to two decimal places
        System.out.printf("Current Balance: $%.2f\n", balance);
    }

    //These didn't end up getting used, but I chose to keep them in, just in case


//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public int getAccountNumber() {
//        return ++accountNumber;
//    }
//
//    public void setAccountNumber(int accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public String getAccountHolder() {
//        return accountHolder;
//    }
//
//    public void setAccountHolder(String accountHolder) {
//        this.accountHolder = accountHolder;
//    }
//
//    public int getAccountSeed() {
//        return ++accountSeed;
//    }
//
//    public void setAccountSeed(int accountSeed) {
//        this.accountSeed = accountSeed;
//    }
//
//    public void setFile(FileIO file) {
//        this.file = file;
//    }

    //To get the next account number,
    public int getNextAccountNumber() {
        return accountSeed++;
    }

    //To get a file
    public FileIO getFile() {
        return file;
    }


    //Gets the last recorded balance from the file
    protected double getLastRecordedBalance() {
        //Checks if the file exists, and if it doesn't, it just returns the balance
        if (file == null) return balance;

        //This returns all lines from the file into a list
        var lines = file.readFile();

        //This checks if we have at least one transaction. If there's only one line (the header), there
        //haven't been any transactions yet, so it just returns the balance
        if (lines.size() < 2) return balance;

        //Gets the last line
        String lastLine = lines.get(lines.size() - 1);

        //Splits the last line of text into an array of strings, each holding part of that line
        String[] parts = lastLine.split("; ");

        try {
            //parts.length - 1 gets the last string in the array; in this case it's the balance
            //It's tries to turn it from a string into a double
            return Double.parseDouble(parts[parts.length - 1]);
        }
        //If it can't, it'll just return whatever balance it currently has
        catch (Exception e) {
            return balance;
        }
    }

    //Reads the file and prints its contents; in this case, the transaction history
    public void printTransactionHistory() {
        //If a file doesn't exist, it'll just say that no file is available
        if (file == null) {
            System.out.println("No file available.");
            return;
        }

        //Reads all of the lines in the file
        var lines = file.readFile();

        //If the file exists but is empty, it'll just say that no transactions were found
        if (lines.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        //Prints a header for the transcript of their transaction history
        System.out.println("\n--- Transaction History for Account " + accountNumber + " ---");
        //Loops through and prints each line in the file
        for (String line : lines) {
            System.out.println(line);
        }
        //Footer for the transcript
        System.out.println("--------------------------------------------\n");
    }
}

//CheckingAccount is a subclass of Account
//It inherits all the methods and fields from Account (balance, interestRate, add(), etc.)
//Basically it's a "type" of Account
class CheckingAccount extends Account {
    //A default constructor with no arguments
    public CheckingAccount() {
        //It calls super() meaning it just calls the Account class. Since there are no args,
        //It calls the default Account()
        super();
    }

    //A constructor with parameters It accepts a double for its initial balance
    public CheckingAccount(double initialBalance) {
        //This sends initialBalance to the super class (Account). Since this one has
        //a parameter, it sends it to Account(double initialBalance)
        super(initialBalance);
    }

    //Creates a constructor called CheckingAccount, with a name, number, interest rate, and initial balance
    public CheckingAccount(String accountHolder, int accountNumber, double interestRate, double initialBalance) {
        //Calls it's parent class, Account. It passes these 5 arguments to it. So basically when it's called,
        //it's really just calling Account, and adding "Checking" to the account type
        super(accountHolder, accountNumber, interestRate, initialBalance, "Checking");
    }
}

//Creates a subclass of Account called SavingsAccount
class SavingsAccount extends Account {
    public SavingsAccount() {
        //By default, it just calls account
        super();
    }

    public SavingsAccount(double initialBalance) {
        //If it's given an argument however, that argument will be set as it's initial balance
        super(initialBalance);
    }
}

//SavingsAccount and Loan are set up the same way, so I won't go over the details here...
class Loan extends Account {
    public Loan() {
        super();
    }

    public Loan(double initialBalance) {
        super();
    }

    //...until it gets to here
    //Works pretty much the same way as CheckingAccount
    public Loan(String accountHolder, int accountNumber, double interestRate, double initialBalance) {
        super(accountHolder, accountNumber, interestRate, initialBalance, "Mortgage");
    }

    //Overrides add; when it's told to add, instead of running the add and subtract methods under Account, it runs
    //this. This is because when you add to your loans you are actually increasing your debt, not your balance.
    //Similarly, when you subtract from your loan you are paying off your debt, not decreasing your balance
    @Override
    public void add(double amount) {
        balance = getLastRecordedBalance();
        balance += amount;
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yy"));
        getFile().appendLine(date + "; add; " + amount + "; " + balance);
    }

    @Override
    public void subtract(double amount) {
        balance = getLastRecordedBalance();
        balance -= amount;
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yy"));
        getFile().appendLine(date + "; sub; " + amount + "; " + balance);
    }
}

