package FantasticWorld;
public abstract class HeroFactory implements Factory {
    String[] heroInfo;
    public Object create() {
        throw new UnsupportedOperationException();
    }
    public Hero create(String[] heroInfo) {
        this.heroInfo = heroInfo;
        Hero h= createHero();
        return h;
    }
    public abstract Hero createHero();
}
