package ru.netology.game;

import java.util.Objects;

public class Player {
    private int id;
    private String playerName;
    private int strength;

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getStrength() {
        return strength;
    }

    public Player(int id, String playerName, int strength) {
        this.id = id;
        this.playerName = playerName;
        this.strength = strength;
    }
}
