package FantasticWorld;

import java.util.EmptyStackException;
import java.util.Stack;

public class RedoCommand implements Command {
    private Stack<Command> commands, redos;

    public void execute() {
        System.out.println();
        try {
            Command c = redos.pop();
            boolean is_done = c.redo();
            if (is_done) {
                System.out.println("Command (" + c.toString() + ") is redone.");
                commands.push(c);
            }
        } catch (EmptyStackException e) {
            System.out.println("No commands to redo");
        }
    }

    public void undo() {
    }

    public boolean redo() {
        return true;
    }

    public RedoCommand(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }
}