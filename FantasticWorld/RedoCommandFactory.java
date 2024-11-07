package FantasticWorld;
import java.util.Stack;
public class RedoCommandFactory implements CommandFactory{
    private Stack commands;
    private Stack redos;
    public Command create(){
        return new RedoCommand(commands,redos);
    }
    public RedoCommandFactory(Stack commands, Stack redos){
        this.commands = commands;
        this.redos = redos;
    }
}
