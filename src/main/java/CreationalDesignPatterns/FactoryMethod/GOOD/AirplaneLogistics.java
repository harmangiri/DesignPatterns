package CreationalDesignPatterns.FactoryMethod.GOOD;

public class AirplaneLogistics extends AirLogistics {
    @Override
    public Transport createTransport() {
        return new Airplane();
    }
}
