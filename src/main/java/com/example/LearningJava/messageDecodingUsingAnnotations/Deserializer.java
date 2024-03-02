package com.example.LearningJava.messageDecodingUsingAnnotations;

import com.example.LearningJava.messageDecodingUsingAnnotations.annotationss.Decoder;
import com.example.LearningJava.messageDecodingUsingAnnotations.annotationss.Length;
import com.example.LearningJava.messageDecodingUsingAnnotations.matchers.Matcher;
import com.example.LearningJava.messageDecodingUsingAnnotations.messages.PoweredMovableStatusMessage;
import com.example.LearningJava.messageDecodingUsingAnnotations.messages.ProtocolMessage;
import com.example.LearningJava.messageDecodingUsingAnnotations.messages.SignalStatusMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class Deserializer {
    private final List<ProtocolMessage> protocolMessages;

    @SneakyThrows
    public ProtocolMessage process(byte[] payload) {
        ProtocolMessage protocolMessage = getProtocolMessage(payload);
        if (protocolMessage instanceof PoweredMovableStatusMessage poweredMovableStatusMessage) {
            processMessage(poweredMovableStatusMessage, payload);
        }else if(protocolMessage instanceof SignalStatusMessage signalStatusMessage){
            processMessage(signalStatusMessage, payload);
        }
        return protocolMessage;

    }
    @SneakyThrows
    public void processMessage(ProtocolMessage protocolMessage, byte[] payload){
        List<Field> fields = List.of(protocolMessage.getClass().getDeclaredFields());
        for (Field field : fields) {
            if (field.getAnnotation(Decoder.class) != null) {
                Decoder annotation = field.getAnnotation(Decoder.class);
                field.setAccessible(true);
                String fieldValue = getFieldValue(payload, annotation);
                if (annotation.matcher() != Matcher.class) {
                    Matcher matcher = annotation.matcher().newInstance();
                    field.set(protocolMessage, matcher.match(fieldValue));
                }else{
                    field.set(protocolMessage, fieldValue);
                }
            }
        }
    }

    private ProtocolMessage getProtocolMessage(byte[] payload) {
        List<ProtocolMessage> compatibleClasses = new ArrayList<>();
        protocolMessages.forEach(protocolMessage -> {
            Length annotation = protocolMessage.getClass().getAnnotation(Length.class);
            if(annotation != null){
                if(annotation.length() == payload.length){
                    compatibleClasses.add(protocolMessage);
                }
            }
        });
        if(compatibleClasses.isEmpty()){
            throw new RuntimeException(format("No compatible ProtocolMessage found for data size %d", payload.length));
        }else if(compatibleClasses.size() > 1){
            throw new RuntimeException(format("Multiple ProtocolMessages found for deserializing %d", payload.length));
        }
        return compatibleClasses.get(0);
    }

    private String getFieldValue(byte[] payload, Decoder annotation) {
        int start = annotation.start();
        int end = annotation.end();
        byte[] fieldByteArray = getSubstring(payload, start, end);
        return new String(fieldByteArray);
    }

    public static byte[] getSubstring(byte[] payload, int x, int y) {
        byte[] substring = new byte[y - x + 1];
        for (int j = 0, i = x; i <= y; i++, j++) {
            substring[j] = payload[i];
        }
        return substring;
    }

}
