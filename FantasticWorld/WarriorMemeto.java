package FantasticWorld;

import java.util.Stack;

public class WarriorMemeto extends HeroMemeto {
    private Stack<Integer> defencePoint = new Stack<Integer>();
    public WarriorMemeto(Warrior warrior) {
        super(warrior);
    }

    @Override
    public void restore() {
        super.restore();
        ((Warrior)this.getHero()).setDefencePoint(defencePoint.pop());
    }

    @Override
    public void save() {
        super.save();
        defencePoint.push(((Warrior)this.getHero()).getDefencePoint());
    }

}