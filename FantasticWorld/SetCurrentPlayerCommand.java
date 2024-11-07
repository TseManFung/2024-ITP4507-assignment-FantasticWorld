package FantasticWorld;


import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class SetCurrentPlayerCommand implements Command {
    Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;

    public void execute() {
        System.out.print("\nPlease input player ID:- ");
        String playerID = scanner.nextLine().trim();
        for (Player p : players) {
            if (p.getPlayerID().equals(playerID)) {
                currentPlayer = p;
                System.out.println("Changed current player to " + p.getPlayerID() + ".");
                commands.push(this);
                return;
            }
        }
    }

    public void undo() {

    }

    public String toString() {
        return "SetCurrentPlayer";
    }

    public SetCurrentPlayerCommand(Player currentPlayer,Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}