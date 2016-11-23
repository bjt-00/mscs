/*package edu.mum.ea.crs.etl;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
@ConditionalOnClass(JavaMailSender.class)
public class EmailTransmitter {


    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MessageConfig messageConfig;

    @Subscribe
    public void sendEmail(EmailMessageEvent eme) {
        log.info("{}", eme);

        SimpleMailMessage msg = new SimpleMailMessage(messageConfig.getMessageTemplate());
        msg.setSubject(eme.getSubject());
        msg.setText(eme.getMessage());

        try {
            mailSender.send(msg);
        } catch (MailException ex) {
            log.error("Error sending mail message: " + eme.toString(), ex);
        }
    }

    @PostConstruct
    public void start() throws MessagingException {
        mmEventBus.register(this);
    }

}*/