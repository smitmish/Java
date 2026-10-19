package smallProjects.bankingApp.model;

import java.time.LocalDateTime;

/**
 * A Record is an immutable data carrier.
 * Perfect for transactions because once money is moved,
 * the history of that event shouldn't change.
 */
public record Transaction(String type, double amount, LocalDateTime timestamp) {
    // Java automatically creates the constructor, getters, and toString()!
}

