package FirstJavaProject;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMailUtil {

    public static void main(String[] args) throws IOException {

        final String username = "jaffarsherif123@gmail.com";
        final String password = "neuesahrvjzuslnh";
        final String to="jaffarsherif008@gmail.com";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jaffarsherif123@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            String msg="This message is from Bank";
            message.setSubject("Testing mail from java eclipse");
            message.setText(msg);
            
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
     	    mimeBodyPart.setContent(msg, "text/html");
     	     
     	    Multipart multipart = new MimeMultipart();
     	    multipart.addBodyPart(mimeBodyPart);
     	    
     	    MimeBodyPart attachmentBodyPart = new MimeBodyPart();
     	    attachmentBodyPart.attachFile(new File("D:\\temp\\ministatemnet.pdf"));//File directory
     	    multipart.addBodyPart(attachmentBodyPart);
     	    message.setContent(multipart);
            
            Transport.send(message);

           System.out.println("Mail sent succesfully");

       } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}