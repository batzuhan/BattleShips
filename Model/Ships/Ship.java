package Model.Ships;

import Model.Field;

public abstract class Ship {
    private int length;
    private int points;
    private String letter;
    private Field field;
    public int[] start;
    private ShipDirection direction;
    private int counter;

    public Ship(int length, int points, String letter, Field field, int[] start, ShipDirection direction, int counter) {
        this.length = length;
        this.points = points;
        this.letter = letter;
        this.field = field;
        this.start = start;
        this.direction = direction;
        this.counter = counter;
    }

    public void hit() {
        ++counter;
        System.out.println(getHitMessage());
        if (isSinking()) {
            field.getPlayer().setScore(getPoints());
            System.out.println(getSinkMessage() + " " + getPoints() + " points.");
        }
    }

    public boolean isHit() {
        if (counter > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSinking() {
        if(this.getLetter().equals("A")){
            return (counter == length);
        }else if(this.getLetter().equals("S")){
            return (counter == 1);
        }else{
            return (counter == 2);
        }

    }

    public String getHitMessage() {
        return "A ship is hit by " + this.getField().getPlayer().getName() + ".";
    }

    abstract String getSinkMessage();

    public abstract void threaten();

    public int getLength() {
        return length;
    }

    public int getPoints() {
        return points;
    }


    public String getLetter() {
        return letter;
    }

    public void setField(Field field) {
        this.field = field;
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