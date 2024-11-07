package FantasticWorld;


import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class DisplayAllPlayersCommandFactory implements CommandFactory {
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;

    public Command create() {
        return new DisplayAllPlayersCommand(commands, players, scanner);
    }

    public DisplayAllPlayersCommandFactory(Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}