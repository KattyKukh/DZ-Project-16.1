package ru.netology.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.exceptions.AlreadyRegisteredException;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;

public class GameTest {

    //    ArrayList<Player> players = new ArrayList<>();
    Game game = new Game();

    Player player1 = new Player(1, "First", 10);
    Player player2 = new Player(2, "Second", 20);
    Player player3 = new Player(3, "Third", 30);
    Player player4 = new Player(4, "Forth", 40);
    Player player5 = new Player(5, "Fifth", 10);
    Player player6 = new Player(6, "Sixth", 50);
    Player player7 = new Player(7, "Seventh", 60);
    Player player8 = new Player(8, "Eighth", 70);
    Player player9 = new Player(9, "Ninth", 70);
    Player player10 = new Player(10, "Tenth", 90);

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
        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);
        expected.add(player3);
        expected.add(player4);
        expected.add(player5);
        expected.add(player6);
        expected.add(player7);
        expected.add(player8);
        expected.add(player9);
        expected.add(player10);
        ArrayList<Player> actual = game.getPlayers();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldIsEmptyIfNoAddElements() {
        ArrayList<Player> expected = new ArrayList<>();
        ArrayList<Player> actual = game.getPlayers();
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
