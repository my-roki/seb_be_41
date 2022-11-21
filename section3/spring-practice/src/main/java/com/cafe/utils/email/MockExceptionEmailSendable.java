package com.cafe.utils.email;

import com.cafe.utils.email.EmailSendable;
import org.springframework.mail.MailSendException;

public class MockExceptionEmailSendable implements EmailSendable {
    @Override
    public void send(String[] to, String subject, String message, String templateName) throws InterruptedException {
        Thread.sleep(3000L);
        throw new MailSendException("### error while sending Mock email");
    }
}
