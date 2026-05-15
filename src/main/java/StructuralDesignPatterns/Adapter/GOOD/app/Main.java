package StructuralDesignPatterns.Adapter.GOOD.app;

import StructuralDesignPatterns.Adapter.GOOD.adaptee.XmlAnalyticsLibrary;
import StructuralDesignPatterns.Adapter.GOOD.adapter.JsonToXmlAdapter;
import StructuralDesignPatterns.Adapter.GOOD.targetInterface.Analytics;
import StructuralDesignPatterns.Adapter.BAD.modern.JsonDataAPI;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GOOD Practice (Adapter Pattern) ---");

        // 1. We have our modern JSON API
        JsonDataAPI jsonApi = new JsonDataAPI();
        String jsonData = jsonApi.fetchLatestData();
        System.out.println("Fetched Data: " + jsonData);

        // 2. We have our legacy library that only takes XML
        XmlAnalyticsLibrary legacyLibrary = new XmlAnalyticsLibrary();

        // 3. We create the Adapter, passing it the legacy library
        Analytics adapter = new JsonToXmlAdapter(legacyLibrary);

        // 4. The client (Main) just uses the interface it understands (JSON)
        // The adapter magically handles the conversion and calls the legacy library!
        adapter.processData(jsonData);

        System.out.println("\nBenefits:");
        System.out.println("1. We didn't touch the source code of the legacy library.");
        System.out.println("2. The Main class is totally clean and decoupled from the XML conversion logic.");
        System.out.println("3. The targetInterface are now compatible!");
    }
}
