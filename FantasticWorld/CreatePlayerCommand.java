package FantasticWorld;

import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

public class CreatePlayerCommand extends RecordString implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;
    Player p, lastPlayer;
    String msg = "Current player is changed to ";
    public void execute() {
        if (p == null) {
            p = new PlayerFactory(scanner).create();
            lastPlayer = ((RefCurrentPlayerAdapter) currentPlayer).getCurrentPlayer();
        }
        players.add(p);
        ((RefCurrentPlayerAdapter) currentPlayer).setCurrentPlayer(p,msg);
        setRecordString("Create player, " + p.getPlayerID() + ", " + p.getPlayerName());
        commands.push(this);
    }

    public void undo() {
        players.remove(p);
        ((RefCurrentPlayerAdapter) currentPlayer).setCurrentPlayer(lastPlayer,msg);
    }
    public boolean redo() {
        players.add(p);
        ((RefCurrentPlayerAdapter) currentPlayer).setCurrentPlayer(p,msg);
        return true;
    }

    public CreatePlayerCommand(Player currentPlayer, Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}