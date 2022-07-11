package ru.netology.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.exceptions.AlreadyRegisteredException;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player("First", 10);
    Player player2 = new Player("Second", 20);
    Player player3 = new Player("Third", 30);
    Player player4 = new Player("Forth", 40);
    Player player5 = new Player("Fifth", 10);
    Player player6 = new Player("Sixth", 50);
    Player player7 = new Player("Seventh", 60);
    Player player8 = new Player("Eighth", 70);
    Player player9 = new Player("Ninth", 70);
    Player player10 = new Player("Tenth", 90);

    public void prepare() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.register(player9);
        game.register(player10);
    }

    @Test
    public void shouldRegisterPlayers() {
        prepare();
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("First", 10);
        expected.put("Second", 20);
        expected.put("Third", 30);
        expected.put("Forth", 40);
        expected.put("Fifth", 10);
        expected.put("Sixth", 50);
        expected.put("Seventh", 60);
        expected.put("Eighth", 70);
        expected.put("Ninth", 70);
        expected.put("Tenth", 90);
        HashMap<String, Integer> actual = game.players;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldIsEmptyIfNoAddElements() {
        HashMap<String, Integer> expected = new HashMap<>();
        HashMap<String, Integer> actual = game.players;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowsAlreadyRegisteredException() {
        prepare();
        assertThrows(AlreadyRegisteredException.class, () -> {
            game.register(player1);
        });
    }

    @Test
    public void shouldThrowsNotRegisteredExceptionPlayer1() {
        prepare();
        assertThrows(NotRegisteredException.class, () -> {
            game.round("a", "First");
        });
    }

    @Test
    public void shouldThrowsNotRegisteredExceptionPlayer2() {
        prepare();
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Fifth", "b");
        });
    }

    @Test
    public void shouldReturn1IfPlayer1Stronger() {
        prepare();
        Integer expected = 1;
        Integer actual = game.round("Second", "First");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn2IfPlayer2Stronger() {
        prepare();
        Integer expected = 2;
        Integer actual = game.round("Second", "Tenth");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0IfPlayersAreEqual() {
        prepare();
        Integer expected = 0;
        Integer actual = game.round("Eighth", "Ninth");
        assertEquals(expected, actual);
    }

}
