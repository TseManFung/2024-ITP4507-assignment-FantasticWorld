package FantasticWorld;
import java.util.Stack;

public class UndoCommand implements Command {
    private Stack<Command> commands, redos;

    public void execute() {
        Command c = commands.pop();
        c.undo();
        redos.push(c);
    }

    public void undo() {

    }

    public UndoCommand(Stack commands, Stack redos) {
        this.commands = commands;
        this.redos = redos;
    }
}
