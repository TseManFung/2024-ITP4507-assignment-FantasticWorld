package FantasticWorld;

import java.util.Stack;

public class ListUndoRedoCommand implements Command {
    private Stack<Command> commands, redos;

    public void execute() {
        System.out.println("\nUndo List:");
        for (int i = commands.size() - 1; i >= 0; i--) {
            System.out.println(commands.get(i).toString());
        }
        System.out.println("-- End of undo list --");
        System.out.println("Redo List:");
        for (int i = redos.size() - 1; i >= 0; i--) {
            System.out.println(redos.get(i).toString());
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