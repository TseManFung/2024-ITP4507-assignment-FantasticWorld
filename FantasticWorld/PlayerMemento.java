package FantasticWorld;

public class PlayerMemento implements Memento {
    private String playerName;
    private Player player;


    public PlayerMemento(Player player) {
        //this.playerName.push(player.getPlayerName());
        this.player = player;
        save();
    }

    public void restore() {
        player.setPlayerName(playerName);
    }

    public void save() {
        playerName=player.getPlayerName();
    }

    public Player getPlayer() {
        return player;
    }
}