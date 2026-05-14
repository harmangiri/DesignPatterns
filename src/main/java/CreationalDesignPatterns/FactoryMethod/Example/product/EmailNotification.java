package CreationalDesignPatterns.FactoryMethod.Example.product;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Concrete Product: Implements the Notification interface for sending actual Emails using SMTP.
 */
public class EmailNotification implements Notification {
    
    private final String senderEmail;
    private final String recipientEmail;

    public EmailNotification(String senderEmail, String recipientEmail) {
        this.senderEmail = senderEmail;
        this.recipientEmail = recipientEmail;
    }

    @Override
    public void send(String messageBody) {
        System.out.println("--- Attempting to send actual Email via SMTP ---");
        
        // 1. Setup mail server properties (Assuming Gmail SMTP for this example)
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtprelay.kuonitumlare.int");

        // 2. Create a mail session with an authenticator
        Session session = Session.getInstance(props, null);

        try {
            // 3. Create the message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipientEmail)
            );
            message.setSubject("Notification from System");
            message.setText(messageBody);

            // 4. Send the message
            System.out.println("Connecting to SMTP server...");
            Transport.send(message);

            System.out.println("Status: Email successfully sent to " + recipientEmail + "!\n");

        } catch (MessagingException e) {
            System.err.println("Status: Failed to send email!");
            e.printStackTrace();
        }
    }
}
