package com.example.LearningJava.messageDecodingUsingAnnotations;

import com.example.LearningJava.messageDecodingUsingAnnotations.messages.ProtocolMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Component
public class RunClass1 {

    private final Deserializer deserializer;

    @PostConstruct
    public void run() {
        String pointTelegram = "Point_BGS_0101";
        ByteArrayMessage pointMessage = new ByteArrayMessage();
        byte[] pointPayload = pointTelegram.getBytes(StandardCharsets.UTF_8);
        pointMessage.setPayload(pointPayload);
        String SignalTelegram = "Signal_BGS_020102";
        ByteArrayMessage signalMessage = new ByteArrayMessage();
        byte[] signalPayload = SignalTelegram.getBytes(StandardCharsets.UTF_8);
        signalMessage.setPayload(signalPayload);

        ProtocolMessage decodedMessagePoint = deserializer.process(pointMessage.getPayload());
        ProtocolMessage decodedMessageSignal = deserializer.process(signalMessage.getPayload());
        System.out.println(decodedMessagePoint);
        System.out.println(decodedMessageSignal);
    }

}
