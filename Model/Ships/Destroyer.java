package Model.Ships;

import Model.Field;
import Model.Location;

public class Destroyer extends Ship{


    public Destroyer(int length, int points, String letter, Field field, int[] start, ShipDirection direction) {
        super(length, points, letter, field, start, direction);
    }

    @Override
    public String getSinkMessage(){
        return "A Destroyer is sank!";
    }

    @Override
    void threaten() {

    }
}
