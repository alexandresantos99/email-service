package com.alexandre.emailservice.infra.ses;

import com.alexandre.emailservice.adapters.EmailSenderGateway;
import com.alexandre.emailservice.core.exceptions.EmailServiceException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("awsemail@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(
                        new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );

        try {
            this.amazonSimpleEmailService.sendEmail(request);
        }catch (AmazonServiceException ex){
            throw new EmailServiceException("Failure while sending email", ex);
        }
    }
}
