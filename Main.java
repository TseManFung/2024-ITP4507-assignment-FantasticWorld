

import java.util.*;

import FantasticWorld.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Stack<Command> commands = new Stack<Command>();
        Stack<Command> redos = new Stack<Command>();
        Vector<Player> players = new Vector<Player>();
        HashMap<String, CommandFactory> factories = new HashMap<String, CommandFactory>();
        RefCurrentPlayerAdapter currentPlayer = new RefCurrentPlayerAdapter();
        
        boolean playing = true;
        Class<?>[] heroType;
        try {
            heroType = new Class<?>[]{ Class.forName("FantasticWorld.Warrior"), Class.forName("FantasticWorld.Warlock") };
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        /*
         * c = create player, g = set current player, a = add hero, m = call hero skill,
         * d = delete hero, s = show player, p = display all players, t = change
         * player’s name, u = undo, r = redo, l = list undo/redo, x = exit system
         */
        factories.put("c", new CreatePlayerCommandFactory(currentPlayer,commands, players, scanner));
        factories.put("g", new SetCurrentPlayerCommandFactory(currentPlayer,commands, players, scanner));
        factories.put("a", new AddHeroCommandFactory(currentPlayer,commands, heroType, scanner));
        factories.put("m", new CallHeroSkillCommandFactory(currentPlayer,commands, players, scanner));
        factories.put("d", new DeleteHeroCommandFactory(currentPlayer,commands, players, scanner));
        factories.put("s", new ShowPlayerDetailCommandFactory(currentPlayer,commands, players, scanner));
        factories.put("p", new DisplayAllPlayersCommandFactory(commands, players, scanner));
        factories.put("t", new ChangePlayerNameCommandFactory(currentPlayer,commands, players, scanner));
        factories.put("u", new UndoCommandFactory(commands, redos));
        factories.put("r", new RedoCommandFactory(commands, redos));
        factories.put("l", new ListUndoRedoCommandFactory(commands, redos));
        factories.put("x", new ExitCommandFactory());
        while (playing) {
            System.out.println("\nFantastic World (FW)");
            System.out.println(
                    "c = create player, g = set current player, a = add hero, m = call hero skill, d = delete hero, s = show player, p = display all players, t = change player’s name, u = undo, r = redo, l = list undo/redo, x = exit system");
            if (currentPlayer.getCurrentPlayer() != null) {
                System.out.println(
                        "The current player is " + currentPlayer.getPlayerID() + " " + currentPlayer.getPlayerName());
            }
            System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :-");
            String InputCom = scanner.nextLine().trim();
            if(!factories.containsKey(InputCom)){
                System.out.println("Invalid command: " + InputCom);
                continue;
            }
            Command com = factories.get(InputCom).create();
            com.execute();
        }
    }

}
