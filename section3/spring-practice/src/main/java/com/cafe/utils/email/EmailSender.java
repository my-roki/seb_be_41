package com.cafe.utils.email;

import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailSender {
    private final JavaMailSender javaMailSender;
    private final EmailSendable emailSendable;

    public EmailSender(JavaMailSender javaMailSender, EmailSendable emailSendable) {
        this.javaMailSender = javaMailSender;
        this.emailSendable = emailSendable;
    }

    public void sendEmail(String[] to, String subject, String message, String templateName)
            throws MailSendException, InterruptedException, MessagingException {
        emailSendable.send(to, subject, message, templateName);
    }
}