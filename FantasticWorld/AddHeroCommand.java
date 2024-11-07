package FantasticWorld;

import java.util.Scanner;
import java.util.Stack;

public class AddHeroCommand implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private Class<?>[] heroType;
    private Scanner scanner;
    Hero h;
    int index;
    public void execute() {
        if(currentPlayer == null) {
            System.out.println("Please create / select a player first.");
            return;
        }
        if (h == null) {
            h = new HeroFactory(heroType, scanner).create();
            index = currentPlayer.getHeroes().size();
        }
        currentPlayer.addHero(h);
        commands.push(this);
    }

    public void undo() {

    }

    public String toString() {
        return "AddHero";
    }

    public AddHeroCommand(Player currentPlayer, Stack<Command> commands, Class<?>[] heroType, Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.heroType = heroType;
        this.scanner = scanner;
    }
}