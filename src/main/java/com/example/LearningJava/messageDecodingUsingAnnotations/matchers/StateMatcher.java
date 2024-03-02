package com.example.LearningJava.messageDecodingUsingAnnotations.matchers;

import com.example.LearningJava.messageDecodingUsingAnnotations.enumm.SignalState;

public class StateMatcher implements Matcher<String, SignalState> {
    @Override
    public SignalState match(String s) {
        if (s.equals("01")) {
            return SignalState.ACTIVE;
        } else if (s.equals("02")) {
            return SignalState.NOT_ACTIVE;
        }
        return  SignalState.NO_STATUS;
    }
}
