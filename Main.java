

import java.util.*;

import FantasticWorld.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Command> commands = new Stack<Command>();
        Stack<Command> redos = new Stack<Command>();
        HashMap<Player, ArrayList<Hero>> playerHeroes = new HashMap<Player, ArrayList<Hero>>();
        HashMap<String, CommandFactory> factories = new HashMap<String, CommandFactory>();

        /*
         * c = create player, g = set current player, a = add hero, m = call hero skill,
         * d = delete hero, s = show player, p = display all players, t = change
         * player’s name, u = undo, r = redo, l = list undo/redo, x = exit system
         */
        factories.put("c", new CreatePlayerCommandFactory(commands, playerHeroes, scanner));
        factories.put("g", new SetCurrentPlayerCommandFactory(commands, playerHeroes, scanner));
        factories.put("a", new AddHeroCommandFactory(commands, playerHeroes, scanner));
        factories.put("m", new CallHeroSkillCommandFactory(commands, playerHeroes, scanner));
        factories.put("d", new DeleteHeroCommandFactory(commands, playerHeroes, scanner));
        factories.put("s", new ShowPlayerDetailCommandFactory(commands, playerHeroes, scanner));
        factories.put("p", new DisplayAllPlayersCommandFactory(commands, playerHeroes, scanner));
        factories.put("t", new ChangePlayerNameCommandFactory(commands, playerHeroes, scanner));
        factories.put("u", new UndoCommandFactory(commands, redos));
        factories.put("r", new RedoCommandFactory(commands, redos));
        factories.put("l", new ListUndoRedoCommandFactory(commands, redos));
        factories.put("x", new ExitCommandFactory());
        boolean playing = true;
        Player currentPlayer = null;
        while (playing) {
            System.out.println("Fantastic World (FW)");
            System.out.println(
                    "c = create player, g = set current player, a = add hero, m = call hero skill, d = delete hero, s = show player, p = display all players, t = change player’s name, u = undo, r = redo, l = list undo/redo, x = exit system");
            if (currentPlayer != null) {
                System.out.println(
                        "The current player is " + currentPlayer.getPlayerID() + " " + currentPlayer.getPlayerName());
            }
            System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :-");
            String InputCom = scanner.next();
            Command com = factories.get(InputCom).create();
            com.execute();
        }
    }

}
