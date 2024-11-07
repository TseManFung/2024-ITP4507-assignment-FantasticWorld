package FantasticWorld;


import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class DisplayAllPlayersCommand implements Command {
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;

    public void execute() {

    }

    public void undo() {

    }

    public String toString() {
        return "DisplayAllPlayers";
    }

    public DisplayAllPlayersCommand(Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}