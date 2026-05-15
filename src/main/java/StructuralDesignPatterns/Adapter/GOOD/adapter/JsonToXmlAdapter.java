package StructuralDesignPatterns.Adapter.GOOD.adapter;

import StructuralDesignPatterns.Adapter.GOOD.adaptee.XmlAnalyticsLibrary;
import StructuralDesignPatterns.Adapter.GOOD.targetInterface.Analytics;

/**
 * The Adapter.
 * This class implements the Target Interface (Analytics) so the main app can use it,
 * but it wraps the Adaptee (XmlAnalyticsLibrary) to do the actual work.
 */
public class JsonToXmlAdapter implements Analytics {
    
    // The adapter holds a reference to the adaptee
    private final XmlAnalyticsLibrary legacyLibrary;

    public JsonToXmlAdapter(XmlAnalyticsLibrary legacyLibrary) {
        this.legacyLibrary = legacyLibrary;
    }

    @Override
    public void processData(String jsonData) {
        System.out.println("[Adapter] Converting JSON to XML...");
        
        // Very basic mock conversion logic for demonstration
        String xmlData = jsonData
                .replace("{", "<data>")
                .replace("}", "</data>")
                .replace("\"users\":", "<users>")
                .replace(", \"sales\":", "</users><sales>")
                .replace("1500", "1500")
                .replace("45000", "45000</sales>");

        System.out.println("[Adapter] Conversion complete. Passing to legacy library...");
        
        // Pass the successfully converted data to the legacy library
        legacyLibrary.analyzeData(xmlData);
    }
}
