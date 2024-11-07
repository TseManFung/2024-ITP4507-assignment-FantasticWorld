package FantasticWorld;

import java.util.Vector;

public class RefCurrentPlayerAdapter extends Player {
    private Player currentPlayer = null;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String getPlayerID() {
        return currentPlayer.getPlayerID();
    }

    @Override
    public String getPlayerName() {
        return currentPlayer.getPlayerName();
    }

    @Override
    public void setPlayerName(String playerName) {
        currentPlayer.setPlayerName(playerName);
    }

    @Override
    public Vector<Hero> getHeroes() {
        return currentPlayer.getHeroes();
    }

    @Override
    public void addHero(Hero hero) {
        currentPlayer.addHero(hero);
    }

    @Override
    public void removeHero(Hero hero) {
        currentPlayer.removeHero(hero);
    }

    @Override
    public void showPlayerDetails() {
        System.out.println("Player " + getPlayerName() + " (" + getPlayerID() + ")");
        System.out.println("Heroes:");
        for (Hero hero : getHeroes()) {
            hero.showHeroStatus();
        }
    }

    public RefCurrentPlayerAdapter() {
        super(null);
    }
}