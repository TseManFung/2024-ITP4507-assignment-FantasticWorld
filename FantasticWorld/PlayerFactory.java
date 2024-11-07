package FantasticWorld;
import java.util.Scanner;
public class PlayerFactory implements Factory {
    private Scanner scanner;
    public Player create() {
        Player p;
        String s;
        System.out.print("\nPlayer ID:- ");
        s = scanner.nextLine().trim();
        p = new Player(s);
        System.out.print("Player Name:- ");
        s = scanner.nextLine().trim();
        p.setPlayerName(s);
        System.out.println("\nPlayer " + p.getPlayerName() + " is created.");
        return p;
    }
    public PlayerFactory(Scanner scanner) {
        this.scanner = scanner;
    }
}
