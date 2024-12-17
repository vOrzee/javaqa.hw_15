package ru.netology;

import lombok.Getter;
import ru.netology.dto.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.List;

@Getter
public class Game {

    private List<Player> players;

    public boolean register (Player player) {
        for (Player playerSource : players) {
            if (playerSource.getId() == player.getId()) {
                return false;
            }
        }
        players.add(player);
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
        Player result = null;
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                result = player;
            }
        }
        return result;
    }
}
