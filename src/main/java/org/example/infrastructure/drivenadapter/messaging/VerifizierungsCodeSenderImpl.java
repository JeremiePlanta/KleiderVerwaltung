package org.example.infrastructure.drivenadapter.messaging;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.MessageSenderManager;
import io.jexxa.infrastructure.messaging.MessageSender;
import org.example.domain.VerifizierungsCodeVerschickt;
import org.example.domainservice.VerifizierungsCodeSender;

import java.util.Properties;

@DrivenAdapter
public class VerifizierungsCodeSenderImpl implements VerifizierungsCodeSender {

    private static final String TOPIC = "EMailVerifizierung";
    private final MessageSender messageSender;

    public VerifizierungsCodeSenderImpl(Properties properties){
        this.messageSender = MessageSenderManager.getMessageSender(VerifizierungsCodeSender.class, properties);
    }

    public void send(VerifizierungsCodeVerschickt verifizierungsCodeVerschickt){
        messageSender
                .send(verifizierungsCodeVerschickt)
                .toTopic(TOPIC)
                .asJson();
    }
}
