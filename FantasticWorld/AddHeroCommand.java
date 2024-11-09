package FantasticWorld;

import java.util.Scanner;
import java.util.Stack;

public class AddHeroCommand extends RecordString implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private HeroFactory[] heroType;
    private Scanner scanner;
    Hero h;
    // int index;
    Player targetPlayer;

    public void execute() {
        if (currentPlayer == null) {
            System.out.println("Please create / select a player first.");
            return;
        }
        if (h == null) {
            targetPlayer = currentPlayer;
            String s;
            System.out.println("\nPlease input hero information (id, name):- ");
            s = scanner.nextLine();
            String[] heroInfo = s.split(",", 2);
            System.out.print("Hero Type (");
            for (int i = 0; i < heroType.length; i++) {
                System.out.print((i + 1) + " = " + heroType[i]);
                if (i < heroType.length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println("):- ");
            int intHeroType = Integer.parseInt(scanner.nextLine());
            if (intHeroType < 1 || intHeroType > heroType.length) {
                throw new IllegalArgumentException("Invalid hero type.");
            }
            h = heroType[intHeroType - 1].create(heroInfo);
            // index = currentPlayer.getHeroes().size();
        }
        targetPlayer.addHero(h);
        System.out.println("Hero is added.");
        commands.push(this);
    }

    public void undo() {
        targetPlayer.removeHero(h);
        
    }

    public String toString() {
        return "Add hero, " + h.getHeroID() + ", " + h.getHeroName() + ", " + h.getClass().getSimpleName();
    }

    public AddHeroCommand(Player currentPlayer, Stack<Command> commands, HeroFactory[] heroType, Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.heroType = heroType;
        this.scanner = scanner;
    }
}