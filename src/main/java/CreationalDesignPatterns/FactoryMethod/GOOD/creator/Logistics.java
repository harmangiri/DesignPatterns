package CreationalDesignPatterns.FactoryMethod.GOOD.creator;

import CreationalDesignPatterns.FactoryMethod.GOOD.product.Transport;

// 3. Creator Abstract Class
public abstract class Logistics {
    // The Factory Method - let subclasses decide what to instantiate
    public abstract Transport createTransport();

    // Core business logic that uses the product returned by factory method
    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}
