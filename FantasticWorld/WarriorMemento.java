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
    public void setRecordString() {
        Hero h = this.getHero();
        setRecordString(h.getHeroID() + 
        ", "+h.getHeroName() + ", Warrior, Hp: "+h.getHp() + 
        ", Damage: "+h.getDamage() + ", Defence: "+((Warrior)h).getDefencePoint());
    }
    public int[] getHeroData() {
        int[] data = new int[3];
        data[0] = this.getHp();
        data[1] = this.getDamage();
        data[2] = this.getDefencePoint();
        return data;
    }
}