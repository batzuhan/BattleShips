package Model.Ships;

import Model.Field;
import Model.Location;

public class Submarine extends Ship {


    public Submarine(int length, int points, String letter, Field field, int[] start, ShipDirection direction) {
        super(length, points, letter, field, start, direction);
    }

    @Override
    public String getSinkMessage(){
        return "A Submarine is sank!";
    }

    @Override
    public void threaten() {

    }
}
