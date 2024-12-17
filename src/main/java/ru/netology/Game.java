package ru.netology;

import lombok.Getter;
import ru.netology.dto.Player;
import ru.netology.exceptions.NotRegisteredException;
import java.util.HashMap;

@Getter
public class Game {

    private final HashMap<String, Player> players = new HashMap<>();

    public boolean register (Player player) {
        for (Player playerSource : players.values()) {
            if (playerSource.getId() == player.getId() || playerSource.getName().equals(player.getName())) {
                return false;
            }
        }
        players.put(player.getName(), player);
        return true;
    }

    public int round (String playerName1, String playerName2) {
        Player first = getByPlayerName(playerName1);
        Player second = getByPlayerName(playerName2);
        if (first == null || second == null) {
            throw new NotRegisteredException();
        }
        switch (Integer.compare(first.getStrength(), second.getStrength())) {
            case 1:
                return 1;
            case -1:
                return 2;
            default:
                return 0;
        }
    }

    public Player getByPlayerName (String playerName) {
        return players.get(playerName);
    }
}
