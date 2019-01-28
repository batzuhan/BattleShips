package Model.Ships;

import Model.Field;
import Model.Location;

public class AircraftCarrier extends Ship{


    public AircraftCarrier(int length, int points, String letter, Field field, int[] start, ShipDirection direction) {
        super(length, points, letter, field, start, direction);
    }

    @Override
    public String getSinkMessage(){
        return "An AircraftCarrier is sank!";
    }

    @Override
    void threaten() {
        //it does not move.
    }
}
