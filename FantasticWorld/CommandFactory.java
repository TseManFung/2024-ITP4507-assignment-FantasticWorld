package FantasticWorld;
/* public abstract class CommandFactory implements Factory {
    private String commandType;

    public Command createCommand() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class commandClass = Class.forName(commandType+"Command");
        Command command = (Command) commandClass.newInstance();
        return command;
    }

    public Command create() {
        try {
            return createCommand();
        } catch (Exception e) {
            System.err.println("Error creating command: " + commandType);
            e.printStackTrace();
            return null;
        }
    };

    public CommandFactory(String commandType) {
        this.commandType = commandType;
    }

} */
public interface CommandFactory extends Factory {

    public Command create();
}