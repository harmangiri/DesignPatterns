package StructuralDesignPatterns.Bridge.Example.app;

import StructuralDesignPatterns.Bridge.Example.abstraction.AlertNotification;
import StructuralDesignPatterns.Bridge.Example.abstraction.DailyDigestNotification;
import StructuralDesignPatterns.Bridge.Example.abstraction.Notification;
import StructuralDesignPatterns.Bridge.Example.implementation.EmailSender;
import StructuralDesignPatterns.Bridge.Example.implementation.MessageSender;
import StructuralDesignPatterns.Bridge.Example.implementation.SlackSender;
import StructuralDesignPatterns.Bridge.Example.implementation.SmsSender;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== Notification System (Bridge Pattern) ======\n");

        // --- Use Case 1: Sending an ALERT via SMS ---
        // 1. Create the Implementation (Bridge)
        MessageSender smsSender = new SmsSender();
        // 2. Pass it to the Abstraction
        Notification smsAlert = new AlertNotification(smsSender);
        // 3. Execute
        smsAlert.notify("Server CPU usage exceeded 95%!");

        System.out.println("--------------------------------------------------");

        // --- Use Case 2: Sending a DAILY DIGEST via EMAIL ---
        MessageSender emailSender = new EmailSender();
        Notification emailDigest = new DailyDigestNotification(emailSender);
        emailDigest.notify("You have 5 new followers and 12 profile views today.");

        System.out.println("--------------------------------------------------");

        // --- Use Case 3: Sending the SAME ALERT via SLACK ---
        MessageSender slackSender = new SlackSender();
        Notification slackAlert = new AlertNotification(slackSender);
        slackAlert.notify("Database connection pool is almost empty!");

        System.out.println("\n========================================");
        System.out.println("Benefits Proved:");
        System.out.println("We dynamically mixed and matched different Notification Types (Alert, Digest)");
        System.out.println("with different Platforms (SMS, Email, Slack) at runtime.");
        System.out.println("If we used inheritance, we would have needed 'SmsAlertNotification', 'EmailDigestNotification' etc.");
        System.out.println("With the Bridge pattern, Abstraction and Implementation scale independently!");
    }
}
