package com.example.LearningJava.messageDecodingUsingAnnotations.matchers;

import com.example.LearningJava.messageDecodingUsingAnnotations.enumm.Position;

public class PositionMatcher implements Matcher<String, Position> {

    @Override
    public Position match(String p) {
        if (p.equals("01")) {
            return Position.LEFT;
        } else if (p.equals("02")) {
            return Position.RIGHT;
        }
        return Position.NO_STATUS;
    }
}
