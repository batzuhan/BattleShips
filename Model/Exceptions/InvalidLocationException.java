package Model.Exceptions;

public class InvalidLocationException extends Exception {

    public InvalidLocationException() {
        super("InvalidLocationException!");
    }

    public InvalidLocationException(String s) {
        super(s);
    }
}
