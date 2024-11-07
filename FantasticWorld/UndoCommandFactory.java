package FantasticWorld;
import java.util.Stack;
public class UndoCommandFactory implements CommandFactory{
    private Stack commands;
    private Stack redos;
    public Command create(){
        return new UndoCommand(commands,redos);
    }
    public UndoCommandFactory(Stack commands, Stack redos){
        this.commands = commands;
        this.redos = redos;
    }

}
