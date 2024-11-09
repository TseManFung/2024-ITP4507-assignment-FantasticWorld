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
        System.out.println("\n");
        currentPlayer.showPlayerDetails();
    }

    public void undo() {}
    public void redo() {}

    public ShowPlayerDetailCommand(Player currentPlayer,Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}