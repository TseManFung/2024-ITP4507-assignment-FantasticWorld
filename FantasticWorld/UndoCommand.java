package FantasticWorld;

import java.util.Stack;

public class UndoCommand implements Command {
    private Stack<Command> commands, redos;

    public void execute() {
        Command c = commands.pop();
        System.out.println("\nCommand ("+c.toString()+") is undone.");
        c.undo();
        redos.push(c);
    }

    public void undo() {
        return;
    }

    public UndoCommand(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }
}
