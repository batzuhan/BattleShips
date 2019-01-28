package Model.Exceptions;


public class MoveIsCommandException extends InvalidLocationException {
    private Command cmd;

    public MoveIsCommandException() {
        super("MoveIsCommandException!");
    }

    public MoveIsCommandException(Command cmd) {
        super(cmd.getCommandString());
    }

    public void MoveIsCommandException(Command cmd) {
        this.cmd = cmd;
    }

    public Command getCommand() {
        return cmd;
    }
}
