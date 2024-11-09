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
    private Player player;

    public void execute() {
        System.out.print("\nPlease input new name of the current player:- ");
        String newPlayerName = scanner.nextLine().trim();
        player = ((RefCurrentPlayerAdapter)currentPlayer).getCurrentPlayer();
        playerMemento = new PlayerMemento(player);
        playerMemento.save();
        player.setPlayerName(newPlayerName);
        System.out.println("Player's name is updated.");
        setRecordString("Change player's name, "+ player.getPlayerID() +", "+player.getPlayerName());
        commands.push(this);
    }

    public void undo() {
        PlayerMemento newMemento =  new PlayerMemento(player);
        newMemento.save();
        playerMemento.restore();
        playerMemento = newMemento;
    }

    public void redo() {
        undo();
    }

    public ChangePlayerNameCommand(Player currentPlayer,Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}