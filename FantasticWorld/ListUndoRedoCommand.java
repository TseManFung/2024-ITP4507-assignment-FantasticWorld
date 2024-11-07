package FantasticWorld;

import java.util.Stack;

public class ListUndoRedoCommand implements Command {
    private Stack<Command> commands, redos;

    public void execute() {
        System.out.println("\nUndo List:");
        for (Command c : commands) {
            System.out.println(c.toString());
        }
        System.out.println("-- End of undo list --");
        System.out.println("Redo List:");
        for (Command c : redos) {
            System.out.println(c.toString());
        }
        System.out.println("-- End of redo list --");
    }

    public void undo() {
        return;
    }

    public String toString() {
        return "listUndoRedo";
    }

    public ListUndoRedoCommand(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }
}