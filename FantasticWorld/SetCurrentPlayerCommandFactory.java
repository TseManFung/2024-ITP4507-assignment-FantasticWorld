package FantasticWorld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class SetCurrentPlayerCommandFactory implements CommandFactory {
    private Player currentPlayer;
    private Stack<Command> commands;
    private HashMap<Player, ArrayList<Hero>> playerHeroes;
    private Scanner scanner;

    public Command create() {
        return new SetCurrentPlayerCommand(currentPlayer,commands, playerHeroes, scanner);
    }

    public SetCurrentPlayerCommandFactory(Player currentPlayer,Stack<Command> commands, HashMap<Player, ArrayList<Hero>> playerHeroes,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.playerHeroes = playerHeroes;
        this.scanner = scanner;
    }
}