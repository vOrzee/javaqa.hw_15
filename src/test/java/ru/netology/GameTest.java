package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.dto.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    void setUp() {
        game = new Game();

        player1 = new Player("Вася", 50);
        player2 = new Player("Петя", 100);
        player3 = new Player("Николай Сигизмундович", 50);

        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    void shouldRegisterPlayerSuccessfully() {
        Player masha = new Player("Мария", 70);
        assertTrue(game.register(masha));
        assertEquals(4, game.getPlayers().size());
    }

    @Test
    void shouldNotRegisterPlayerIdIfAlreadyExists() {
        assertFalse(game.register(player1));
        assertEquals(3, game.getPlayers().size());
    }

    @Test
    void shouldNotRegisterPlayerNameIfAlreadyExists() {
        assertFalse(game.register(new Player("Петя", 70)));
        assertEquals(3, game.getPlayers().size());
    }

    @Test
    void shouldReturnWinForFirstPlayer() {
        assertEquals(1, game.round("Петя", "Вася"));
    }

    @Test
    void shouldReturnWinForSecondPlayer() {
        assertEquals(2, game.round("Вася", "Петя"));
    }

    @Test
    void shouldReturnDrawIfPlayersAreEqual() {
        assertEquals(0, game.round("Вася", "Николай Сигизмундович"));
    }

    @Test
    void shouldThrowExceptionIfFirstPlayerNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Сергей", "Вася"));
    }

    @Test
    void shouldThrowExceptionIfSecondPlayerNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Сергей"));
    }

    @Test
    void shouldFindPlayerByName() {
        assertEquals(player1, game.getByPlayerName("Вася"));
    }

    @Test
    void shouldReturnNullIfPlayerNotFound() {
        assertNull(game.getByPlayerName("Сергей"));
    }

    @Test
    void shouldReturnListOfRegisteredPlayers() {
        HashMap<String, Player> players = game.getPlayers(); // Можно просто var для универсальности
        assertEquals(3, players.size());
        assertTrue(players.containsValue(player1)); // assertFalse(game.register(player1)); для универсальности
        assertTrue(players.containsValue(player2));
        assertTrue(players.containsValue(player3));
    }

    @Test
    void shouldReturnEmptyListIfNoPlayersRegistered() {
        Game emptyGame = new Game();
        assertTrue(emptyGame.getPlayers().isEmpty());
    }
}
