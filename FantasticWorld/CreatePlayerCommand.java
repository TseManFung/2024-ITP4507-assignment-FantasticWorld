package FantasticWorld;

import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class CreatePlayerCommand implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;
    Player p;

    public void execute() {
        if (p == null) {
            p = new PlayerFactory(scanner).create();
        }
        players.add(p);
        this.currentPlayer = p;
        System.out.println("Current player is changed to " + p.getPlayerID() + ".");
        commands.push(this);
    }

    public void undo() {

    }

    public String toString() {
        return "CreatePlayer";
    }

    public CreatePlayerCommand(Player currentPlayer, Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}