package operation;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend {

    public static boolean sendOTP(String receiverEmail,String otp) {
        String host = "smtp.gmail.com";
        String port = "587";
        final String userName = "amanprajapati979448@gmail.com"; // Your email ID
        final String password = "pvse uvru sqjh txzd"; // Your password

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };

        try {
            Session session = Session.getInstance(properties, auth);

            // creates a new e-mail message
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(userName));
            InternetAddress[] toAddresses = { new InternetAddress(receiverEmail) };
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject("Super market email varification ");
            msg.setSentDate(new Date());
            
            // Generate OTP
            msg.setText("Your OTP is valid for 5 min: " + otp);

            // sends the e-mail
            Transport.send(msg);
            
            return true; // Email sent successfully
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; // Failed to send email
        }
    }
    
}
