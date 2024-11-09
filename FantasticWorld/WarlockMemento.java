package FantasticWorld;

public class WarlockMemento extends HeroMemento {
    private int mp;

    public WarlockMemento(Warlock warlock) {
        super(warlock);
    }

    @Override
    public void restore() {
        super.restore();
        ((Warlock) this.getHero()).setMp(mp);
    }

    @Override
    public void save() {
        super.save();
        mp = ((Warlock) this.getHero()).getMp();
    }

    public int getMp() {
        return mp;
    }


}
