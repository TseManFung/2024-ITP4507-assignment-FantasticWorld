package FantasticWorld;

public class WarlockFactory extends HeroFactory {
    public Hero createHero() {
        return new Warlock(heroInfo[0].trim(),heroInfo[1].trim());
    }
    
}
