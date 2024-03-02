package com.example.LearningJava.messageDecodingUsingAnnotations.messages;

import com.example.LearningJava.messageDecodingUsingAnnotations.annotationss.Decoder;
import com.example.LearningJava.messageDecodingUsingAnnotations.annotationss.Length;
import com.example.LearningJava.messageDecodingUsingAnnotations.enumm.Position;
import com.example.LearningJava.messageDecodingUsingAnnotations.matchers.PositionMatcher;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Length(length = 14)
public class PoweredMovableStatusMessage implements ProtocolMessage{

    @Decoder(start = 0, end = 11)
    private String id;
    @Decoder(start = 12, end = 13, matcher = PositionMatcher.class)
    private Position position;

}
