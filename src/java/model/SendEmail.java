/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Lenovo
 */
public class SendEmail {

    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public boolean sendEmail(User user) {
        boolean test = false;
        String toEmail = user.getEmail();
        final String fromEmail = "fucohs135@gmail.com";
        final String password = "gpdlsvhbkdbskeaq";
        try {
            Properties pr = configEmail(new Properties());

            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            Message mess = new MimeMessage(session);
            mess.setHeader("Content_Type", "text/plain; charset=UTF-8");

            mess.setFrom(new InternetAddress(fromEmail));

            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            mess.setSubject("Confirm Code");

            mess.setText("Your is code: " + user.getCode());
            Transport.send(mess);

            test = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

    public Properties configEmail(Properties pr) {
        pr.setProperty("mail.smtp.host", "smtp.gmail.com");
        pr.setProperty("mail.smtp.port", "587");
        pr.setProperty("mail.smtp.auth", "true");
        pr.setProperty("mail.smtp.starttls.enable", "true");
        pr.put("mail.smtp.socketFactory.port", "587");
        pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        return pr;

    }
}
