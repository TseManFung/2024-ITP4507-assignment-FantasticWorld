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
    private Hero h;
    private HeroMemento heroMemento;

    public void execute() {
        if (((RefCurrentPlayerAdapter) currentPlayer).getCurrentPlayer() == null) {
            System.out.println("\nPlease create / select a player first.");
            return;
        }
        System.out.print("\nPlease input hero ID:- ");
        String heroID = scanner.nextLine().trim();
        System.out.println();
        for (Hero hero : currentPlayer.getHeroes()) {
            if (hero.getHeroID().equals(heroID)) {
                h = hero;
                heroMemento = makHeroMemento(hero);
                hero.callSkill();
                heroMemento.setRecordString();
                System.out.println(hero.getHeroID() + " " + hero.getHeroName() + "'s attributes are changed to:");
                hero.showHeroStatus();
                heroMemento.setRecordString();
                setRecordString("CallHeroSkill, " + heroMemento.getRecordString());
                commands.push(this);
                return;
            }
        }
    }

    public HeroMemento makHeroMemento(Hero hero) {
        HeroMemento heroMemento;
        String heroClass = hero.getClass().getSimpleName();
        try {
            heroMemento = (HeroMemento) Class.forName("FantasticWorld." + heroClass + "Memento")
                    .getConstructor(Class.forName("FantasticWorld." + heroClass)).newInstance(hero);
            heroMemento.save();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException
                | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return heroMemento;
    }

    public void undo() {
        heroMemento.restore();
    }

    public boolean redo() {
        // save for fail
        HeroMemento TempHeroMemento = makHeroMemento(h);

        int[] nowData = TempHeroMemento.getHeroData();
        int[] orgData = heroMemento.getHeroData();
        boolean diff = false;
        for (int i = 0; i < nowData.length; i++) {
            if (nowData[i] != orgData[i]) {
                diff = true;
                break;
            }
        }
        if (diff) {
            System.out.println("Hero's data is changed, can't redo.");
            return false;
        }
        h.callSkill();
        return true;
    }

    public CallHeroSkillCommand(Player currentPlayer, Stack<Command> commands, Vector<Player> players,
            Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.commands = commands;
        this.players = players;
        this.scanner = scanner;
    }
}