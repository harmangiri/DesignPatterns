package StructuralDesignPatterns.Adapter.BAD.legacy;

/**
 * A legacy library that we CANNOT modify (e.g., a 3rd party JAR).
 * It strictly only accepts data in XML format.
 */
public class XmlAnalyticsLibrary {
    public void analyzeData(String xmlData) {
        if (xmlData.startsWith("<") && xmlData.endsWith(">")) {
            System.out.println("[Legacy Analytics] Successfully analyzed XML data: " + xmlData);
        } else {
            System.err.println("[Legacy Analytics] ERROR: Invalid format. Expected XML!");
        }
    }
}
