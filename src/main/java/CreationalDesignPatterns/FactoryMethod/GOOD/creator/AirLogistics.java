package CreationalDesignPatterns.FactoryMethod.GOOD.creator;

public abstract class AirLogistics extends Logistics {
    // AirLogistics acts as an intermediate base class for air-based transportation.
    // It inherits planDelivery() but delegates createTransport() to its subclasses.
}
