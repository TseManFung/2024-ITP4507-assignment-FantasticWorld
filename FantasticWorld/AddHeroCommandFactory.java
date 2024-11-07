package FantasticWorld;

import java.util.Scanner;
import java.util.Stack;

public class AddHeroCommandFactory implements CommandFactory {
    private Player currentPlayer;
    private Stack<Command> commands;
    private HeroFactory[] heroType;
    private Scanner scanner;

    public Command create() {
        return new AddHeroCommand(currentPlayer,commands, heroType, scanner);
    }

    public AddHeroCommandFactory(Player currentPlayer,Stack<Command> commands, HeroFactory[] heroType,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.heroType = heroType;
        this.scanner = scanner;
    }
}
