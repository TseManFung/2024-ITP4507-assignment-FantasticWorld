package FantasticWorld;

public class WarriorFactory extends HeroFactory {
    public Hero createHero() {
        return new Warrior(heroInfo[0].trim(),heroInfo[1].trim());
    }
    
}
