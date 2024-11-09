package FantasticWorld;

import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class SetCurrentPlayerCommand extends RecordString implements Command {
    Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;
    Player lastPlayer;

    public void execute() {
        System.out.print("\nPlease input player ID:- ");
        String playerID = scanner.nextLine().trim();
        for (Player p : players) {
            if (p.getPlayerID().equals(playerID)) {
                lastPlayer = ((RefCurrentPlayerAdapter) currentPlayer).getCurrentPlayer();
                ((RefCurrentPlayerAdapter) currentPlayer).setCurrentPlayer(p);
                setRecordString("Set current player, " + p.getPlayerID() + ", " + p.getPlayerName());
                //commands.push(this);
                return;
            }
        }
        System.out.println("Player " + playerID + " is not found!!");
    }

    public void undo() {
        ((RefCurrentPlayerAdapter) currentPlayer).setCurrentPlayer(lastPlayer);
    }

    public SetCurrentPlayerCommand(Player currentPlayer, Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}