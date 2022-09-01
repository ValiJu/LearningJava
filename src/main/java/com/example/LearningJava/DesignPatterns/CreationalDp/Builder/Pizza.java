package com.example.LearningJava.DesignPatterns.CreationalDp.Builder;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Pizza {
    private int weight;
    private Boolean mushrooms;
    private Boolean cheese;
    private Boolean tomatoes;
    private Boolean mozzarella;
    private Boolean olives;
    private Boolean salami;
    private Boolean ham;

}
