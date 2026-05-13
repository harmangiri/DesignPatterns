package CreationalDesignPatterns.FactoryMethod.GOOD;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GOOD Practice (Factory Method) Execution ---");

        // Land and Sea logistics
//        Logistics roadLogistics = new RoadLogistics();
//        roadLogistics.planDelivery();
        
        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
        
        // Air logistics branch
        Logistics airplaneLogistics = new AirplaneLogistics();
        airplaneLogistics.planDelivery();

        Logistics hotAirBalloonLogistics = new HotAirBalloonLogistics();
        hotAirBalloonLogistics.planDelivery();
        
        Logistics carLogistics = new CarLogistics();
        carLogistics.planDelivery();
        
        Logistics truckLogistics = new TruckLogistics();
        truckLogistics.planDelivery();
    }
}
