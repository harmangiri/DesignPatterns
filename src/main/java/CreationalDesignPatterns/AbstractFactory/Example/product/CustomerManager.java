package CreationalDesignPatterns.AbstractFactory.Example.product;

/**
 * Abstract Product A: Declares an interface for managing customers.
 */
public interface CustomerManager {
    String createCustomer(String name, String email);
}
