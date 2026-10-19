/*
Banking console application demonstrating the
Object-Oriented Programming Concept.
Abstraction (Bank Account), Inheritance (CurrentAccount and SavingsAccount),
Polymorphism (calculateInterests overridden by bot child class) and
Interface method implemented by both child class.
Encapsulation (all the main private variables defined on Bank, Current and Savings
are access through getters and setters.)
 */
package smallProjects.bankingApp.app;


import smallProjects.bankingApp.model.BankAccount;
import smallProjects.bankingApp.model.CurrentAccount;
import smallProjects.bankingApp.model.SavingsAccount;
import smallProjects.bankingApp.service.CentralBank;

public class BankingApp {
    public static void main(String[] args) {
        // Objects: Creating instances of classes
        BankAccount mySavings = new SavingsAccount("Anjali Kumari", 5000);
        BankAccount myCurrent = new CurrentAccount("Nirav Kumar", 2000);

        //Balance details
        System.out.println("\nInitial Balance for " + mySavings.getAccountHolder() + ": " + mySavings.getBalance());
        System.out.println("\nInitial Balance for " + myCurrent.getAccountHolder() + ": " + myCurrent.getBalance());

        // Dynamic Polymorphism: Same method 'withdraw' behaves differently
        mySavings.withdraw(4500); // Fails (min balance rule)
        myCurrent.withdraw(6000); // Succeeds (overdraft allowed)

        // Using Interface methods
        ((CentralBank) mySavings).calculateInterest();

        System.out.println("\nFinal Balance for " + mySavings.getAccountHolder() + ": " + mySavings.getBalance());
        System.out.println("\nFinal Balance for " + myCurrent.getAccountHolder() + ": " + myCurrent.getBalance());

        System.out.println("\n--- Transaction History for " + mySavings.getAccountHolder() + " ---");
        mySavings.getTransactionHistory().forEach(System.out::println);

        System.out.println("\n--- Transaction History for " + myCurrent.getAccountHolder() + " ---");
        myCurrent.getTransactionHistory().forEach(System.out::println);

        mySavings.deposit(2300);
        System.out.println("\nFinal Balance for " + mySavings.getAccountHolder() + ": " + mySavings.getBalance());
        ((CentralBank) mySavings).calculateInterest();
        System.out.println("\nFinal Balance for " + mySavings.getAccountHolder() + ": " + mySavings.getBalance());

        double totalInterest = mySavings.getTotalInterestEarned();
        System.out.println("Total Interest Accumulation: " + totalInterest);

        mySavings.printTransactionsSortedByAmount();
    }
}
