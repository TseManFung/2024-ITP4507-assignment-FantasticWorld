package FantasticWorld;

import java.util.Stack;

public class UndoCommandFactory implements CommandFactory {
    private Stack<Command> commands;
    private Stack<Command> redos;

    public Command create() {
        return new UndoCommand(commands, redos);
    }

    public UndoCommandFactory(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }

}
