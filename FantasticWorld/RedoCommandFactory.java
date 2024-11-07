package FantasticWorld;

import java.util.Stack;

public class RedoCommandFactory implements CommandFactory {
    private Stack<Command> commands;
    private Stack<Command> redos;

    public Command create() {
        return new RedoCommand(commands, redos);
    }

    public RedoCommandFactory(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }
}
