package Model.Exceptions;

public enum Command {

    HELP("help", "SAVE - Saves current game\n"
            + "LOAD - Loads the game\n"
            + "EXIT - Exits game\n"),
    SAVE("save", "Save game"),
    LOAD("load", "Load game"),
    EXIT("exit", "Exit game");

    private String commandString;
    private String helpText;

    Command(String cmdS, String help) {
        commandString = cmdS;
        helpText = help;
    }

    public String getCommandString() {
        return commandString;
    }

    public String getHelpText() {
        return helpText;
    }
}