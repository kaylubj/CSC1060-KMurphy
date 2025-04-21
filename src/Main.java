public class Main {
    public static void main(String[] args) {
        //This creates a new checking account with an initial balance of $100
        CheckingAccount checking = new CheckingAccount(100);
        //The interest rate on this checking account is 2.5 percent
        checking.setInterestRate(2.5);
        //Calls the addInterest() method under checking to add 2.5% interest to the $100
        checking.addInterest();
        //Calls the printBalance() method to print this new balance ($102.50)
        checking.printBalance();

        //Creates a savings account with an initial balance of $500
        SavingsAccount savings = new SavingsAccount(500);
        //Sets the interest rate to 5%
        savings.setInterestRate(5);
        //Adds this interest to the balance...
        savings.addInterest();
        //And prints the new amount ( $525.00)
        savings.printBalance();

        //Creates an account for a loan with an initial balance of $1000
        Loan loan = new Loan(1000);
        //The interest rate is 10%...
        loan.setInterestRate(10);
        //Interest is added to the loan
        loan.addInterest();
        //And that new balance is printed ($1100.00)
        loan.printBalance();
    }
}