package CreationalDesignPatterns.Singleton.Example.app;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== Configuration Manager (Singleton Enum Pattern) ======\n");

        System.out.println("--- Payment Service booting up ---");
        PaymentService paymentService = new PaymentService();
        
        // This will trigger the Singleton to load the file for the very first time
        paymentService.processPayment();

        System.out.println("\n--- Email Service booting up ---");
        EmailService emailService = new EmailService();
        
        // This will NOT trigger a file load. It instantly uses the cached memory!
        emailService.sendEmail();
        
        System.out.println("\n--- Conclusion ---");
        System.out.println("The Heavy I/O operation (Loading Config File) happened ONLY ONCE.");
        System.out.println("All services in the application effortlessly shared the exact same configuration data.");
    }
}
