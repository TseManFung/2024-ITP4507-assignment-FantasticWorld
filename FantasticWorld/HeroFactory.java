package FantasticWorld;
import java.util.Scanner;
public class HeroFactory implements Factory {
    
    private Class<?>[] heroType;
    private Scanner scanner;
    public Hero create() {
        String s;
        System.out.println("\nPlease input hero information (id, name):- ");
        s = scanner.nextLine();
        String[] heroInfo = s.split(",");
        System.out.println("Hero Type (1 = Warrior | 2 = Warlock ):- ");
        int intHeroType = Integer.parseInt(scanner.nextLine());
        Hero h = null;
        try {
            if (intHeroType < 1 || intHeroType > heroType.length) {
                System.out.println("Invalid hero type.");
                return null;
            }
            heroType[intHeroType - 1].newInstance();
            h = (Hero) heroType[intHeroType - 1].getConstructor(String.class, String.class).newInstance(heroInfo[0],
                    heroInfo[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hero is added.");
        return h;
    }
    public HeroFactory( Class<?>[] heroType, Scanner scanner) {
        this.heroType = heroType;
        this.scanner = scanner;
    }
}
