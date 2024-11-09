package FantasticWorld;


import java.util.Vector;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Stack;

public class CallHeroSkillCommand extends RecordString implements Command {
    private Player currentPlayer;
    private Stack<Command> commands;
    private Vector<Player> players;
    private Scanner scanner;
    private HeroMemento heroMemento;

    public void execute() {
        System.out.print("\nPlease input hero ID:- ");
        String heroID = scanner.nextLine().trim();
        for (Hero hero: currentPlayer.getHeroes()){
            if (hero.getHeroID().equals(heroID)){
                String heroClass = hero.getClass().getSimpleName();
                try {
                    heroMemento = (HeroMemento) Class.forName("FantasticWorld."+heroClass+"Memento").getConstructor(Class.forName("FantasticWorld."+heroClass)).newInstance(hero);
                    heroMemento.save();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException | SecurityException
                        | ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return;
                }
                hero.callSkill();
                heroMemento.setRecordString();
                System.out.println(hero.getHeroID()+" "+hero.getHeroName()+"’s attributes are changed to:");
                hero.showHeroStatus();
                commands.push(this);
                return;
            }
        }

    }

    public void undo() {
        heroMemento.restore();
    }

    public String toString() {
        return "CallHeroSkill, "+heroMemento.getRecordString();
    }

    public CallHeroSkillCommand(Player currentPlayer,Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}