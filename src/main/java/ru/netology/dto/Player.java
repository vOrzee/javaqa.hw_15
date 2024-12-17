package ru.netology.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Player {
    private final String name;
    private final int strength;

    public Player(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }
}
