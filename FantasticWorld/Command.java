package FantasticWorld;
public interface Command {
    public void execute();
    public void undo();
    public boolean redo();
}
