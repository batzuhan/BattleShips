package Model.Exceptions;


public class MoveIsCommandException extends InvalidLocationException {
    private Command cmd ;

    public MoveIsCommandException(){
        super("MoveIsCommandException!");
    }

    public MoveIsCommandException(String s){
        super(s);
    }

    public void MoveIsCommandException(Command cmd){
        this.cmd = cmd;
    }

    public Command getCommand(){
        return cmd;
    }
}
