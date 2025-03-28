package FantasticWorld;

import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class DeleteHeroCommand extends RecordString implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;
    private Hero hero;
    private Player targetPlayer;

    public void execute() {
        if (((RefCurrentPlayerAdapter) currentPlayer).getCurrentPlayer() == null) {
            System.out.println("\nPlease create / select a player first.");
            return;
        }
        System.out.print("\nPlease input hero ID:- ");
        String heroID = scanner.nextLine().trim();
        System.out.println();
        for (Hero h : currentPlayer.getHeroes()) {
            if (h.getHeroID().equals(heroID)) {
                targetPlayer = ((RefCurrentPlayerAdapter) currentPlayer).getCurrentPlayer();
                targetPlayer.removeHero(h);
                hero = h;
                System.out.println(h.getHeroID() + " " + h.getHeroName() + " is deleted.");
                setRecordString("Delete hero, "+h.getHeroID());
                commands.push(this);
                return;
            }
        }
        System.out.println("Hero " + heroID + " is not found!!");
    }

    public void undo() {
        targetPlayer.addHero(hero);
    }

    public boolean redo() {
        targetPlayer.removeHero(hero);
        return true;
    }

    public DeleteHeroCommand(Player currentPlayer, Stack<Command> commands, Vector<Player> players, Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}