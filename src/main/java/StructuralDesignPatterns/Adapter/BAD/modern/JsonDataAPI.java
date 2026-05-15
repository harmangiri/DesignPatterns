package StructuralDesignPatterns.Adapter.BAD.modern;

/**
 * A modern system or API that provides data in JSON format.
 */
public class JsonDataAPI {
    public String fetchLatestData() {
        return "{\"users\": 1500, \"sales\": 45000}";
    }
}
