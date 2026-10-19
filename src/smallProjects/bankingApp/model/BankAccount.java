package smallProjects.bankingApp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// --- ABSTRACTION (Abstract Class) & ENCAPSULATION (private variables used which accessible only through getters and setters) ---
public abstract class BankAccount {
    // Encapsulation: private fields hide data from direct external access
    private String accountHolder;
    // Protected so subclasses can access it
    protected double balance;
    // Step A: Create the list to hold transactions
    protected List<Transaction> transactionHistory = new ArrayList<>();

    public BankAccount(String name, double initialDeposit) {
        this.accountHolder = name;
        this.balance = initialDeposit;
        // Log the initial deposit
        addTransaction("INITIAL DEPOSIT", initialDeposit);
    }

    // Step B: Add the deposit method here
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\n"+accountHolder + " deposited: " + amount);
            addTransaction("DEPOSIT", amount);
        }
    }

    // Abstract method: Forces subclasses to implement their own withdrawal logic
    public abstract void withdraw(double amount);

    // Step C: Add the helper method to record transactions
    protected void addTransaction(String type, double amount) {
        // We create a new Record instance and add it to our list
        Transaction t = new Transaction(type, amount, LocalDateTime.now());
        transactionHistory.add(t);
    }

    // Step D: Add the missing getter that BankingApp is looking for
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public double getTotalInterestEarned() {
        return transactionHistory.stream()
                // 1. Filter: Only keep "INTEREST_CREDIT" records
                .filter(t -> "Interest Received".equals(t.type()))
                // 2. Map: Convert the Transaction record into just its 'amount' (double)
                .mapToDouble(Transaction::amount)
                // 3. Reduce: Sum all those amounts together
                .sum();
    }

    public void printTransactionsSortedByAmount() {
        System.out.println("\n--- Transactions Sorted by Amount (Highest First) ---");

        transactionHistory.stream()
                // .comparingDouble extracts the amount, .reversed() puts highest at top
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .forEach(System.out::println);
    }

    // Getter for Encapsulated data
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
}
