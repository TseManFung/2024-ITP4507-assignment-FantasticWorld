package FantasticWorld;

import java.util.Stack;

public class UndoCommand implements Command {
    private Stack<Command> commands, redos;

    public void execute() {
        System.out.println();
        try{
        Command c = commands.pop();
        System.out.println("Command ("+c.toString()+") is undone.");
        c.undo();
        redos.push(c);}
        catch(Exception e){
            System.out.println("No commands to undo");
        }
    }

    public void undo() {}
    public boolean redo() {
        return true;
    }

    public UndoCommand(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }
}
