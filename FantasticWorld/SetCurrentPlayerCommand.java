package FantasticWorld;

import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class SetCurrentPlayerCommand extends RecordString implements Command {
    Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;
    Player player,lastPlayer;
    String msg = "Changed current player to ";

    public void execute() {
        System.out.print("\nPlease input player ID:- ");
        String playerID = scanner.nextLine().trim();
        System.out.println();
        for (Player p : players) {
            if (p.getPlayerID().equals(playerID)) {
                player = p;
                lastPlayer = ((RefCurrentPlayerAdapter) currentPlayer).getCurrentPlayer();
                ((RefCurrentPlayerAdapter) currentPlayer).setCurrentPlayer(p,msg);
                setRecordString("Set current player, " + p.getPlayerID() + ", " + p.getPlayerName());
                
                return;
            }
        }
        System.out.println("Player " + playerID + " is not found!!");
    }

    public void undo() {
        ((RefCurrentPlayerAdapter) currentPlayer).setCurrentPlayer(lastPlayer,msg);
    }
    public boolean redo() {
        ((RefCurrentPlayerAdapter) currentPlayer).setCurrentPlayer(player,msg);
        return true;
    }

    public SetCurrentPlayerCommand(Player currentPlayer, Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}