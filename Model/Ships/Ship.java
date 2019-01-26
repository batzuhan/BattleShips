package Model.Ships;

import Model.Field;
import Model.Location;

public abstract class Ship {
    private int length;//(the number of positions it occupies)
    private int points;
    private String letter;
    private Field field;
    private Location start;
    private String direction;

    public Ship(int length, int points, String letter, Field field, Location start, String direction) {
        this.length = length;
        this.points = points;
        this.letter = letter;
        this.field = field;
        this.start = start;
        this.direction = direction;
    }

    public void hit(){

    }
        //        Called when (any) position of the ship is hit.

    public void isHit(){

    }
        //        Checks whether the ship has been hit (on at least one position).

    public void isSinking(){

    }
        //   Check whether the ship has been sunk (all its positions have been hit).

    public String getHitMessage() {
        return "A ship is hit.";
    }

    abstract void getSinkMessage();

    abstract void threaten();

    public int getLength() {
        return length;
    }

    public int getPoints() {
        return points;
    }


    public String getLetter() {
        return letter;
    }


    public Field getField() {
        return field;
    }


    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}