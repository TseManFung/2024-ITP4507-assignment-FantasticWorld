package FantasticWorld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class DeleteHeroCommand implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private HashMap<Player, ArrayList<Hero>> playerHeroes;
    private Scanner scanner;

    public void execute() {

    }

    public void undo() {

    }

    public String toString() {
        return "DeleteHero";
    }

    public DeleteHeroCommand(Player currentPlayer,Stack<Command> commands, HashMap<Player, ArrayList<Hero>> playerHeroes, Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.playerHeroes = playerHeroes;
        this.scanner = scanner;
    }
}