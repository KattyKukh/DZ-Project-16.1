package ru.netology.game;

import ru.netology.exceptions.AlreadyRegisteredException;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;

public class Game {

    //    register(Player player) - метод регистрации игрока; если игрок не зарегистрирован, то он не сможет играть в турнире.
//    Вам нужно хранить всех зарегистрированных игроков в поле класса Game в виде списка.
//    round(String playerName1, String playerName2) - метод соревнования между двумя игроками.
//    Если хотя бы один из игроков не зарегистрирован, должно выкинуться исключение NotRegisteredException (сами создайте его класс).
//    Обратите внимание, что игроки передаются методу через имя - полную информацию об игроке нужно будет найти в коллекции
//    зарегистрированных игроков (см. аналог в виде findById из прошлых дз). Выигрывает тот игрок, у которого больше strength (сила);
//    если сила одинаковая, то будет ничья. Метод должен возвращать одно число - 0 в случае ничьи, 1 в случае победы первого игрока
//    и 2 в случае победы второго игрока.

    private ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getPlayerName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void register(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        } else {
            throw new AlreadyRegisteredException("Player " + player.getId() + " already exists!");
        }

    }

    public int round(String playerName1, String playerName2) {
        Player foundPlayerName1 = findByName(playerName1);
        Player foundPlayerName2 = findByName(playerName2);
        if (foundPlayerName1 == null) {
            throw new NotRegisteredException(playerName1 + " is not registered!");
        }
        if (foundPlayerName2 == null) {
            throw new NotRegisteredException(playerName2 + " is not registered!");
        }
        if (foundPlayerName1.getStrength() > foundPlayerName2.getStrength()) {
            return 1;
        } else if (foundPlayerName1.getStrength() < foundPlayerName2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}

