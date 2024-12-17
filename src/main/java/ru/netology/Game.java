package ru.netology;

import lombok.Getter;
import ru.netology.dto.Player;

import java.util.List;

@Getter
public class Game {

    private List<Player> players;

    public boolean register (Player player) {
        return false;
    }

    public int round (String playerName1, String playerName2) {
        return 0;
    }

    public Player getByPlayerName (String playerName) {
        return null;
    }
}
