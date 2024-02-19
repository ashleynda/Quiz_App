//package com.example.quiz.services;
//
//import com.example.quiz.dtos.requests.Recipient;
//import com.example.quiz.dtos.requests.SendMailRequest;
//import com.example.quiz.dtos.requests.Sender;
//import com.example.quiz.dtos.responses.SendMailResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Slf4j
//class MailServiceTest {
//    @Autowired
//    private MailService mailService;
//
//    @Test
//    public void sendMailTest() {
//        SendMailRequest mailRequest = buildMailRequest();
//        SendMailResponse response = mailService.sendMail(mailRequest);
//        assertNotNull(response);
//        assertEquals(201, response.getStatusCode());
//    }
//
//    private static SendMailRequest buildMailRequest() {
//        SendMailRequest mailRequest = new SendMailRequest();
//        Sender sender = new Sender("acebook", "a.ndabai@native.semicolon.africa");
//        List<Recipient> recipients = List.of(
//                new Recipient("fade", "ashleyndabai@gmail.com")
//        );
//        mailRequest.setSubject("testing 1,2,3...");
//        mailRequest.setHtmlContent("<p>You have successfully registered on the quiz platform");
//        mailRequest.setSender(sender);
//        mailRequest.setRecipients(recipients);
//        return mailRequest;
//    }
//
//}