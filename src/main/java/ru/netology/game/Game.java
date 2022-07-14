package ru.netology.game;

import ru.netology.exceptions.AlreadyRegisteredException;
import ru.netology.exceptions.NotRegisteredException;

import java.util.HashMap;

public class Game {

    HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        if (!players.containsKey(player.getPlayerName())) {
            players.put(player.getPlayerName(), player.getStrength());
        } else {
            throw new AlreadyRegisteredException("Player " + player.getPlayerName() + " already exists!");
        }

    }

    public int round(String playerName1, String playerName2) {
        if (!players.containsKey(playerName1)) {
            throw new NotRegisteredException(playerName1 + " is not registered!");
        }
        if (!players.containsKey(playerName2)) {
            throw new NotRegisteredException(playerName2 + " is not registered!");
        }
        if (players.get(playerName1) > players.get(playerName2)) {
            return 1;
        } else if (players.get(playerName1) < players.get(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }
}

