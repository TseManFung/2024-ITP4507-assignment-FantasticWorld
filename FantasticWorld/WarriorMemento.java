package FantasticWorld;

public class WarriorMemento extends HeroMemento {
    private int defencePoint;

    public WarriorMemento(Warrior warrior) {
        super(warrior);
    }

    @Override
    public void restore() {
        super.restore();
        ((Warrior) this.getHero()).setDefencePoint(defencePoint);
    }

    @Override
    public void save() {
        super.save();
        defencePoint = ((Warrior) this.getHero()).getDefencePoint();
    }

    public int getDefencePoint() {
        return defencePoint;
    }
}