package FantasticWorld;


import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class ChangePlayerNameCommand extends RecordString implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;
    private PlayerMemento playerMemento;

    public void execute() {
        System.out.print("\nPlease input new name of the current player:- ");
        String newPlayerName = scanner.nextLine().trim();
        playerMemento = new PlayerMemento(((RefCurrentPlayerAdapter)currentPlayer).getCurrentPlayer());
        currentPlayer.setPlayerName(newPlayerName);
        System.out.println("Player's name is updated.");
        setRecordString("Change player's name, "+ currentPlayer.getPlayerID() +", "+currentPlayer.getPlayerName());
        commands.push(this);
    }

    public void undo() {
        playerMemento.restore();
    }

    public ChangePlayerNameCommand(Player currentPlayer,Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}