package FantasticWorld;

import java.util.Stack;

public class ListUndoRedoCommandFactory implements CommandFactory {

    private Stack<Command> commands, redos;

    public Command create() {
        return new ListUndoRedoCommand(commands, redos);
    }

    public ListUndoRedoCommandFactory(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }

}