package com.cafe.utils.event;

import com.cafe.member.service.MemberService;
import com.cafe.utils.email.EmailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@EnableAsync
@Configuration
@Component
@Slf4j
public class MemberRegistrationEventListener {
    private final EmailSender emailSender;
    private final MemberService memberService;


    public MemberRegistrationEventListener(EmailSender emailSender, MemberService memberService) {
        this.emailSender = emailSender;
        this.memberService = memberService;
    }

    // mail sender
    @Async  // 어쩌면 메일 보내는건 비동기가 아니라 동기로 처리해야할수도...?
    @EventListener
    public void listen(MemberRegistrationApplicationEvent event) throws Exception {
        try {
            String[] to = new String[]{event.getMember().getEmail()};
            String subject = "Thank you for joining our cafe!";
            String message = event.getMember().getEmail() + "님, 회원 가입이 성공적으로 완료되었습니다.";
            String templateName = "email-registration-member";
            emailSender.sendEmail(to, subject, message, templateName);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("MailSendException: rollback for Member Registration:");
            memberService.deleteMember(event.getMember().getMemberId());
        }
    }
}