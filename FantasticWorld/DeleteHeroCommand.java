package FantasticWorld;


import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class DeleteHeroCommand implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;
    private Hero hero;

    public void execute() {
        System.out.print("\nPlease input hero ID:- ");
        String heroID = scanner.nextLine().trim();
        for (Hero h : currentPlayer.getHeroes()) {
            if (h.getHeroID().equals(heroID)) {
                currentPlayer.removeHero(h);
                hero = h;
                System.out.println(h.getHeroID()+" "+h.getHeroName() + " is deleted.");
                commands.push(this);
                return;
            }
        }
    }

    public void undo() {

    }

    public String toString() {
        return "DeleteHero";
    }

    public DeleteHeroCommand(Player currentPlayer,Stack<Command> commands, Vector<Player> players, Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}