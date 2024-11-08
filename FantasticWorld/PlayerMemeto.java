package FantasticWorld;

import java.util.Stack;

public class PlayerMemeto implements Memeto {
    private Stack<String> playerName = new Stack<String>();
    private Player player;

    public PlayerMemeto(Player player) {
        //this.playerName.push(player.getPlayerName());
        this.player = player;
        save();
    }

    public void restore() {
        player.setPlayerName(playerName.pop());
    }

    public void save() {
        playerName.push(player.getPlayerName());
    }
}