package com.cafe.utils.email;

import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public interface EmailSendable {
    void send(String[] to, String subject, String message, String templateName) throws InterruptedException, MessagingException;
}