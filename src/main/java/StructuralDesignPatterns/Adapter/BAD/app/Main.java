package StructuralDesignPatterns.Adapter.BAD.app;

import StructuralDesignPatterns.Adapter.BAD.legacy.XmlAnalyticsLibrary;
import StructuralDesignPatterns.Adapter.BAD.modern.JsonDataAPI;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- BAD Practice (Incompatible Interfaces) ---");

        JsonDataAPI jsonApi = new JsonDataAPI();
        XmlAnalyticsLibrary analytics = new XmlAnalyticsLibrary();

        String jsonData = jsonApi.fetchLatestData();
        System.out.println("Fetched Data: " + jsonData);

        // Boom! This will throw an error because the analytics library
        // expects XML, but we are passing JSON directly.
        analytics.analyzeData(jsonData);
        
        System.out.println("\nProblems:");
        System.out.println("1. To fix this here, we'd have to write conversion logic right inside the Main class.");
        System.out.println("2. It tightly couples the Main class to both the JSON structure and XML formatting.");
        System.out.println("3. The targetInterface are fundamentally incompatible.");
    }
}
