package FantasticWorld;

import java.util.Stack;

public abstract class CallHeroMemeto implements Memeto {
    private Hero hero;
    private Stack<Integer> hp = new Stack<Integer>(), damage = new Stack<Integer>();

    public void restore() {
        hero.setHp(hp.pop());
        hero.setDamage(damage.pop());
    }

    public void save() {
        hp.push(hero.getHp());
        damage.push(hero.getDamage());
    }

    public CallHeroMemeto(Hero hero) {
        this.hero = hero;
        save();
    }

    Hero getHero() {
        return hero;
    }
}
