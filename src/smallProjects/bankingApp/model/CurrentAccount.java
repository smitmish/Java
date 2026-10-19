package smallProjects.bankingApp.model;

public class CurrentAccount extends BankAccount {
    private double maxNegativeBalance = 5000;

    public CurrentAccount(String name, double initialDeposit) {
        super(name, initialDeposit);
    }
    // Polymorphism: Current account allows balance to go negative up to maxNegativeBalance limit
    @Override
    public void withdraw(double amount) {
        if (balance + maxNegativeBalance >= amount) {
            balance -= amount;
            System.out.println("\nCurrent Withdrawn: " + amount + " | New Balance: " + balance);
            addTransaction("WITHDRAWAL", amount);
        } else {
            System.out.println("\nWithdrawal exceeds overdraft limit!");
            addTransaction("WITHDRAWAL FAILED", amount);
        }

    }
}
