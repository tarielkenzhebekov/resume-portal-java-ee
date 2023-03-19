package com.example.resumebuilder.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.InternetAddress;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

@ApplicationScoped
public class EmailService {
    private static final String from = "tarielkenzhebekov@gmail.com";
    private static final Properties properties = new Properties();

    static {
        properties.setProperty("mail.smtp.host", "localhost");
        properties.setProperty("mail.smtp.port", "1025");
    }

    public void send(String to, String email) {

        Session session = Session.getDefaultInstance(properties, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from, "Tariel Kenzhebekov"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject("Confirm your email");
            msg.setContent(email, "text/html" );
            Transport.send(msg);
        } catch (UnsupportedEncodingException | MessagingException e) {
            throw new IllegalStateException("couldn't send an email");
        }
    }
}
