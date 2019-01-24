package Model.Ships;

import Model.Field;

public abstract class Ship {
    private int length;//(the number of positions it occupies)
    private int points;
    private char letter;
    private Field field;
    private String start;
    private String direction;


    abstract void hit();
        //        Called when (any) position of the ship is hit.

    abstract void isHit();
        //        Checks whether the ship has been hit (on at least one position).

    abstract void isSinking();
        //   Check whether the ship has been sunk (all its positions have been hit).

    public void getHitMessage(){
        //code here
        //        Returns the message to be printed when a position of the ship is hit. This message should be the same for all ships.
    }
    abstract void getSinkMessage();
        //   Returns the message to be printed when the ship is sunk. This message must state the type of the ship.

    abstract void threaten();
        // Called when the ship is threatened and implements its reaction to the thread, as described above for each type of ship.

    public int getLength() {
        return length;
    }

    public int getPoints() {
        return points;
    }


    public char getLetter() {
        return letter;
    }


    public Field getField() {
        return field;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}