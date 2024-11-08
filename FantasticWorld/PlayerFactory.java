package FantasticWorld;
import java.util.Scanner;
public class PlayerFactory implements Factory {
    private Scanner scanner;
    public Player create() {
        Player p;
        String id,name;
        System.out.print("\nPlayer ID:- ");
        id = scanner.nextLine().trim();
        System.out.print("Player Name:- ");
        name = scanner.nextLine().trim();
        p = new Player(id,name);
        System.out.println("\nPlayer " + p.getPlayerName() + " is created.");
        return p;
    }
    public PlayerFactory(Scanner scanner) {
        this.scanner = scanner;
    }
}
