package ru.netology.game;

public class Player {
    private String playerName;
    private int strength;

    public String getPlayerName() {
        return playerName;
    }

    public int getStrength() {
        return strength;
    }

    public Player() {
    }

    public Player(String playerName, int strength) {
        this.playerName = playerName;
        this.strength = strength;
    }
}
