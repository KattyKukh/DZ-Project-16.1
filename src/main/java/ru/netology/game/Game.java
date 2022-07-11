package ru.netology.game;

import ru.netology.exceptions.AlreadyRegisteredException;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;

public class Game {

    //    register(Player player) - метод регистрации игрока; если игрок не зарегистрирован, то он не сможет играть в турнире.
//    Вам нужно хранить всех зарегистрированных игроков в поле класса Game в виде списка.
//    round(String playerName1, String playerName2) - метод соревнования между двумя игроками.
//    Если хотя бы один из игроков незарегистрирован, должно выкинуться исключение NotRegisteredException (сами создайте его класс).
//    Обратите внимание, что игроки передаются методу через имя - полную информацию об игроке нужно будет найти в коллекции з
//    арегистрированных игроков (см. аналог в виде findById из прошлых дз). Выигрывает тот игрок, у которого больше strength (сила);
//    если сила одинаковая, то будет ничья. Метод должен возвращать одно число - 0 в случае ничьи, 1 в случае победы первого игрока
//    и 2 в случае победы второго игрока.

    Player player = new Player();
    ArrayList<Player> players = new ArrayList<>();

    public Player findByName(String name) {
        Player foundPlayer = new Player();
        for (Player player : players) {
            if (player.getPlayerName() == name) {
                foundPlayer = player;
                return foundPlayer;
            }
        }
        return null;
    }

    public void register(Player player) {
        if (players.contains(player) == false) {
            players.add(player);
        } else {
            throw new AlreadyRegisteredException("Player " + player.getId() + " already exists!");
        }

    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(playerName1 + " is not registered!");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(playerName2 + " is not registered!");
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}

