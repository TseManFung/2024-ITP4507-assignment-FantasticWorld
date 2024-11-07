package FantasticWorld;

import java.util.EmptyStackException;
import java.util.Stack;

public class RedoCommand implements Command {
    private Stack<Command> commands, redos;

    public void execute() {
        try {
            Command c = redos.pop();
            c.execute();
            commands.push(c);
        } catch (EmptyStackException e) {
            System.out.println("No commands to redo");
        }
    }

    public void undo() {
        return;
    }

    public RedoCommand(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }
}