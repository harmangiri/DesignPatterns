package CreationalDesignPatterns.FactoryMethod.BAD;

public class Main {
    public static void main(String[] args) {
        LogisticsApp app = new LogisticsApp();
        System.out.println("--- BAD Practice Execution ---");
        app.planDelivery("road");
        app.planDelivery("sea");
    }
}
