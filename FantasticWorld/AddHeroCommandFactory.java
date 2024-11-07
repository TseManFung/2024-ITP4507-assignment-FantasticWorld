package FantasticWorld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class AddHeroCommandFactory implements CommandFactory {
    private Player currentPlayer;
    private Stack<Command> commands;
    private HashMap<Player, ArrayList<Hero>> playerHeroes;
    private Scanner scanner;

    public Command create() {
        return new AddHeroCommand(currentPlayer,commands, playerHeroes, scanner);
    }

    public AddHeroCommandFactory(Player currentPlayer,Stack<Command> commands, HashMap<Player, ArrayList<Hero>> playerHeroes,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.playerHeroes = playerHeroes;
        this.scanner = scanner;
    }
}
