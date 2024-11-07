package FantasticWorld;


import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class CallHeroSkillCommandFactory implements CommandFactory {
    private Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;

    public Command create() {
        return new CallHeroSkillCommand(currentPlayer,commands, players, scanner);

    }

    public CallHeroSkillCommandFactory(Player currentPlayer,Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}