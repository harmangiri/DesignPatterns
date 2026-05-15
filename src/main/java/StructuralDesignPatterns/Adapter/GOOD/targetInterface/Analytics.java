package StructuralDesignPatterns.Adapter.GOOD.targetInterface;

/**
 * The Target Interface.
 * This is the interface that our application's core logic expects to work with.
 */
public interface Analytics {
    void processData(String jsonData);
}
