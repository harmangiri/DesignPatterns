package StructuralDesignPatterns.Adapter.GOOD.adaptee;

/**
 * The Adaptee.
 * This is the incompatible legacy library that we CANNOT modify.
 * It strictly expects XML data.
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
