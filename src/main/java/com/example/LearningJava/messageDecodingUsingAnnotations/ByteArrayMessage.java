package com.example.LearningJava.messageDecodingUsingAnnotations;

import lombok.Data;

@Data
public class ByteArrayMessage {
    private byte[] payload;
}
