package com.example.LearningJava.messageDecodingUsingAnnotations.matchers;


import com.example.LearningJava.messageDecodingUsingAnnotations.enumm.Color;

public class ColorMatcher implements Matcher<String, Color> {
    @Override
    public Color match(String s) {
        if (s.equals("01")) {
            return Color.GREEN;
        } else if (s.equals("02")) {
            return Color.RED;
        } else if (s.equals("03")){
            return Color.YELLOW;
        }
        return  Color.NO_STATUS;
    }
}
