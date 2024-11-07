package FantasticWorld;

import java.util.Scanner;
import java.util.Stack;

public class AddHeroCommand implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private HeroFactory[] heroType;
    private Scanner scanner;
    Hero h;
    int index;
    public void execute() {
        if(currentPlayer == null) {
            System.out.println("Please create / select a player first.");
            return;
        }
        if (h == null) {
            String s;
            System.out.println("\nPlease input hero information (id, name):- ");
            s = scanner.nextLine();
            String[] heroInfo = s.split(",",2);
            System.out.println("Hero Type (1 = Warrior | 2 = Warlock ):- ");
            int intHeroType = Integer.parseInt(scanner.nextLine());
            if (intHeroType < 1 || intHeroType > heroType.length) {
                throw new IllegalArgumentException("Invalid hero type.");
            }
            h = heroType[intHeroType-1].create(heroInfo);
            index = currentPlayer.getHeroes().size();
        }
        currentPlayer.addHero(h);
        System.out.println("Hero is added.");
        commands.push(this);
    }

    public void undo() {

    }

    public String toString() {
        return "Add hero, "+h.getHeroID()+", "+h.getHeroName()+", "+h.getClass().getSimpleName();
    }

    public AddHeroCommand(Player currentPlayer, Stack<Command> commands, HeroFactory[] heroType, Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.heroType = heroType;
        this.scanner = scanner;
    }
}