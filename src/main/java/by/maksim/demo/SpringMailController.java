package by.maksim.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringMailController {

    @Qualifier("getJavaMailSender")
    @Autowired
    public JavaMailSender emailSender;

    @RequestMapping("/sendEmail")
    public String sendSimpleEmail() {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Testing from Spring Boot");
        message.setText("Some text for testing");

        // Send Message!
        emailSender.send(message);

        return "Email Sent!";
    }
}
