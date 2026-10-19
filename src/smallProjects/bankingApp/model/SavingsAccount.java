package smallProjects.bankingApp.model;


import smallProjects.bankingApp.service.CentralBank;

// --- INHERITANCE & POLYMORPHISM ---
public class SavingsAccount extends BankAccount implements CentralBank {
    //SavingAccount class own variable
    private double interestRate = 0.04; // 4% interest

    //As constructor defined in Parent class we need to defined in child class to initialize variables.
    public SavingsAccount(String name, double initialDeposit) {
        super(name, initialDeposit);
    }

    // Polymorphism: Specialized implementation of withdraw
    //Method overriding so same method signature but method present in different class.
    @Override
    public void withdraw(double amount) {
        // Minimum balance should be 1000, rule for Savings
        if(balance-amount>=1000){
            balance -= amount;
            System.out.println("\nSavings Withdrawn: " + amount + " | New Balance: " + balance);
            addTransaction("WITHDRAWAL", amount);
        } else {
            System.out.println("\nInsufficient funds. Minimum balance of 1000 required.");
            addTransaction("WITHDRAWAL FAILED", amount);
        }
    }
    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("\nInterest added to Savings: " + interest);
        addTransaction("Interest Received", interest);
    }
}
