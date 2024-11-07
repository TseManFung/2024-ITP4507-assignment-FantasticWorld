package FantasticWorld;

import java.util.Stack;

public class ListUndoRedoCommand implements Command {
    private Stack<Command> commands, redos;

    public void execute() {

    }

    public void undo() {

    }

    public String toString() {
        return "listUndoRedo";
    }

    public ListUndoRedoCommand(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }
}