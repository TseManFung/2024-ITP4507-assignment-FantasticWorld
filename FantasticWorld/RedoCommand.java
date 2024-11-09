package FantasticWorld;

import java.util.EmptyStackException;
import java.util.Stack;

public class RedoCommand implements Command {
    private Stack<Command> commands, redos;

    public void execute() {
        try {
            Command c = redos.pop();
            System.out.println("Command (" + c.toString() + ") is redone.");
            c.redo();
            commands.push(c);
        } catch (EmptyStackException e) {
            System.out.println("No commands to redo");
        }
    }

    public void undo() {
    }
    public void redo() {}

    public RedoCommand(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }
}