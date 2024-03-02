package com.example.LearningJava.messageDecodingUsingAnnotations.messages;

import com.example.LearningJava.messageDecodingUsingAnnotations.annotationss.Decoder;
import com.example.LearningJava.messageDecodingUsingAnnotations.annotationss.Length;
import com.example.LearningJava.messageDecodingUsingAnnotations.enumm.Color;
import com.example.LearningJava.messageDecodingUsingAnnotations.enumm.SignalState;
import com.example.LearningJava.messageDecodingUsingAnnotations.matchers.ColorMatcher;
import com.example.LearningJava.messageDecodingUsingAnnotations.matchers.StateMatcher;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Length(length = 17)
public class SignalStatusMessage implements ProtocolMessage{

    @Decoder(start = 0, end = 12)
    private String id;
    @Decoder(start = 13, end = 14, matcher = ColorMatcher.class)
    private Color color;
    @Decoder(start = 15, end = 16, matcher = StateMatcher.class)
    private SignalState state;
}
