package FantasticWorld;

import java.util.Vector;

public class Player {
    private String playerID;
    private String playerName;
    private Vector<Hero> heroes;

    public Player(String playerID) {
        this.playerID = playerID;
        this.heroes = new Vector<Hero>();
    }
    public String getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Vector<Hero> getHeroes() {
        return heroes;
    }

    public void addHero(Hero hero) {
        //add your own codes
    }
    
    public void removeHero(Hero hero) {
        //add your own codes
    }
    
    public void showPlayerDetails(){
        //add your own codes
    }
}
