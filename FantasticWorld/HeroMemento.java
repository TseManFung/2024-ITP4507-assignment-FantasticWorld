package FantasticWorld;

public abstract class HeroMemento extends RecordString implements Memento {
    private Hero hero;
    private int hp, damage;
    public void restore() {
        hero.setHp(hp);
        hero.setDamage(damage);
    }

    public void save() {
        hp = hero.getHp();
        damage = hero.getDamage();
    }

    public HeroMemento(Hero hero) {
        this.hero = hero;
        save();
    }

    Hero getHero() {
        return hero;
    }

    public int getHp() {
        return hp;
    }
    
    public int getDamage() {
        return damage;
    }
    public abstract void setRecordString();
}
