package FantasticWorld;


import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class ShowPlayerDetailCommand implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;

    public void execute() {
        if (((RefCurrentPlayerAdapter) currentPlayer).getCurrentPlayer() == null) {
            System.out.println("\nPlease create / select a player first.");
            return;
        }
        System.out.println();
        currentPlayer.showPlayerDetails();
    }

    public void undo() {}
    public boolean redo() {
        return true;
    }

    public ShowPlayerDetailCommand(Player currentPlayer,Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}