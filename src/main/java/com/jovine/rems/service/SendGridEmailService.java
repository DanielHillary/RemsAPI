package com.jovine.rems.service;

import com.sendgrid.*;
import org.jobrunr.jobs.annotations.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.linkbuilder.ILinkBuilder;

import java.io.IOException;
import java.util.Map;


@Service
public class SendGridEmailService {


    private TemplateEngine templateEngine;


    @Value("${sendGrid.api.key}")
    public String sendGridKey;

    @Value("${spring.mail.username}")
    private String EMAIL_SENDER;

    @Autowired
    public SendGridEmailService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        templateEngine.addLinkBuilder((ILinkBuilder) new ILinkBuilder() {

            @Override
            public String getName() {
                return null;
            }

            @Override
            public Integer getOrder() {
                return null;
            }

            @Override
            public String buildLink(IExpressionContext context, String base, Map<String, Object> parameters) {
                return null;
            }


        });
    }




    @Job(name="Send Email Via SendGrid", retries=2)
    public void sendGridEmail(String subject, String recipient, String name,  String personlizeString, String template, Context context) {


        try {

            String process = templateEngine.process(template, context);
            String message = process.replaceAll("\\[name]", name);
            message = message.replaceAll("\\[message]", personlizeString);

            Content content = new Content("text/html", message);
            sendEmail(EMAIL_SENDER, recipient, subject, content);

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private Response sendEmail(String from, String to, String subject, Content content) {
        Mail mail = new Mail(new Email(from), subject, new Email(to), content);

        Request request = new Request();

        Response response = null;


        SendGrid sendGridClient = new SendGrid(sendGridKey);
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response =  sendGridClient.api(request);
            System.out.println(response.getBody());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return response;
    }

}
