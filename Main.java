import java.util.*;

import FantasticWorld.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Stack commands = new Stack();
        Stack redos = new Stack();
        HashMap<Player,ArrayList<Hero>> playerHeroes = new HashMap<Player,ArrayList<Hero>>();
        HashMap<String,CommandFactory> factories = new HashMap<String,CommandFactory>();
        
        /* c = create player, g = set current player, a = add hero, m = call hero skill, d = delete hero, s = show player, p = display all players, t = change player’s name, u = undo, r = redo, l = list undo/redo, x = exit system */
        // factories.put("c", );
        // factories.put("g", );
        // factories.put("a", );
        // factories.put("m", );
        // factories.put("d", );
        // factories.put("s", );
        // factories.put("p", );
        // factories.put("t", );
        // factories.put("u", );
        // factories.put("r", );
        // factories.put("l", );
        factories.put("x", new ExitCommandFactory());
        boolean playing =  true;
        Player currentPlayer = null;
        while (playing) {
            System.out.println("Fantastic World (FW)");
            System.out.println("c = create player, g = set current player, a = add hero, m = call hero skill, d = delete hero, s = show player, p = display all players, t = change player’s name, u = undo, r = redo, l = list undo/redo, x = exit system");
            if(currentPlayer != null){
                System.out.println("The current player is "+ currentPlayer.getPlayerID()+ " "+ currentPlayer.getPlayerName());
            }
            System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :-");
            String InputCom = scanner.next();
            Command com = factories.get(InputCom).create();
            com.execute();
        }
    }

}
