package com.cafe.utils.email;

public class MockEmailSendable implements EmailSendable {

    @Override
    public void send(String[] to, String subject, String message, String templateName) {
        System.out.println("## Send Test Email!!!");
    }
}