package Model.Ships;

import Model.Field;

public abstract class Ship {
    private int length;//(the number of positions it occupies)
    private int points;
    private String letter;
    private Field field;
    public int[] start;
    private ShipDirection direction;
    private int counter;

    public Ship(int length, int points, String letter, Field field, int[] start, ShipDirection direction) {
        this.length = length;
        this.points = points;
        this.letter = letter;
        this.field = field;
        this.start = start;
        this.direction = direction;
    }

    public void hit(){
        counter++;
    }

    public boolean isHit(){
        if(counter>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isSinking(){
        return (counter == length);
    }

    public String getHitMessage() {
        return "A ship is hit.";
    }

    abstract String getSinkMessage();

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


    public int[] getStart() {
        return start;
    }

    public void setStart(int[] start) {
        this.start = start;
    }

    public ShipDirection getDirection() {
        return direction;
    }

    public void setDirection(ShipDirection direction) {
        this.direction = direction;
    }
}