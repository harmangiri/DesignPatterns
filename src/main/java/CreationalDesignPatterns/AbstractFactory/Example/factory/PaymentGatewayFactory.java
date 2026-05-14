package CreationalDesignPatterns.AbstractFactory.Example.factory;

import CreationalDesignPatterns.AbstractFactory.Example.product.CustomerManager;
import CreationalDesignPatterns.AbstractFactory.Example.product.TransactionProcessor;

/**
 * Abstract Factory: Declares a set of methods for creating abstract products.
 * These products represent a family of related objects.
 */
public interface PaymentGatewayFactory {
    CustomerManager createCustomerManager();
    TransactionProcessor createTransactionProcessor();
}
