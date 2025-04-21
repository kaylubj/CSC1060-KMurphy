/*
Kaylub Murphy
4/21/2025
CSC1060
Wayne Cooke
Purpose: Learn inheritance by creating a program that simulates banking
 */

//Creates a public class called Account
public class Account {
    //Creates two private fields. balance stores how much money is currently in the account,
    //and interest rate stores interest. Since they're private, they have to be accessed
    //by getters and setters
    private double balance;
    private double interestRate;

    //This is the base constructor. When there are no arguments, the balance is automatically
    //set to 0
    public Account() {
        this.balance = 0.0;
    }

    //This is the constructor with parameters. It allows you to set an initial balance
    //for the account.
    public Account(double initialBalance) {
        this.balance = initialBalance;
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
            balance += amount;
        }
    }

    //This method allows you to subtract money from the account
    public void subtract(double amount) {
        //If the amount is positive and balance is greater than the amount you're trying
        //to subtract (if there's enough money in the account)...
        if (amount > 0 && amount <= balance) {
            //balance updates to it's current value - the amount
            balance -= amount;
        }
    }

    //This method adds interest
    public void addInterest() {
        //Updates balance to its current amount + the interest on that current amount
        //For example, if they have $1000 dollars, it updates their balance to:
        //1000 + (1000 * (interestRate/100))
        balance += balance * (interestRate / 100);
    }

    //This method prints the current balance on the account
    public void printBalance() {
        //Displays current balance. The %.2f formats it to two decimal places
        System.out.printf("Current Balance: $%.2f\n", balance);
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
}

//SavingsAccount and Loan are set up the same way, so I won't go over the details here
class SavingsAccount extends Account {
    public SavingsAccount() {
        super();
    }

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }
}

class Loan extends Account {
    public Loan() {
        super();
    }

    public Loan(double initialBalance) {
        super(initialBalance);
    }

    //The method to add interest:
    @Override
    public void addInterest() {
        //Increases balance on what is owed by multiplying the current amount owed by its
        //interest rate (/100 since it's a percentage), then adds that amount to the
        //balance by calling the add method.
        double interest = getBalance() * (getInterestRate() / 100);
        add(interest); // You owe more now
    }
}
